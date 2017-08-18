package com.accenture.apiautomacao.sac.connection;

import com.accenture.apiautomacao.exception.mainframe.AplicacaoNaoEncontradaException;
import com.accenture.apiautomacao.exception.mainframe.conexao.ConexaoException;
import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
import com.accenture.apiautomacao.exception.mainframe.navegacao.ComandoException;
import com.accenture.apiautomacao.exception.usuario.DadosIncorretosException;
import com.accenture.apiautomacao.exception.usuario.SemPermissaoException;
import com.accenture.apiautomacao.exception.usuario.SenhaExpiradaException;
import com.accenture.apiautomacao.exception.usuario.SenhaInvalidaException;
import com.accenture.apiautomacao.exception.usuario.UsuarioNaoEncontradoException;
import com.accenture.apiautomacao.exception.usuario.UsuarioRevogadoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import static com.accenture.apiautomacao.sac.controller.Execucao.controleExec;
import static com.accenture.apiautomacao.sac.controller.Execucao.host;
import static com.accenture.apiautomacao.sac.controller.Execucao.mainFrame;
import static com.accenture.apiautomacao.sac.controller.Execucao.permLista;
import static com.accenture.apiautomacao.sac.controller.Execucao.usuarioSAC;
import com.accenture.apiautomacao.sac.model.ControleUsuario;

/**
 * Classe responsável por todas as funções primárias do SAC.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class Conexao {

    private String uf;
    private String numUf;
    private int quantTentativasConexao = 0;
    private int quantTentativasAcesso = 0;
    private int quantTentativasNumApp = 0;
    boolean deslogarApp = false;

    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Acessa uma aplicação para a UF informada no campo <b>this.uf</b>
     *
     * @throws AplicacaoNaoEncontradaException Não foi encontrada aplicação para
     * a UF
     * @throws MainFrameException Não foi possível selecionar uma aplicação para
     * a UF
     * @since 1.0.0
     */
    @SuppressWarnings("InfiniteRecursion")
    public void acessaUfNoSAC() throws AplicacaoNaoEncontradaException, MainFrameException {
        if (quantTentativasAcesso > 4) {
            quantTentativasAcesso = 0;
            throw new AplicacaoNaoEncontradaException("Máximo de tentativas de acessar uma aplicacao, excedido.");
        }

        log.info("Acessando a aplicação para a UF " + uf);

        if (!"APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
            quantTentativasAcesso++;

            if (host.queryStringAt(16, 13, "Matricula")) {
                logarUsuario();
            } else {
                conectarSAC();
            }

            acessaUfNoSAC();
        } else {
            try {
                numUf = pegaNumeroUF();

                if (numUf == null) {
                    throw new MainFrameException("O Número da Aplicação está NULL.");
                }
            } catch (MainFrameException ex) {
                quantTentativasAcesso++;
                conectarSAC();
                acessaUfNoSAC();
            }

            if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                if (deslogarApp) {
                    logoffAplicacao();
                    deslogarApp = false;
                    quantTentativasAcesso++;
                    conectarSAC();
                    acessaUfNoSAC();
                } else {
                    host.setStringAt(19, 29, numUf);
                    try {
                        host.sendEnterKeyWait(mainFrame.getTimeout());
                    } catch (RcNegativoException ex) {
                        quantTentativasAcesso++;
                        conectarSAC();
                        acessaUfNoSAC();
                    }

                    if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                        try {
                            host.sendEnterKeyWait(mainFrame.getTimeout());
                        } catch (RcNegativoException ex) {
                            quantTentativasAcesso++;
                            conectarSAC();
                            acessaUfNoSAC();
                        }
                    }
                }
            }

            if (host.queryStringAt(1, "Limpe a tela")
                    || host.queryStringAt(23, "EMS1389E")) {
                deslogarApp = true;
            }

            if (!host.queryStringAt(4, 72, "CG00000A")) {
                quantTentativasAcesso++;
                conectarSAC();
                acessaUfNoSAC();
            }
        }
    }

    /**
     * Abre uma conexão com o SAC, e em consequência já loga o usuário
     * previamente informado em <b>Execucao.usuarioSAC</b>
     *
     * @throws MainFrameException Não foi possível se conectar ao SAC.
     * @since 1.0.0
     */
    @SuppressWarnings("InfiniteRecursion")
    public void conectarSAC() throws MainFrameException {
        if (quantTentativasConexao > 4) {
            quantTentativasConexao = 0;
            throw new MainFrameException("Máximo de tentativas de login no SAC, excedido.");
        }

        log.info("Conectando no SAC");

        try {
            if (host.isConnected()) {
                host.Disconnect();
            }

//            mainFrame.setHostIP("TCSNET.BRASILTELECOM.COM.BR");
            mainFrame.setHostIP(usuarioSAC.getIdServidor().getEndereco());

            host.Connect(mainFrame.getHostIP());
            host.waitForTerminalReady(mainFrame.getTimeout());

            if (host.isConnected()) {
                host.printScreenContent();
                log.info("[SUCESSO] Conectado em " + mainFrame.getHostIP()); //Gravando Log
            } else {
                throw new ConexaoException("Não foi possível conectar em: " + mainFrame.getHostIP());
            }

            if (host.queryStringAt(16, 13, "Matricula")) {
                logarUsuario();
            } else {
                throw new ConexaoException("Conexão SAC não chegou até a tela de login.");
            }

            quantTentativasConexao = 0;
        } catch (ConexaoException ex) {
            quantTentativasConexao++;

            conectarSAC();
        }
    }

    /**
     * Busca por um número de aplicação para a UF previamente informada em
     * <b>this.uf</b>.
     *
     * @return O número da aplicação correspondente a UF.
     * @throws MainFrameException Não conseguiu encontrar uma aplicação para a
     * UF.
     * @since 1.0.0
     */
    private String pegaNumeroUF() throws MainFrameException {
        int linha = 7, quantPaginacao = 1;

        log.info("Pegando número da aplicação da UF " + uf);

        while (!host.getScreenContentAt(linha, 9, 1).trim().isEmpty()) {

            if (quantTentativasNumApp > 4) {
                quantTentativasNumApp = 0;
                throw new AplicacaoNaoEncontradaException("Não existe aplicação para a UF: " + uf);
            }

            if (uf.equals(host.getScreenContentAt(linha, 9, 2).trim())) {
                numUf = host.getScreenContentAt(linha, 4, 3).trim();

                try {
                    Integer.parseInt(numUf);
                    return numUf;
                } catch (NumberFormatException ex) {
                    linha = 6;
                    quantPaginacao = 0;
                    quantTentativasNumApp++;
                }
            } else if (linha == 16) {
                if (quantPaginacao < 3) {
                    host.sendPFKeyWait(8, mainFrame.getTimeout());
                    linha = 6;
                    quantPaginacao++;
                } else {
                    if (!host.getScreenContentAt(7, 4, 3).trim().equals("1")) {
                        host.sendPFKeyWait(7, mainFrame.getTimeout());
                    }

                    linha = 6;
                    quantPaginacao = 0;
                    quantTentativasNumApp++;
                }
            }

            linha++;
        }

        quantTentativasNumApp = 0;

        return null;
    }

    /**
     * Realiza login com o usuário previamente informado em
     * <b>Execucao.usuarioSAC</b>.
     *
     * @throws MainFrameException Não foi possível logar com o usuário.
     * @since 1.0.0
     */
    @SuppressWarnings("InfiniteRecursion")
    public void logarUsuario() throws MainFrameException {
        if (quantTentativasConexao > 4) {
            quantTentativasConexao = 0;
            usuarioSAC.desaloca();
            host.Disconnect();
            throw new MainFrameException("Máximo de tentativas de login no SAC, excedido.");
        }

        log.info("Logando o usuário " + usuarioSAC.getUsuario());

        try {
            if (!host.queryStringAt(16, 13, "Matricula")) {
                host.printScreenContent();
                throw new ComandoException("Comando não reconhecido: " + mainFrame.getCanal());
            } else {
                host.setStringAt(16, 35, usuarioSAC.getUsuario());
                host.setStringAtPassword(17, 35, usuarioSAC.getSenhaDescriptografada());

                try {
                    host.sendEnterKeyWait(mainFrame.getTimeout());
                } catch (RcNegativoException ex) {
                    quantTentativasConexao++;
                    conectarSAC();
                    acessaUfNoSAC();
                }

                if (!"APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                    String msgErroConnSAC = host.getScreenContentAt(23, 2, 60).trim();

                    if (msgErroConnSAC.contains("Senha nao confere")) {
                        host.printScreenContent();
                        throw new SenhaInvalidaException();
                    }

                    if (msgErroConnSAC.contains("Senha expirada")) {
                        host.printScreenContent();
                        throw new SenhaExpiradaException();
                    }

                    if (msgErroConnSAC.contains("Usuario revogado")) {
                        host.printScreenContent();
                        throw new UsuarioRevogadoException();
                    }

                    if (msgErroConnSAC.contains("logged")) {
                        host.printScreenContent();
                        throw new DadosIncorretosException(msgErroConnSAC);
                    }

                    if (msgErroConnSAC.contains("user")) {
                        host.printScreenContent();
                        throw new DadosIncorretosException(msgErroConnSAC);
                    }

                    if (msgErroConnSAC.contains("Wrong password")) {
                        host.printScreenContent();
                        throw new SenhaInvalidaException();
                    }

                    if (msgErroConnSAC.contains("not authorized")) {
                        host.printScreenContent();
                        throw new SemPermissaoException();
                    }
                }
            }

            quantTentativasConexao = 0;
        } catch (SenhaInvalidaException | UsuarioRevogadoException
                | DadosIncorretosException | SenhaExpiradaException ex) {
            try {
                usuarioSAC.tornaIndisponivel(ex.getMessage());
                quantTentativasConexao++;
                usuarioSAC = ControleUsuario.alocaUsuario(controleExec, permLista);
            } catch (UsuarioNaoEncontradoException ex1) {
                throw new RuntimeException("Não foi possível alocar outro usuário.");
            }

            logarUsuario();
        } catch (SemPermissaoException ex) {
            ControleUsuario usuario = usuarioSAC;

            log.error("Problemas com o usuário " + usuarioSAC.getUsuario());

            try {
                quantTentativasConexao++;
                usuarioSAC = ControleUsuario.alocaUsuario(controleExec, permLista);
            } catch (UsuarioNaoEncontradoException ex1) {
                throw new RuntimeException("Não foi possível alocar outro usuário.");
            }

            usuario.desaloca();

            logarUsuario();
        } catch (ComandoException ex) {
            quantTentativasConexao++;
            logarUsuario();
        }
    }

    /**
     * Realiza logoff do usuário atualmente conectado à aplicação.
     *
     * @since 1.0.0
     */
    public void logoffUsuario() {
        try {
            host.sendPFKeyWait(10, mainFrame.getTimeout());

            log.info("Realizando logoff do usuário " + usuarioSAC.getUsuario());

            if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                host.setStringAt(19, 29, "LOGOFF");

                host.sendEnterKeyWait(mainFrame.getTimeout());
            }
        } catch (RcNegativoException ex) {
            log.warn("Não realizou o logoff do usuário.");
        }
    }

    /**
     * Realiza logoff da aplicação atualmente em utilização.
     *
     * @since 1.0.0
     */
    public void logoffAplicacao() {
        try {
            host.sendPFKeyWait(10, mainFrame.getTimeout());

            log.error("Realizando logoff da aplicação " + numUf + " - UF: " + uf);

            if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                host.setStringAt(19, 29, "LOGOFF " + numUf);

                host.sendEnterKeyWait(mainFrame.getTimeout());
            }
        } catch (RcNegativoException ex) {
            log.warn("Não realizou o logoff da aplicação.");
        }
    }

    /**
     * Desconecta do SAC.
     *
     * @since 1.0.0
     */
    public void desconectarSac() throws RcNegativoException {
        log.info("Fechando conexão com o SAC.");

        if (host.isConnected()) {
            host.Disconnect();
        }
    }

}

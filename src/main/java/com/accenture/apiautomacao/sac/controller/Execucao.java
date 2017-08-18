package com.accenture.apiautomacao.sac.controller;


import com.accenture.apiautomacao.sac.connection.Conexao;
import com.accenture.apiautomacao.exception.usuario.UsuarioNaoEncontradoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.model.ControleExecucao;
import com.accenture.apiautomacao.model.MainFrame;
import com.accenture.apiautomacao.model.TerminalWrapper;
import com.accenture.apiautomacao.sac.model.ControleUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por toda a execução que utiliza acesso ao SAC.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class Execucao {

    public static TerminalWrapper host;
    public static MainFrame mainFrame;
    public static ControleUsuario usuarioSAC;
    public static ControleExecucao controleExec;
    public static List<String> permLista = new ArrayList<>();
    public static String tituloTela;
    public static Conexao conexaoSAC;

    /**
     * Inicializa um novo processo e todas as suas dependencias.
     *
     * @param permLista Lista com as permissões desejadas.
     * @param nomeProcesso nome do Processo a ser iniciado.
     * @since 1.0.0
     */
    @SuppressWarnings({"static-access", "ResultOfObjectAllocationIgnored"})
    public void Start(String nomeProcesso, List<String> permLista) throws UsuarioNaoEncontradoException {
        log.info("Iniciando uma execução pela API.");

        controleExec = new ControleExecucao();
        controleExec.inicializaControleExecucao(nomeProcesso);

        this.permLista = permLista;

        configuraDependencias();
    }

    /**
     * Inicia as dependencias de um processo já iniciado.
     *
     * @param permLista Lista com as permissões desejadas.
     * @param processo Controle Execucao já iniciado.
     * @since 1.0.0
     */
    @SuppressWarnings({"static-access", "ResultOfObjectAllocationIgnored"})
    public void Start(ControleExecucao processo, List<String> permLista) throws UsuarioNaoEncontradoException {
        log.info("Iniciando uma execução pela API.");

        controleExec = processo;

        this.permLista = permLista;

        configuraDependencias();
    }

    /**
     * Inicia as dependencias de um processo já iniciado sem executar o SAC.
     *
     * @param permLista Lista com as permissões desejadas.
     * @param processo Controle Execucao já iniciado.
     * @since 1.0.0
     */
    @SuppressWarnings({"static-access", "ResultOfObjectAllocationIgnored"})
    public void StartNoSAC(ControleExecucao processo, List<String> permLista) throws UsuarioNaoEncontradoException {
        log.info("Iniciando uma execução pela API.");

        controleExec = processo;

        this.permLista = permLista;

        configuraDependenciasNoSAC();
    }

    /**
     * Configura toda a Execução
     *
     * @since 1.0.0
     */
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void configuraDependencias() throws UsuarioNaoEncontradoException {
        try {
            log.info("Configurando dependências da execução pela API.");

            host = new TerminalWrapper();
            mainFrame = new MainFrame();

            log.info("Exibe Tela SAC? " + controleExec.getNomeProcesso().getExibeTelaSAC());

            host.setExibeTelaSAC(charToBool(controleExec.getNomeProcesso().getExibeTelaSAC()));

            //Cria o log baseado no Nivel do Log do controle Processo
            if (tituloTela == null) {
                host.setTitleTelaSAC("Visão SAC");
            } else {
                host.setTitleTelaSAC("Visão SAC - " + tituloTela);
            }

            usuarioSAC = ControleUsuario.alocaUsuario(controleExec, permLista);

            conexaoSAC = new Conexao();
        } catch (RuntimeException ex) {
            throw new RuntimeException("Não foi possível iniciar a execução: " + ex.getMessage());
        }
    }

    /**
     * Encerra a execução.
     *
     * @since 1.0.0
     */
    public void stop() {
        usuarioSAC.desaloca();
    }

    /**
     * Transforma <b>char</b> em <b>boolean</b>.
     *
     * @param c Char a ser transformado.
     * @return
     * <p>
     * <b>TRUE</b> - Caso o <b>char</b> seja <i>Y</i> ou <i>S</i>.</p>
     * <p>
     * <b>False</b> - Caso o <b>char</b> seja <i>N</i>.</p>
     * @since 1.0.0
     */
    public static boolean charToBool(char c) {
        c = Character.toUpperCase(c);
        switch (c) {
            case 'Y':
            case 'S':
                return true;
            case 'N':
                return false;
            default:
                throw new IllegalArgumentException("EXIBE_TELA_SAC somente pode conter os valores 'Y', 'S' ou 'N'.");
        }
    }

    /**
     * Pega o título da Tela SAC.
     *
     * @return O título da Tela.
     * @since 1.0.0
     */
    public String getTituloTela() {
        return tituloTela;
    }

    /**
     * Seta um novo título para a Tela
     *
     * @param tituloTela Novo título para a Tela.
     * @since 1.0.0
     */
    public void setTituloTela(String tituloTela) {
        this.tituloTela = tituloTela;
    }

    private void configuraDependenciasNoSAC() throws UsuarioNaoEncontradoException {
        try {
            log.info("Configurando dependências da execução pela API.");
            usuarioSAC = ControleUsuario.alocaUsuario(controleExec, permLista);

        } catch (RuntimeException ex) {
            throw new RuntimeException("Não foi possível iniciar a execução: " + ex.getMessage());
        }
    }

}

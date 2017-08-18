package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.OpcaoSuspensaNaoEncontradaException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// *
// * @author vanessa.m.azevedo
// */
//public class TelaHDCA extends Tela {
//    
//    private final String comando = "24,6,HDCA";
//    private final String nomeTela = "H.D.C.A";
//    private final String codTela = "CGHDCA0A";
//
//    private final String posicaoTerminal = "6,20";
//    private final String posicaoOpcao = "18,45,2";
//    private final String posicaoSim = "12,21";
//    private final String posicaoNao = "21,14";
//    
//    /**
//     * Digita o comando HDCA na linha do CMD do SAC, efetuando assim a abertura da
//     * tela Fila de Execucao - CGHDCA0A
//     * <p>
//     * Nome Tela.: GERACAO ORDEM SERVICO/REPARO
//     * <p>
//     * Codigo Tela.: CGHDCA0A
//     * <p>
//     * Sigla Tela.:H.D.C.A
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//    
//    public void setTerminal(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoTerminal, valor);
//    }
//    
//    public void setConsultaADSL() throws OpcaoSuspensaNaoEncontradaException, RcNegativoException {
//        
//        Tela tela = new Tela();
//        tela.marcaOpcaoSuspensa(20, 54, 37, 39, "E", "1", "PARA CONSULTA ADSL TURBO DIGITE 'S'");
//    }
//    
//    public void setOpcao() throws OpcaoSuspensaNaoEncontradaException, RcNegativoException {
//        
//        host.setStringAt(posicaoOpcao);
//    }    
//    
//    public void setSim() throws OpcaoSuspensaNaoEncontradaException, RcNegativoException { 
//        host.setStringAt(posicaoSim, "X");
//    }
//    
//    public void setNao() throws OpcaoSuspensaNaoEncontradaException, RcNegativoException {  
//        host.setStringAt(posicaoNao, "X");
//    }
//
//
//    /**
//     * Função que insere uma observação na tela HDCA para a tramitação do BD.
//     * 
//     * @param valor Observação a ser inserida na tramitação.
//     * @throws RcNegativoException Caso haja algum erro durante a execução dos comando no mainframe.
//     * @throws MainFrameException Caso haja algum erro durante a execução do mainframe.
//     * @since 1.0.0
//     */
//    public void setObservacao(String valor) throws RcNegativoException, MainFrameException {
//        
//        Integer linhaInicial, colunaInicial;
//        Tela tela = new Tela();
//        linhaInicial = 13;
//        colunaInicial = 34;        
//        setandoObservacao(valor, linhaInicial, colunaInicial);
//        
//    }
//    
//    private void setandoObservacao(String valor, Integer linhaInicial, Integer colunaInicial) throws RcNegativoException {
//        if (valor.length() > 70) {
//            host.setStringAt(linhaInicial, colunaInicial, valor.substring(0, 69));
//            if (valor.length() > 140) {
//                host.setStringAt(linhaInicial+1, colunaInicial, valor.substring(70, 139));
//                if (valor.length() > 210) {
//                    host.setStringAt(linhaInicial+2, colunaInicial, valor.substring(140, 209));
//                } else {
//                    host.setStringAt(linhaInicial+2, colunaInicial, valor.substring(140));
//                }
//            } else {
//                host.setStringAt(linhaInicial+1, colunaInicial, valor.substring(70));
//            }
//        } else {
//            host.setStringAt(linhaInicial, colunaInicial, valor);
//        }
//    }
//}
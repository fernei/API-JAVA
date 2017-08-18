package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>IA</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class TelaIA extends Tela {
//
//    /*FILA DE EXECUCAO - CGIA000A*/
//    private final String comando = "24,6,IA";
//    private final String nomeTela = "IA";
//    private final String codTela = "CGIA000A";
//
//    private final String posicaoCrEst = "5,9";
//    private final String posicaoUnid = "5,19";
//    private final String posicaoOsBd = "5,46";
//    private final String posicaoTelefone = "21,11";
//
//    /**
//     * Digita o comando IA na linha do CMD do SAC, efetuando assim a abertura da
//     * tela Fila de Execucao - CGIA000A
//     * <p>
//     * Nome Tela.: FILA DE EXECUCAO
//     * <p>
//     * Codigo Tela.: CGIA000A
//     * <p>
//     * Sigla Tela.:I.A
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setCrEst(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoCrEst, valor);
//    }
//
//    /**
//     * Função que insere uma observação na tela IA para a tramitação do BD.
//     * 
//     * @param valor Observação a ser inserida na tramitação.
//     * @throws RcNegativoException Caso haja algum erro durante a execução dos comando no mainframe.
//     * @throws MainFrameException Caso haja algum erro durante a execução do mainframe.
//     * @since 1.0.0
//     */
//    public void setObservacao(String valor) throws RcNegativoException, MainFrameException {
//        Integer linhaInicial, colunaInicial;
//
//        Tela tela = new Tela();
//        
//        switch (tela.getCodigoTela()) {
//            case "CG01502A":
//                linhaInicial = 18;
//                break;
//            case "CGIA054A":
//            case "CG01554A":
//                linhaInicial = 19;
//                break;
//            default:
//                throw new MainFrameException("A tela atual não se encontra dentro do fluxo de tramitação pela IA.");
//        }
//        
//        colunaInicial = 6;
//        
//        setandoObservacao(valor, linhaInicial, colunaInicial);
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
//
//
//    public void setUnid(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoUnid, valor);
//    }
//
//    public void setOsBd(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoOsBd, valor);
//    }
//
//    public void setTelefone(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoTelefone, valor);
//    }
//
//}

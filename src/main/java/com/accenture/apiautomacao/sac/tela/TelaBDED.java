package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>BDED</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class TelaBDED extends Tela {
//
//    /* CONSULTA DE AGENDAMENTO DE OS/BD - CGBDED0A*/
//    private final String codTela = "CGBDED0A";
//    private final String nomeTela = "BDED";
//    public final String comando = "24,6,BDED";
//    public final String posicaoBdSemAgendamento = "1,2,BD SEM AGENDAMENTO";
//    public final String posicaoBdNaoEncontrado = "1,2,BD NAO ENCONTRADO";
//    public final String posicaoOsSemAgendamento = "1,2,OS SEM AGENDAMENTO";
//    public final String posicaoMensagemF4 = "1,2,FAVOR TECLAR PF4 PARA PESQUISA";
//
//    /*CONSULTA DE AGENDAMENTO DE OS/BD  - CGBDED0B */
//    public final String posicaoDataHoraCriouAgendamento = "17,30,19";
//    public final String posicaoDataHoraInicioAgendamento = "14,22,19";
//    public final String posicaoDataHoraFimAgendamento = "14,44,19";
//    public final String posicaoNumeroDoBA = "8,57,15";
//
//    /**
//     * Digita o comando BDED na linha do CMD do SAC, efetuando assim a abertura
//     * da tela BDED
//     * <p>
//     * Nome Tela.: ESTATISTICA DA FILA DE EXECUCAO OS/BD
//     * <p>
//     * Codigo Tela.: CGBDEB0A
//     * <p>
//     * Sigla Tela.: B.D.E.D
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    /**
//     * Informa qual o tipo de consulta deve ser realizada.
//     *
//     * @param tipoconsulta BD - Bilhete de Defeito ou OS - Ordem de Serviço
//     * @since 1.0.0
//     */
//    public void setTipoConsulta(String tipoconsulta) throws RcNegativoException {
//        host.setStringAt(9, 18, tipoconsulta);
//    }
//
//    public void setNumeroOsBd(String numero) throws RcNegativoException {
//        host.setStringAt(11, 20, numero);
//    }
//
//    /**
//     * Retorna a Data e hora que o Agendamento foi criado
//     *
//     * @return String contendo a data e a hora que o agendamento foi criado
//     * @since 1.0.0
//     */
//    public String getDataHoraCriouAgendamento() {
//        return host.getScreenContentAt(posicaoDataHoraCriouAgendamento).trim();
//    }
//
//    /**
//     * Retorna a Data e hora de início do Agendamento
//     *
//     * @return String contendo a data e a hora de início do Agendamento
//     * @since 1.0.0
//     */
//    public String getDataHoraInicioAgendamento() {
//        return host.getScreenContentAt(posicaoDataHoraInicioAgendamento).trim();
//    }
//
//    /**
//     * Retorna a Data e hora de fim do Agendamento
//     *
//     * @return String contendo a data e a hora de fim do Agendamento
//     * @since 1.0.0
//     */
//    public String getDataHoraFimAgendamento() {
//        return host.getScreenContentAt(posicaoDataHoraFimAgendamento).trim();
//    }
//
//    /**
//     * Função que verifica se existe dados de Agendamento
//     *
//     * @return True ou False
//     * @since 1.0.0
//     */
//    public boolean possuiAgendamento() {
//        return !(host.queryStringAt(posicaoBdSemAgendamento)
//                || host.queryStringAt(posicaoOsSemAgendamento)
//                || host.queryStringAt(posicaoBdNaoEncontrado));
//    }
//
//    /**
//     * Fução que verifica a necessidade de clicar F4 ao tentar acessar os dados
//     * de agendamento
//     *
//     * @return True ou False
//     * @since 1.0.0
//     */
//    public boolean favorTeclarF4() {
//        return host.queryStringAt(posicaoMensagemF4);
//    }
//
//    /**
//     * Retorna o numero do BA para o agendamento consultado
//     *
//     * @return String com o numero do BA
//     * @since 1.0.0
//     */
//    public String getNumeroDoBA() {
//        return host.getScreenContentAt(posicaoNumeroDoBA);
//    }
//}

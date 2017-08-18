package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>9ANOC</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class Tela9ANPI extends Tela {
//
//    private final String nomeTela = "9ANPI";
//    private final String codTela = "CG9ANPIA";
//    private final String comando = "24,6,9ANPI";
//    
//    private final String posicaoIncEstacao = "6,11";
//    private final String posicaoIncUf = "6,28";
//    private final String posicaoIncDdd = "6,43";
//    private final String posicaoIncAte4Pos = "6,54";
//    private final String posicaoIncLocalidade = "6,72";
//    private final String posicaoIncDslam = "7,11";
//    private final String posicaoIncAte11Pos = "7,28";
//    private final String posicaoIncProvedor = "7,54";
//    private final String posicaoIncTipo = "8,11,16";
//    private final String posicaoIncSituacao = "8,38";
//    private final String posicaoIncNrOcor = "8,71,10";
//    private final String posicaoIncInicio = "9,11";
//    private final String posicaoIncPrevisao = "9,38";
//    private final String posicaoIncTermino = "9,65,15";
//    private final String posicaoIncProgramada = "10,14";
//    private final String posicaoIncGrauPriori = "10,48";
//    private final String posicaoIncTelContato = "19,20";
//    private final String posicaoIncEndereco = "18,20";
//    
//    private final String posicaoIncDefeito = "12,20";
//    private final String posicaoIncInfoCallCenter = "15,20";
//    private final String posicaoIncObservacao = "20,20";
//    
//    private final String mensagemErro = "1,2,80";
//    
//
//    /**
//     * Digita o comando <b>9ANPI</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>9ANPI</b>.
//     * <p>
//     * Nome Tela.: INCLUSÃO OCORRÊNCIA DE ADSL
//     * <p>
//     * Codigo Tela.: CG9ANPIA
//     * <p>
//     * Sigla Tela.:9.A.N.P.I
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setEstacao(String estacao) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncEstacao, estacao);
//    }
//
//    public void setUf(String uf) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncUf, uf);
//    }
//
//    public void setDdd(String ddd) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncDdd, ddd);
//    }
//
//    public void setAte4Pos(String ate) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncAte4Pos, ate);
//    }
//
//    public void setLocalidade(String localidade) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncLocalidade, localidade);
//    }
//
//    public void setDslam(String dslam) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncDslam, dslam);
//    }
//
//    public void setAte11Pos(String ate) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncAte11Pos, ate);
//    }
//
//    public void setProvedor(String provedor) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncProvedor, provedor);
//    }
//
//    public String getTipo() {
//        return host.getScreenContentAt(this.posicaoIncTipo).trim();
//    }
//
//    public void setSituacao(String situacao) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncSituacao, situacao);
//    }
//
//    public String getNrOcor() throws RcNegativoException {
//        return host.getScreenContentAt(this.posicaoIncNrOcor).trim();
//    }
//
//    public void setInicio(String inicio) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncInicio, inicio);
//    }
//
//    public void setPrevisao(String previsao) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncPrevisao, previsao);
//    }
//
//    public String getTermino() {
//        return host.getScreenContentAt(this.posicaoIncTermino).trim();
//    }
//
//    public void setProgramada(String programada) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncProgramada, programada);
//    }
//
//    public void setGrauPriori(String grauPriori) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncGrauPriori, grauPriori);
//    }
//
//    public void setTelContato(String telContato) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncTelContato, telContato);
//    }
//
//    public void setEndereco(String endereco) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncEndereco, endereco);
//    }
//
//    public void setDefeito(String defeito) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncDefeito, defeito);
//    }
//
//    public void setInfoCallCenter(String infoCallCenter) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncInfoCallCenter, infoCallCenter);
//    }
//
//    public void setObservacao(String observacao) throws RcNegativoException {
//        host.setStringAt(this.posicaoIncObservacao, observacao);
//    }
//    
//    public String getMensagemErro() {
//        return host.getScreenContentAt(1, 2, 80).trim();
//    }
//
//    public boolean validaMensagemInclusao() {
//        return host.queryStringAt(22, "INCLUSAO EFETUADA");
//    }
//}

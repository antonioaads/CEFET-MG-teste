package Serviços;

/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

public class Servico {
    
    private String tipoServico;
    private String observacaoServico;       // 0 para inativo e 1 para ativo
    
    public Servico() {
    }

    public Servico(String tipoServico, String observacaoServico) {
        this.tipoServico = tipoServico;
        this.observacaoServico = observacaoServico;
    }

    public String getObservacaoServico() {
        return observacaoServico;
    }

    public void setObservacaoServico(String observacaoServico) {
        this.observacaoServico = observacaoServico;
    }
    

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

  
}

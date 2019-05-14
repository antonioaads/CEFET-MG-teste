/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package Serviços;

public class ServicoOrcado {
    private Servico Servico;
    private String Profissional;       // 0 para inativo e 1 para ativo
    private String Preco;

    
    public ServicoOrcado() {
    }

    public ServicoOrcado(Servico Servico, String Profissional, String Preco) {
        this.Servico = Servico;
        this.Profissional = Profissional;
        this.Preco = Preco;
    }

    public Servico getServico() {
        return Servico;
    }

    public String getProfissional() {
        return Profissional;
    }

    public String getPreco() {
        return Preco;
    }

    public void setServico(Servico Servico) {
        this.Servico = Servico;
    }

    public void setProfissional(String Profissional) {
        this.Profissional = Profissional;
    }

    public void setPreco(String Preco) {
        this.Preco = Preco;
    }
    
    
    
}

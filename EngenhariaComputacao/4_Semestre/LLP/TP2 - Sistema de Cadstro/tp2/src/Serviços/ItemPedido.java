/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package Serviços;

public class ItemPedido {
    private ServicoOrcado Servico;
    private String Cliente;
    private String Pedido;
    private String Status;
    
    public ItemPedido() {
    }

    public ItemPedido(ServicoOrcado Servico, String Cliente, String Pedido, String Status) {
        this.Servico = Servico;
        this.Cliente = Cliente;
        this.Pedido = Pedido;
        this.Status = Status;
    }

    public ServicoOrcado getServico() {
        return Servico;
    }

    public String getCliente() {
        return Cliente;
    }

    public String getPedido() {
        return Pedido;
    }

    public String getStatus() {
        return Status;
    }

    public void setServico(ServicoOrcado Servico) {
        this.Servico = Servico;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public void setPedido(String Pedido) {
        this.Pedido = Pedido;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }  
    
}

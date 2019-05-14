/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package Usuario;

public class Usuario {
    
    protected String usuario;
    protected String nome;
    protected String senha; 
    protected String telefone;
    protected String email;
    protected String endereco;
    
    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(String usuario, String senha, String nome, String endereco, String telefone, String email){
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getTelefone(){
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }    
    
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }    
}

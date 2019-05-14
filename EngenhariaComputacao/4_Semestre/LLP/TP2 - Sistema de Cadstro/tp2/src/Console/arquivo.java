/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package Console;
import Usuario.*;
import Serviços.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class arquivo {
    private ArrayList<Usuario> Usuarios;
    private ArrayList<Servico> Servicos;
    private ArrayList<Servico> ServicosAtivados;
    private ArrayList<ServicoOrcado> ServicosOrcados;
    private ArrayList<ItemPedido> Pedidos;
    
    BufferedReader buffReadUsers;
    
    public arquivo() throws FileNotFoundException{
        Usuarios = new ArrayList();
        Servicos = new ArrayList();
        ServicosAtivados = new ArrayList();
        ServicosOrcados = new ArrayList();
        Pedidos = new ArrayList();
    }
    
    private void le_arquivo_usuario() throws IOException{
        FileReader arq = new FileReader("usuarios.txt");
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        Usuario Inserir = null;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length==7){
                if(dados[6].equals("Administrador")){
                    Inserir = new Administrador(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                }
                else if(dados[6].equals("Cliente")){
                    Inserir = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                }
                else if(dados[6].equals("Profissional")){
                    Inserir = new Profissional(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
                }
            
                Usuarios.add(Inserir);
            }
            linha = buffReadUsers.readLine(); //Para ler a próxima linha          
        }
        arq.close();
    }
    
    private void atualiza_arquivo_usuario() throws IOException{
        File file = new File( "usuarios.txt" );
        file.delete();
        
        FileWriter arq = new FileWriter("usuarios.txt", true);
        PrintWriter gravador = new PrintWriter(arq);
        
        gravador.println(); //Pular uma linha no arquivo
        
        for (Iterator iterator = Usuarios.iterator(); iterator.hasNext(); ) {  
            Usuario lido = (Usuario) iterator.next();
            
            gravador.println(   lido.getUsuario()+ ";" + 
                                lido.getSenha() + ";" + 
                                lido.getNome() + ";" + 
                                lido.getEndereco() + ";" + 
                                lido.getTelefone() + ";" + 
                                lido.getEmail() + ";" + 
                                lido.getClass().getSimpleName());
         }
        arq.close();
    }
   
    public ArrayList<Usuario> getUsuarios() throws IOException {
        le_arquivo_usuario();
        return Usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> Usuarios) throws IOException {
        this.Usuarios = Usuarios;
        atualiza_arquivo_usuario();
    }   
    
    
    
    private void le_arquivo_servico() throws IOException{
        FileReader arq = new FileReader("servicos.txt");
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        Servico Inserir = null;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length==2){
                
                Inserir = new Servico(dados[0], dados[1]);
                
                Servicos.add(Inserir);
            }
            linha = buffReadUsers.readLine(); //Para ler a próxima linha          
        }
        arq.close();
    }
    
    private void atualiza_arquivo_servico() throws IOException{
        File file = new File( "servicos.txt" );
        file.delete();
        
        FileWriter arq = new FileWriter("servicos.txt", true);
        PrintWriter gravador = new PrintWriter(arq);
        
        gravador.println(); //Pular uma linha no arquivo
        
        for (Iterator iterator = Servicos.iterator(); iterator.hasNext(); ) {  
            Servico lido = (Servico) iterator.next();
            
            gravador.println(   lido.getTipoServico()+ ";" + 
                                lido.getObservacaoServico());
         }
        arq.close();
    }

    public ArrayList<Servico> getServicos() throws IOException {
        le_arquivo_servico();
        return Servicos;
    }

    public void setServicos(ArrayList<Servico> Servicos) throws IOException {
        this.Servicos = Servicos;
        atualiza_arquivo_servico();
    }
    
    
    private void le_arquivo_servico_ativado() throws IOException{
        FileReader arq = new FileReader("servicos_ativados.txt");
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        Servico Inserir = null;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length==2){
                
                Inserir = new Servico(dados[0], dados[1]);
                
                ServicosAtivados.add(Inserir);
            }
            linha = buffReadUsers.readLine(); //Para ler a próxima linha          
        }
        arq.close();
    }
    
    private void atualiza_arquivo_servico_ativado() throws IOException{
        File file = new File( "servicos_ativados.txt" );
        file.delete();
        
        FileWriter arq = new FileWriter("servicos_ativados.txt", true);
        PrintWriter gravador = new PrintWriter(arq);
        
        gravador.println(); //Pular uma linha no arquivo
        
        for (Iterator iterator = ServicosAtivados.iterator(); iterator.hasNext(); ) {  
            Servico lido = (Servico) iterator.next();
            
            gravador.println(   lido.getTipoServico()+ ";" + 
                                lido.getObservacaoServico());
         }
        arq.close();
    }

    public ArrayList<Servico> getServicosAtivados() throws IOException {
        le_arquivo_servico_ativado();
        return ServicosAtivados;
    }

    public void setServicosAtivados(ArrayList<Servico> ServicosAtivados) throws IOException {
        this.ServicosAtivados = ServicosAtivados;
        atualiza_arquivo_servico_ativado();
    }
    
    
        
    
    private void le_arquivo_servico_orcado() throws IOException{
        FileReader arq = new FileReader("servicos_orcados.txt");
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        ServicoOrcado Inserir = null;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length==4){
                
                Inserir = new ServicoOrcado(new Servico(dados[0], dados[1]),dados[2],dados[3]);
                
                ServicosOrcados.add(Inserir);
            }
            linha = buffReadUsers.readLine(); //Para ler a próxima linha          
        }
        arq.close();
    }
    
    private void atualiza_arquivo_servico_orcado() throws IOException{
        File file = new File( "servicos_orcados.txt" );
        file.delete();
        
        FileWriter arq = new FileWriter("servicos_orcados.txt", true);
        PrintWriter gravador = new PrintWriter(arq);
        
        gravador.println(); //Pular uma linha no arquivo
        
        for (Iterator iterator = ServicosOrcados.iterator(); iterator.hasNext(); ) {  
            ServicoOrcado lido = (ServicoOrcado) iterator.next();
            Servico lido2 = lido.getServico();
            
            gravador.println(   lido2.getTipoServico()+ ";" + 
                                lido2.getObservacaoServico() + ";" +
                                lido.getProfissional() + ";" +
                                lido.getPreco());
         }
        arq.close();
    }

    public ArrayList<ServicoOrcado> getServicosOrcados() throws IOException {
        le_arquivo_servico_orcado();
        return ServicosOrcados;
    }

    public void setServicosOrcados(ArrayList<ServicoOrcado> ServicosOrcados) throws IOException {
        this.ServicosOrcados = ServicosOrcados;
        atualiza_arquivo_servico_orcado();
    }
    
    
    
    private void le_arquivo_pedidos() throws IOException{
        FileReader arq = new FileReader("pedidos.txt");
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        ItemPedido Inserir = null;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length==7){
                
                Inserir = new ItemPedido(new ServicoOrcado(new Servico(dados[0],dados[1]),dados[2],dados[3]),dados[4],dados[5],dados[6]);
            
                Pedidos.add(Inserir);
            }
            linha = buffReadUsers.readLine(); //Para ler a próxima linha          
        }
        arq.close();
    }
    
    private void atualiza_arquivo_pedidos() throws IOException{
        File file = new File( "pedidos.txt" );
        file.delete();
        
        FileWriter arq = new FileWriter("pedidos.txt", true);
        PrintWriter gravador = new PrintWriter(arq);
        
        gravador.println(); //Pular uma linha no arquivo
        
        for (Iterator iterator = Pedidos.iterator(); iterator.hasNext(); ) {  
            ItemPedido lido = (ItemPedido) iterator.next();
            
            gravador.println(   lido.getServico().getServico().getTipoServico()+ ";" + 
                                lido.getServico().getServico().getObservacaoServico() + ";" + 
                                lido.getServico().getProfissional() + ";" + 
                                lido.getServico().getPreco() + ";" + 
                                lido.getCliente() + ";" + 
                                lido.getPedido()+ ";" + 
                                lido.getStatus());
         }
        arq.close();
    }

    public ArrayList<ItemPedido> getPedidos() throws IOException {
        le_arquivo_pedidos();
        return Pedidos;
    }

    public void setPedidos(ArrayList<ItemPedido> Pedidos) throws IOException {
        this.Pedidos = Pedidos;
        atualiza_arquivo_pedidos();
    }
    
}



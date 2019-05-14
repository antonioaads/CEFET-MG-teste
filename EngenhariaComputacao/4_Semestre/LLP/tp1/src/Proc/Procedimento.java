package Proc;
	
import Variavel.*;
import Comando.*;
import java.util.*;
	
	
public class Procedimento {
    String nome;                            // nome do procedimento  
    Vector comandos;    			// vetor de comandos 
    String [] parametros;			// parametros formais 
    String [] variaveisLocal;		// vari�veis local
    static Memoria global = new Memoria();// variaveis globais
		 
		 
    public Procedimento( String nome, String [] p ){
        this.nome= nome;
        parametros= p; 
    }
		
    public String getNome(){
        return nome;
    }
		
    public static void setVariaveisGlobal( String [] vG ){	
        // adiciona variáveis globais na memória global
        if( vG != null ){	
            for(int i = 0; vG[i].length()!=0; i++ ){
                int posicao = vG[i].charAt(0) - 97;
                global.var_state[posicao] = true;
            }
        }
    }
		
    public void setVariaveisLocal( String [] vL ){	
        this.variaveisLocal = vL;
    }
		
    public void setListaComandos( Vector c ){ 
        this.comandos = c;
    }
		
   public void executa(double [] argumentos) {
      Memoria local = new Memoria(); 				// variaveis local
      char var;
   	  
        // adiciona variáveis locais na memória local
        if( variaveisLocal != null ){	
            for(int i = 0; variaveisLocal[i].length()!=0; i++ ){
                int posicao = variaveisLocal[i].charAt(0) - 97;
                local.var_state[posicao] = true;
            }
        }
        
        
        // associa argumentos a seus respectivos par�metros formais
         if( parametros != null ){	
            for(int i = 0; parametros[i].length()!=0; i++ ){
                int posicao = parametros[i].charAt(0) - 97;
                local.var_state[posicao] = true;
                local.var[posicao] = argumentos[i];
            }
        }
        
           		
      int pc= 0;
      do {
         pc=  ((Comando) comandos.elementAt(pc)).executa(local, global);
      } while (pc < comandos.size() );
   }
}

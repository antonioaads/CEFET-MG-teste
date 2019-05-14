package Comando;
	
import Variavel.*;

public class ComandoWriteVar extends Comando {
   
   String txt;
   int posicao; //Variável para converter caracter em posição de memória
   	
   public ComandoWriteVar(int lin, String texto) {
      linha= lin;
      txt = texto;
      
    posicao = txt.charAt(0);
    posicao -= 97;
   }
   
    public int executa( Memoria local, Memoria global) {
        if(local.var_state[posicao]==true){
            System.out.println(local.var[posicao]);
        }
        else if(global.var_state[posicao]==true){
            System.out.println(global.var[posicao]);
        }
        else{
            System.out.println("Variável não declarada"); //Posteriormente irei tratar como exceção
        }
        return linha+1;
    }
}

package Comando;
	
import Variavel.Memoria;
import java.util.Scanner;

public class ComandoRead extends Comando {
   
   //BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
   Scanner ler = new Scanner(System.in);
   int posicao;
   String txt;
   	
   public ComandoRead(int lin, String texto) {
        linha= lin;
        txt = texto;
      
        posicao = txt.charAt(0);
        posicao -= 97;
   }
   
   @Override
   public int executa( Memoria local, Memoria global) {
 
        double n;
       
        n = ler.nextFloat(); // 3.1 entrada de dados (lendo um valor inteiro)
        
        if(local.var_state[posicao]==true){
            local.var[posicao] = n;
        }
        else if(global.var_state[posicao]==true){
            global.var[posicao] = n;
        }
        else{   //Caso a variável não tenha sido declarada ainda
            local.var_state[posicao] = true; 
            local.var[posicao] = n;
        }
        
      return linha+1;
   }
}
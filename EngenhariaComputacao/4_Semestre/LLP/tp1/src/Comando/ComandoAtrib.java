package Comando;
	
import Variavel.*;
import Expressao.*;

public class ComandoAtrib extends Comando {
   Expressao exp;
   char var;
   	
   public ComandoAtrib(int linha, Expressao exp, char var) {
        this.exp = exp;
        this.var = var;
        this.linha = linha;
   }
   
   @Override
    public int executa( Memoria local, Memoria global){
        int posicao = var-97;   //conversão da variável para posição de memória
         
        if(local.var_state[posicao]==true){
            local.var[posicao] = exp.avalia(local, global);
        }
        else if(global.var_state[posicao]==true){
            global.var[posicao] = exp.avalia(local, global);
        }
        else{   //Caso a variável não tenha sido declarada ainda
            local.var_state[posicao] = true; 
            local.var[posicao] = exp.avalia(local, global);
        }
      
        return linha+1;
    }
}

package Comando;
	
import Variavel.Memoria;
import Expressao.*;

public class ComandoWhile extends Comando implements Condicao{
 
   int linhaEnd;
   Expressao exp;
 
   public ComandoWhile(int lin, Expressao raizArvoreExpressao) {
       this.linha = lin;
       this.exp = raizArvoreExpressao;
   }
   
   @Override
   public void setLinhaEnd(int lin){
       this.linhaEnd = lin;
   }
	
   @Override
   public int executa(Memoria local, Memoria global) {
       if(exp.avalia(local, global) == 1){
           return linha+1;
       }
       else{
           return linhaEnd;
       }
   }
}


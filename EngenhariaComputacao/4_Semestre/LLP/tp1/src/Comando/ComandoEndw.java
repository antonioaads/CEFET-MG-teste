   package Comando;
 
 	import Variavel.*;
 
   public class ComandoEndw extends Comando {
   
		int linhaW;
		
       public ComandoEndw(int lin, int linW) {
         linha= lin;
			linhaW = linW;
      }
   
       public int executa( Memoria local, Memoria global) {
         return linhaW;
      }
   }
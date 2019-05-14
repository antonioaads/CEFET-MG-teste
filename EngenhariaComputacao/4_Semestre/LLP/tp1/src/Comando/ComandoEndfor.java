   package Comando;
 
 	import Variavel.*;
 
   public class ComandoEndfor extends Comando {
   
		int linhaFor;
		char variavel;
		String tipo;
		
       public ComandoEndfor(int lin, int linFor, char var, String tipo) {
         linha= lin;
			linhaFor = linFor;
			variavel = var;
			this.tipo = tipo;
      }
   
       public int executa( Memoria local, Memoria global) {
		 
		 	int varPosicao = variavel - 97;
			
			if( (local.var[ varPosicao ] == -1) && (global.var[ varPosicao ] == -1) ){
				System.out.println("Variavel nao declarada.");
			}
			
		 	if( tipo.equals("to") ){
				if( local.var[ varPosicao ] != -1 ){
					local.var[ varPosicao ] = local.var[ varPosicao ] + 1;
				}
				else{
					global.var[ varPosicao ] = global.var[ varPosicao ] + 1;
				}
			}
			else{
				if( local.var[ varPosicao ] != -1 ){
					local.var[ varPosicao ] = local.var[ varPosicao ] - 1;
				}
				else{
					global.var[ varPosicao ] = global.var[ varPosicao ] - 1;
				}
		 	}
			
         return linhaFor;
      }
   }
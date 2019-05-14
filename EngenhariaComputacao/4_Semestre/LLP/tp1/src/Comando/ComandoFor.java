   package Comando;
	
    import Variavel.*;
    import Expressao.*;
	 
    public class ComandoFor extends Comando{
   
        int linhaEnd,varValor;
        double limite;
        char variavel;
        String tipo;
        Expressao exp;
        boolean inicio = true;
			 
        public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao) {
            linha     = lin;
            variavel  = var.charAt(0);
            exp       = raizArvoreExpressao;
            this.tipo = tipo;
            varValor = Integer.parseInt(vValor);
        }
        
        public char getVar(){
                return variavel;
        }
	
        public String getTipo(){
                return tipo;
        }
	
        public void setLinhaEnd(int lin){
                linhaEnd = lin;
        }

       public int executa( Memoria local, Memoria global) {
		 	
        int varPosicao = variavel - 97;

        if( (local.var_state[ varPosicao ] == false) && (global.var_state[ varPosicao ] == false) ){
                System.out.println("Variavel nao declarada.");
        }

        int linhaR = linha+1;
        limite    = exp.avalia(local, global);

        if( inicio ){
            if( local.var_state[ varPosicao ] == true ){
                    local.var[ varPosicao ] = varValor;
            }
            else{
                    global.var[ varPosicao ] = varValor;
            }
            inicio = false;
        }

        if( tipo.equals("to") ){
            if( local.var_state[ varPosicao ] == true ){
                    if( local.var[ variavel - 97 ] > limite ){
                            linhaR = linhaEnd+1;
                            inicio = true;
                    }
            }
            else{
                    if( global.var[ variavel - 97 ] > limite ){
                            linhaR = linhaEnd+1;
                            inicio = true;
                    }
            }
        }
        else if( tipo.equals("downto") ){
            if( local.var_state[ varPosicao ] == true ){
                    if( local.var[ varPosicao ] < limite ){
                            linhaR = linhaEnd+1;
                            inicio = true;
                    }
            }
            else{
                    if( global.var[ varPosicao ] < limite ){
                            linhaR = linhaEnd+1;
                            inicio = true;
                    }
            }
        }
			
         return linhaR;
      }
   }


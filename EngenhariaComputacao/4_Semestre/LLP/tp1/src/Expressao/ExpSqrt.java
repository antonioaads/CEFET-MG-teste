 package Expressao;
 
 import Variavel.*;
 
public class ExpSqrt extends Expressao{

    String sqrt;

    public ExpSqrt(String sqrt) {
        this.sqrt= sqrt;
    }

    public double avalia( Memoria local, Memoria global ) {

        double valor;
        char variavel = sqrt.charAt(0);
        int varPosicao = variavel - 97;

        if( (local.var[ varPosicao ] == -1) && (global.var[ varPosicao ] == -1) ){
                System.out.println("Variavel nao declarada.");
        }

        if( variavel >= 'a' && variavel <= 'z' ){
            if( local.var[ varPosicao ] != -1 ){
                valor = Math.sqrt( local.var[ varPosicao ] );
            }
            else{
                valor = Math.sqrt( global.var[ varPosicao ] );
            }        
        }
        else{
            valor= Math.sqrt(Double.parseDouble(sqrt));
        }

         return valor;
    }  
}
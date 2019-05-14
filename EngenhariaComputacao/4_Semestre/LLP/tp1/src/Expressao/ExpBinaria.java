package Expressao;

import Variavel.*;

public class ExpBinaria extends Expressao{
    private final String operador;
    private final Object exp1;
    private final Object exp2;
    
    public ExpBinaria(String operador, Object exp1, Object exp2){
        this.operador = operador;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public double avalia( Memoria local, Memoria global ){
        
        if(operador.equals("+")){
            return (((Expressao)exp1).avalia(local,global) + ((Expressao)exp2).avalia(local,global));
        }
        else if (operador.equals("-")){
            return (((Expressao)exp2).avalia(local,global) - ((Expressao)exp1).avalia(local,global));
        }
        else if (operador.equals("*")){
            return (((Expressao)exp1).avalia(local,global) * ((Expressao)exp2).avalia(local,global));
        }
        else if (operador.equals("/")){
            return (((Expressao)exp2).avalia(local,global) / ((Expressao)exp1).avalia(local,global));
        }
        else{
            System.out.println("Operador inválido");  
        }
        System.exit(0);
        return 0;
    }
}

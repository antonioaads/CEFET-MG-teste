package Expressao;

import Variavel.Memoria;

public class ExpVariavel extends Expressao{
    private final String var;
    
    public ExpVariavel(String var){
        this.var = var;
    }
    @Override
    public double avalia( Memoria local, Memoria global ){
        int posicao = var.charAt(0) - 97; //conversão caracter para posição no vetor
        
        if(local.var_state[posicao]==true){
            return (local.var[posicao]);
        }
        else if(global.var_state[posicao]==true){
            return (global.var[posicao]);
        }
        
        System.out.println("Variável não declarada"); //Posteriormente irei tratar como exceção
        System.exit(0);
        return 0;
    }   
}

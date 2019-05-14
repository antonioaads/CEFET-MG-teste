package Expressao;

import Variavel.*;	

public class ExpComparativa extends Expressao{

    private final String op;
    private final Object exp1;
    private final Object exp2;
    private Expressao opr1, opr2;
    private static final double TRUE  = 1;
    private static final double FALSE = 0;

    public ExpComparativa(String op, Object exp1, Object exp2) {
        this.op= op;
        this.exp1= exp1;
        this.exp2= exp2;
    }

    @Override
    public double avalia( Memoria local, Memoria global ) {

        boolean v = false;
        double valor = FALSE;

        opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;

        if(op.equals(">")){
            if(opr2.avalia(local,global) > opr1.avalia(local,global)){
                v = true;
            }
        }
        else if (op.equals("<")){
            if(opr2.avalia(local,global) < opr1.avalia(local,global)){
                v = true;
            }
        }
        else if (op.equals(">=")){
            if(opr2.avalia(local,global) >= opr1.avalia(local,global)){
                v = true;
            }
        }
        else if (op.equals("<=")){
            if(opr2.avalia(local,global) <= opr1.avalia(local,global)){
                v = true;
            }
        }
        else if(op.equals("=")){
            if(opr1.avalia(local,global) == opr2.avalia(local,global)){
                v = true;
            }        
        }
        else if(op.equals("<>")){
            if(opr1.avalia(local,global) != opr2.avalia(local,global)){
                v = true;
            }
        }
        else{
            System.out.println("Operador inválido");  
        }

        if( v == true ){
            valor = TRUE;
        }

        return valor;     
    }
}	


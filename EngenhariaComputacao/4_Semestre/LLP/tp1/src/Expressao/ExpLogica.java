package Expressao;

import Variavel.Memoria;	

public class ExpLogica extends Expressao{
   
    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE  = 1;
    static final double FALSE = 0;
		
    public ExpLogica(String op, Object exp1, Object exp2) {
        this.op= op;
        this.exp1= exp1;
        this.exp2= exp2;
    }
   
    @Override
    public double avalia( Memoria local, Memoria global ) {
        
        boolean v = false,
	opr1B = false, 
	opr2B = false;
	double valor= FALSE;
         
	opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;
         
        if(op.equals("and")){
            if(opr1.avalia(local, global)==TRUE && opr2.avalia(local, global)==TRUE){
                v = true;
            }
        }
        else if (op.equals("or")){
            if(opr1.avalia(local, global)==TRUE || opr2.avalia(local, global)==TRUE){
                v = true;
            }
        }
        else if (op.equals("not")){
            if(opr1.avalia(local, global)==FALSE){
                v = true;
            }
        }
       		
	if( v == true ){
            valor= TRUE;
	}
			
         return valor;
    }
}	


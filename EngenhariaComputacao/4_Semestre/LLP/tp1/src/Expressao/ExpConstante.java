package Expressao;

import Variavel.*;

public class ExpConstante extends Expressao{
   
      double valor;
   	
       public ExpConstante(double valor) {
         this.valor= valor;
      }
   
       public double avalia( Memoria local, Memoria global ) {
         return valor;
      }
      
   }
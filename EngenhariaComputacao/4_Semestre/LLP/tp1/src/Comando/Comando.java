   package Comando;
	
   import java.io.*;
   import Variavel.*;
	
    public abstract class Comando {
      protected int linha;
       public abstract int executa(Memoria local, Memoria global);
   }

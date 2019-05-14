/*
 *         CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE ALGORÍTMOS E ESTRUTURAS DE DADOS II
 * 
 *                    ANTONIO SOUSA E RODRIGO MOREIRA
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
  
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        int n;
        System.out.print("Entre com o número da montagem que deseja analisar:");
        n = ler.nextInt();

        String entrada = "test/montagem" + n + ".txt";
        
        //Chamada do algoritmo PD
        System.out.println("CÓDIGO POR PD:");
        
        PD x = new PD(entrada);
        
        long tempoInicio = System.currentTimeMillis();
        x.consulta(1, 0, 0);
        x.zera_Caminho();
        x.consulta(-1, 0, 0);
        x.zera_Caminho();
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio) + " milissegundos");
        
        System.out.println("Total = " + x.getTotal());
        x.imprimir_caminho(); 
        System.out.println();
        
        //Chamada do Guloso
        System.out.println("CÓDIGO POR GULOSO:");
        Guloso y = new Guloso(entrada);
        tempoInicio = System.currentTimeMillis();
        y.consulta();
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio) + " milissegundos");
        System.out.println("Total = " + y.getTotal());
        y.imprimir_caminho();
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author aluno
 */
public class TP3 {
    int matriz[][];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamanho = 10;
        // TODO code application logic here
        matrizAdjacencia receber = new matrizAdjacencia(tamanho);
        receber.preencher();
        receber.imprimir();
    }
    
}

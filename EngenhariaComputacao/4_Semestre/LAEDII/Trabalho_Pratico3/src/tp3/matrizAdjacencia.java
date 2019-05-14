/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class matrizAdjacencia {
    int matriz[][];
    int tamanho;
    
    public matrizAdjacencia(){
        
    }
    
    public matrizAdjacencia(int tamanho){
        this.tamanho = tamanho;
        matriz = new int[tamanho][tamanho];
    }
    
    public void zerar(){
        for(int i = 0; i<tamanho;i++){
            for(int j = 0; j<tamanho; j++){
                matriz[i][j]=0;
            }
        }
    }
    
    public void preencher(){
        Random gerador = new Random();
        int aleatorio;
        for(int i = 0; i<tamanho;i++){
            for(int j = i; j<tamanho; j++){
                if(i==j){
                   matriz[i][j]=0; 
                }
                else{
                    aleatorio = gerador.nextInt(100);
                    matriz[i][j]=aleatorio; //gera números randômicos de 0 a 100.
                    matriz[j][i]=aleatorio; //gera números randômicos de 0 a 100.
                }
            }
        }
    }
    
    public void imprimir(){
        for(int i = 0; i<tamanho;i++){
            for(int j = 0; j<tamanho; j++){
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    
    
}

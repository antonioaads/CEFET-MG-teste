/*
 *         CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE ALGORÍTMOS E ESTRUTURAS DE DADOS II
 * 
 *                    ANTONIO SOUSA E RODRIGO MOREIRA
 */

//Implementação da PD

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PD {
    int total = 1000; //Tamanho máximo do resultado
    private ArrayList<Integer> Linha1;
    private ArrayList<Integer> Linha2;
    private ArrayList<Integer> Passagem1;
    private ArrayList<Integer> Passagem2;
    
    private ArrayList<String> Caminho;
    private ArrayList<String> CaminhoEscolhido;
    
    public PD(){
        
    }
    public PD(String entrada) throws FileNotFoundException, IOException {
        Linha1  = new ArrayList();
        Linha2 = new ArrayList();
        Passagem1 = new ArrayList();
        Passagem2 = new ArrayList();
        
        Caminho = new ArrayList();
        CaminhoEscolhido = new ArrayList();
        
        arquivo x = new arquivo();
        x.le_arquivo(entrada);
        
        //Recebendo os dados do arquivo
        Linha1 = x.getLinha1();
        Linha2 = x.getLinha2();
        Passagem1 = x.getPassagem1();
        Passagem2 = x.getPassagem2();
    }
    
    
    public void consulta(int nivel, int index, int peso){
        
        if(nivel==1){
            //Chegou no final da linha
            if(index==Linha1.size()-1){
                if(peso<total){
                    total=peso;
                    CaminhoEscolhido = new ArrayList(Caminho);
                }

            }
            //Durante a linha de montagem
            else{
                //Anexo da primeira estação na lista do caminho
                if(index==0){
                    peso=Linha1.get(index);
                    Caminho.add(Integer.toString(peso));    
                }
                
                Caminho.add(Integer.toString(Linha1.get(index+1)));
                consulta(nivel,index+1,peso+Linha1.get(index+1));
                Caminho.remove(Caminho.size()-1);
                
                if(index<Linha1.size()-2 && index>0){
                    Caminho.add("!" + Integer.toString(Passagem1.get(index-1)) + "!");
                    Caminho.add(Integer.toString(Linha2.get(index+1)));
                    consulta(-1,index+1,peso+Passagem1.get(index-1)+Linha2.get(index+1));
                    Caminho.remove(Caminho.size()-1);
                    Caminho.remove(Caminho.size()-1);
                }
            }
        }
        
        else{
            if(index==Linha2.size()-1){
                if(peso<total){
                    total=peso;
                  
                    CaminhoEscolhido = new ArrayList(Caminho);
                }
            }
            
            else{
                if(index==0){
                    peso=Linha2.get(index);
                    Caminho.add(Integer.toString(peso));
                }
                Caminho.add(Integer.toString(Linha2.get(index+1)));
                consulta(nivel,index+1,peso+Linha2.get(index+1));
                Caminho.remove(Caminho.size()-1);
                
                if(index<Linha2.size()-2 && index>0){
                    Caminho.add("!" + Integer.toString(Passagem2.get(index-1)) + "!");
                    Caminho.add(Integer.toString(Linha1.get(index+1)));
                    consulta(1,index+1,peso+Passagem2.get(index-1)+Linha1.get(index+1));
                    Caminho.remove(Caminho.size()-1);
                    Caminho.remove(Caminho.size()-1);
                }
            }
        }
    }

    //Função para imprimir o caminho realizado
    public void imprimir_caminho(){
        System.out.print("Caminho -> ");
        for (Iterator iterator = CaminhoEscolhido.iterator(); iterator.hasNext(); ) {  
            String lido = (String) iterator.next();
            System.out.print(lido + " - ");
        }
        System.out.println(" FIM");
    }
    
    //Zerar o array do caminho para uma nova chamada
    public void zera_Caminho(){
        Caminho = new ArrayList();
    }
    
    public int getTotal() {
        return total;
    }
}

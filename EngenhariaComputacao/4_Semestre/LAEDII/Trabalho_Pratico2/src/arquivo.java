/*
 *         CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE ALGORÍTMOS E ESTRUTURAS DE DADOS II
 * 
 *                    ANTONIO SOUSA E RODRIGO MOREIRA
 */

//Código responsável para ler arquivo

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class arquivo {
    private ArrayList<Integer> Linha1;
    private ArrayList<Integer> Linha2;
    private ArrayList<Integer> Passagem1;
    private ArrayList<Integer> Passagem2;
    
    BufferedReader buffReadUsers;
    
    public arquivo() throws FileNotFoundException{
        Linha1  = new ArrayList();
        Linha2 = new ArrayList();
        Passagem1 = new ArrayList();
        Passagem2 = new ArrayList();
    }
    
    public void le_arquivo(String arquivo) throws IOException{
        FileReader arq = new FileReader(arquivo);
        this.buffReadUsers = new BufferedReader(arq);
        
        String linha= buffReadUsers.readLine();
        String [] dados = new String[50];
        int controle = 0;
        
        while(linha!=null){    
            dados = linha.split(";");
            
            if(dados.length>1){
                if(controle==0){
                    for(int i=0; i< dados.length;i++){
                        Linha1.add(Integer.parseInt(dados[i]));
                    }
                }
                
                else if(controle==1){
                    for(int i=0; i< dados.length;i++){
                        Linha2.add(Integer.parseInt(dados[i]));  
                    }
                }
                
                else if(controle==2){
                    for(int i=0; i< dados.length;i++){
                        Passagem1.add(Integer.parseInt(dados[i]));  
                    }
                }
                
                else if(controle==3){
                    for(int i=0; i< dados.length;i++){
                        Passagem2.add(Integer.parseInt(dados[i]));  
                    }
                }
                controle++;
            }
         
            linha = buffReadUsers.readLine(); //Para ler a próxima linha 
            
        }
        arq.close();
    }
    
    public void imprimir(){
        for(int i=0; i<(Linha1.size());i++){
            System.out.print(Linha1.get(i));   
        }
        System.out.println();
        
        for(int i=0; i<(Linha2.size());i++){
            System.out.print(Linha2.get(i));   
        }
        System.out.println();
        
        for(int i=0; i<(Passagem1.size());i++){
            System.out.print(Passagem1.get(i));   
        }
        System.out.println();
        
        for(int i=0; i<(Passagem2.size());i++){
            System.out.print(Passagem2.get(i));   
        }
        System.out.println();
    }

    public ArrayList<Integer> getLinha1() {
        return Linha1;
    }

    public ArrayList<Integer> getLinha2() {
        return Linha2;
    }

    public ArrayList<Integer> getPassagem1() {
        return Passagem1;
    }

    public ArrayList<Integer> getPassagem2() {
        return Passagem2;
    }   
} 

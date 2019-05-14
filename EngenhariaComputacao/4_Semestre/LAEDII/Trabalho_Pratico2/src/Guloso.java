/*
 *         CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE ALGORÍTMOS E ESTRUTURAS DE DADOS II
 * 
 *                    ANTONIO SOUSA E RODRIGO MOREIRA
 */

//Implementação do Guloso

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Guloso {
    
    int total = 0;
    private ArrayList<Integer> Linha1;
    private ArrayList<Integer> Linha2;
    private ArrayList<Integer> Passagem1;
    private ArrayList<Integer> Passagem2;
    
    private ArrayList<String> Caminho;
    
    public Guloso(){
        
    }
    
    public Guloso(String entrada) throws FileNotFoundException, IOException{
        Linha1  = new ArrayList();
        Linha2 = new ArrayList();
        Passagem1 = new ArrayList();
        Passagem2 = new ArrayList();
        
        Caminho = new ArrayList();
        
        arquivo x = new arquivo();
        x.le_arquivo(entrada);
        
        //Pegando dados do arquivo
        Linha1 = x.getLinha1();
        Linha2 = x.getLinha2();
        Passagem1 = x.getPassagem1();
        Passagem2 = x.getPassagem2();
    }
    
    public void consulta(){
        int nivel = 0; //Variável de controle de estado na linha de produção
        for(int i=0;i<Linha1.size()-2;i++){
            if(i==0){ //Primeira Decisão
                if((Linha1.get(0)+Linha1.get(1))<=(Linha2.get(0)+Linha2.get(1))){
                    total+=(Linha1.get(0) + Linha1.get(1));
                    nivel = 1;
                    
                    Caminho.add(Integer.toString(Linha1.get(0)));
                    Caminho.add(Integer.toString(Linha1.get(1)));
                }
                else{
                    total+=(Linha2.get(0) + Linha2.get(1));
                    nivel = -1;
                    
                    Caminho.add(Integer.toString(Linha2.get(0)));
                    Caminho.add(Integer.toString(Linha2.get(1)));
                }
            }
            //Decisão intermediária
            else if(i>0 && i<Linha1.size()-3){ 
                if(nivel==1){
                    if(Linha1.get(i+1)<= (Passagem1.get(i-1) + Linha2.get(i+1))){
                        total+= Linha1.get(i+1);  
                        
                        Caminho.add(Integer.toString(Linha1.get(i+1)));
                    }
                    else{
                        total+= Passagem1.get(i-1) + Linha2.get(i+1);
                        nivel = -1;
                        
                        Caminho.add("!" + Integer.toString(Passagem1.get(i-1)) + "!");
                        Caminho.add(Integer.toString(Linha2.get(i+1)));
                    }
                    
                }
                else{
                    if(Linha2.get(i+1)<= (Passagem2.get(i-1) + Linha1.get(i+1))){
                        total+= Linha2.get(i+1); 
                        
                        Caminho.add(Integer.toString(Linha2.get(i+1)));
                    }
                    else{
                        total+= Passagem2.get(i-1) + Linha1.get(i+1);
                        nivel = 1;
                        
                        Caminho.add("!" + Integer.toString(Passagem2.get(i-1)) + "!");
                        Caminho.add(Integer.toString(Linha1.get(i+1)));
                    }
                }
            }
            else{   //Ultima decisão
                if(nivel==1){
                    if((Linha1.get(i+1) + Linha1.get(i+2))<= (Passagem1.get(i-1) + Linha2.get(i+1) + Linha2.get(i+2))){
                        total+= (Linha1.get(i+1) + Linha1.get(i+2));  
                        
                        Caminho.add(Integer.toString(Linha1.get(i+1)));
                        Caminho.add(Integer.toString(Linha1.get(i+2)));
                    }
                    else{
                        total+= (Passagem1.get(i-1) + Linha2.get(i+1) + Linha2.get(i+2));
                        nivel = -1;
                        
                        Caminho.add("!" + Integer.toString(Passagem1.get(i-1)) + "!");
                        Caminho.add(Integer.toString(Linha2.get(i+1)));
                        Caminho.add(Integer.toString(Linha2.get(i+2)));
                    }
                    
                }
                else{
                    if((Linha2.get(i+1) + Linha2.get(i+2))<= (Passagem2.get(i-1) + Linha1.get(i+1) + Linha1.get(i+2))){
                        total+= (Linha2.get(i+1) + Linha2.get(i+2));  
                        
                        Caminho.add(Integer.toString(Linha2.get(i+1)));
                        Caminho.add(Integer.toString(Linha2.get(i+2)));
                    }
                    else{
                        total+= (Passagem2.get(i-1) + Linha1.get(i+1) + Linha1.get(i+2));
                        nivel = 1;
                        
                        Caminho.add("!" + Integer.toString(Passagem2.get(i-1)) + "!");
                        Caminho.add(Integer.toString(Linha1.get(i+1)));
                        Caminho.add(Integer.toString(Linha1.get(i+2)));
                    }
                }
            }
        }
    }
    
    //Função para imprimir o caminho2
    public void imprimir_caminho(){
        System.out.print("Caminho -> ");
        for (Iterator iterator = Caminho.iterator(); iterator.hasNext(); ) {  
            String lido = (String) iterator.next();
            System.out.print(lido + " - ");
        }
        System.out.println(" FIM");
    }

    public int getTotal() {
        return total;
    }
    
}

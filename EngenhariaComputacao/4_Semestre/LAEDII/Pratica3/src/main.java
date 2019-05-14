/*
Prática 3
Aluno: Antônio Augusto Diniz Sousa
Engenharia de Computação - 4° Período
*/

import Global.Variaveis;
import TAD.*;
import Item.Item;

public class main{
    
  public static void main(String [] args){
     
    int contador=0; //Para preencher as árvores
    Item x;         //Para criar os itens para inserir nas árvores
    
    //Desperdicei a posição 0 para facilitar a organização
    ArvoreSBB[] arvore_sbb = new ArvoreSBB[11];      //Criação das arvores ordenadas SBB
    arvore_sbb[1] = new ArvoreSBB();                 //Árvore que terá 10000 elementos
    arvore_sbb[2] = new ArvoreSBB();                 //Árvore que terá 20000 elementos
    arvore_sbb[3] = new ArvoreSBB();                 //Árvore que terá 30000 elementos
    arvore_sbb[4] = new ArvoreSBB();                 //Árvore que terá 40000 elementos
    arvore_sbb[5] = new ArvoreSBB();                 //Árvore que terá 50000 elementos
    arvore_sbb[6] = new ArvoreSBB();                 //Árvore que terá 60000 elementos
    arvore_sbb[7] = new ArvoreSBB();                 //Árvore que terá 70000 elementos
    arvore_sbb[8] = new ArvoreSBB();                 //Árvore que terá 80000 elementos
    arvore_sbb[9] = new ArvoreSBB();                 //Árvore que terá 90000 elementos
    arvore_sbb[10] = new ArvoreSBB();                 //Árvore que terá 100000 elementos
    
    ArvoreB[] arvore_B_2 = new ArvoreB[11];         //Criação das arvores B ordenadas de ordem 2
    arvore_B_2[1] = new ArvoreB(2);                 //Árvore que terá 10000 elementos
    arvore_B_2[2] = new ArvoreB(2);                 //Árvore que terá 20000 elementos
    arvore_B_2[3] = new ArvoreB(2);                 //Árvore que terá 30000 elementos
    arvore_B_2[4] = new ArvoreB(2);                 //Árvore que terá 40000 elementos
    arvore_B_2[5] = new ArvoreB(2);                 //Árvore que terá 50000 elementos
    arvore_B_2[6] = new ArvoreB(2);                 //Árvore que terá 60000 elementos
    arvore_B_2[7] = new ArvoreB(2);                 //Árvore que terá 70000 elementos
    arvore_B_2[8] = new ArvoreB(2);                 //Árvore que terá 80000 elementos
    arvore_B_2[9] = new ArvoreB(2);                 //Árvore que terá 90000 elementos
    arvore_B_2[10] = new ArvoreB(2);                 //Árvore que terá 100000 elementos
    
    ArvoreB[] arvore_B_4 = new ArvoreB[11];         //Criação das arvores B ordenadas de ordem 4
    arvore_B_4[1] = new ArvoreB(2);                 //Árvore que terá 10000 elementos
    arvore_B_4[2] = new ArvoreB(4);                 //Árvore que terá 20000 elementos
    arvore_B_4[3] = new ArvoreB(4);                 //Árvore que terá 30000 elementos
    arvore_B_4[4] = new ArvoreB(4);                 //Árvore que terá 40000 elementos
    arvore_B_4[5] = new ArvoreB(4);                 //Árvore que terá 50000 elementos
    arvore_B_4[6] = new ArvoreB(4);                 //Árvore que terá 60000 elementos
    arvore_B_4[7] = new ArvoreB(4);                 //Árvore que terá 70000 elementos
    arvore_B_4[8] = new ArvoreB(4);                 //Árvore que terá 80000 elementos
    arvore_B_4[9] = new ArvoreB(4);                 //Árvore que terá 90000 elementos
    arvore_B_4[10] = new ArvoreB(4);                 //Árvore que terá 100000 elementos
    
    ArvoreB[] arvore_B_6 = new ArvoreB[11];         //Criação das arvores B ordenadas de ordem 6
    arvore_B_6[1] = new ArvoreB(6);                 //Árvore que terá 10000 elementos
    arvore_B_6[2] = new ArvoreB(6);                 //Árvore que terá 20000 elementos
    arvore_B_6[3] = new ArvoreB(6);                 //Árvore que terá 30000 elementos
    arvore_B_6[4] = new ArvoreB(6);                 //Árvore que terá 40000 elementos
    arvore_B_6[5] = new ArvoreB(6);                 //Árvore que terá 50000 elementos
    arvore_B_6[6] = new ArvoreB(6);                 //Árvore que terá 60000 elementos
    arvore_B_6[7] = new ArvoreB(6);                 //Árvore que terá 70000 elementos
    arvore_B_6[8] = new ArvoreB(6);                 //Árvore que terá 80000 elementos
    arvore_B_6[9] = new ArvoreB(6);                 //Árvore que terá 90000 elementos
    arvore_B_6[10] = new ArvoreB(6);                 //Árvore que terá 100000 elementos
 

    //Início do preenchimento das árvores
    while(contador<100000){      //Preenche a árvore
        x=new Item(contador);   //Criando o item para inserir nas árvores ordenadas
        
        arvore_sbb[10].insere(x);
        arvore_B_2[10].insere(x);
        arvore_B_4[10].insere(x);
        arvore_B_6[10].insere(x);
            
        if(contador<90000){
            arvore_sbb[9].insere(x);
            arvore_B_2[9].insere(x);
            arvore_B_4[9].insere(x);
            arvore_B_6[9].insere(x);
            
            if(contador<80000){
                arvore_sbb[8].insere(x);
                arvore_B_2[8].insere(x);
                arvore_B_4[8].insere(x);
                arvore_B_6[8].insere(x);
                if(contador<70000){
                    arvore_sbb[7].insere(x);
                    arvore_B_2[7].insere(x);
                    arvore_B_4[7].insere(x);
                    arvore_B_6[7].insere(x);
                    if(contador<60000){
                        arvore_sbb[6].insere(x);
                        arvore_B_2[6].insere(x);
                        arvore_B_4[6].insere(x);
                        arvore_B_6[6].insere(x);
                        if(contador<50000){
                            arvore_sbb[5].insere(x);
                            arvore_B_2[5].insere(x);
                            arvore_B_4[5].insere(x);
                            arvore_B_6[5].insere(x);
                            if(contador<40000){
                                arvore_sbb[4].insere(x);
                                arvore_B_2[4].insere(x);
                                arvore_B_4[4].insere(x);
                                arvore_B_6[4].insere(x);
                                if(contador<30000){
                                    arvore_sbb[3].insere(x);
                                    arvore_B_2[3].insere(x);
                                    arvore_B_4[3].insere(x);
                                    arvore_B_6[3].insere(x);
                                    if(contador<20000){
                                        arvore_sbb[2].insere(x);
                                        arvore_B_2[2].insere(x);
                                        arvore_B_4[2].insere(x);
                                        arvore_B_6[2].insere(x);
                                        if(contador<10000){
                                            arvore_sbb[1].insere(x);
                                            arvore_B_2[1].insere(x);
                                            arvore_B_4[1].insere(x);
                                            arvore_B_6[1].insere(x);
                                        }
                                        else if(contador==10000) System.out.println("Árvores com n = 10000 preenchida");
                                    }
                                    else if(contador==20000) System.out.println("Árvores com n = 20000 preenchida");
                                }
                                else if(contador==30000) System.out.println("Árvores com n = 30000 preenchida");
                            }
                            else if(contador==40000) System.out.println("Árvores com n = 40000 preenchida");
                        }
                        else if(contador==50000) System.out.println("Árvores com n = 50000 preenchida");
                    }
                    else if(contador==60000) System.out.println("Árvores com n = 60000 preenchida");
                }
                else if(contador==70000) System.out.println("Árvores com n = 70000 preenchida");
            }
            else if(contador==80000) System.out.println("Árvores com n = 80000 preenchida");
        }
        else if(contador==90000) System.out.println("Árvores com n = 90000 preenchida");
        
        contador++;
    }
    System.out.println("Árvores com n = 100000 preenchida\n");
    
    //Análise da busca nas árvores por um item que não existe
    System.out.println("Início Árvore SBB");
    for(int y=1;y<=10;y++){
        System.out.printf("Busca na árvore SBB de %d elementos\n",(y*10000));
        analise_arvore(arvore_sbb[y]);
    }
    
    System.out.println("\nInício Árvores B ordem 2");
    for(int y=1;y<=10;y++){
        System.out.printf("Busca na árvore B de ordem 2 de %d elementos\n",(y*10000));
        analise_arvore(arvore_B_2[y]);
    } 
    
    System.out.println("\nInício Árvores B ordem 4");
    for(int y=1;y<=10;y++){
        System.out.printf("Busca na árvore B de ordem 4 de %d elementos\n",(y*10000));
        analise_arvore(arvore_B_4[y]);
    }
    
    System.out.println("\nInício Árvores B ordem 6");
    for(int y=1;y<=10;y++){
        System.out.printf("Busca na árvore B de ordem 6 de %d elementos\n",(y*10000));
        analise_arvore(arvore_B_6[y]);
    }
  }
  
  public static void analise_arvore(ArvoreSBB arvore){
    Item x;                             //Para buscar na árvore
    x = new Item(99999);                //Item com um número qualquer acima do maior encontrado nas árvores
    
    Variaveis.comparacoes = 0;          //zera número de comparações
    arvore.pesquisa(x);                 //pesquisar o item 99999 que não existe em nenhuma árvore
    System.out.print("Comparações: ");
    System.out.println(Variaveis.comparacoes);
    System.out.print("\n");
  }
  
  public static void analise_arvore(ArvoreB arvore){
    Item x;                 //Para buscar na árvore
    x = new Item(99999);     //Item com um número qualquer acima do maior encontrado nas árvores
    
    Variaveis.comparacoes = 0;          //zera número de comparações
    arvore.pesquisa(x);                 //pesquisar o item 99999 que não existe em nenhuma árvore
    System.out.print("Comparações: ");
    System.out.println(Variaveis.comparacoes);
    System.out.print("Páginas acessadas: ");
    System.out.println(arvore.pg_count);
    System.out.print("\n");
  }
}
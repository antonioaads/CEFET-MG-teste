/*
Prática 2
Aluno: Antônio Augusto Diniz Sousa
Engenharia de Computação - 4° Período
*/

import Global.Variaveis;
import TAD.*;
import Item.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class main{
    
  public static void main(String [] args){
     
    int contador=0; //Para preencher as árvores
    Item x;         //Para criar os itens para inserir nas árvores
    Item w;         //Para criar os itens para inserir nas árvores
    
    Random gerador=new Random();
    
    //Desperdicei a posição 0 para facilitar a organização
    ArvoreSBB[] arvores_ordenadas = new ArvoreSBB[10];      //Criação das arvores ordenadas
    arvores_ordenadas[1] = new ArvoreSBB();                 //Árvore que terá 10000 elementos
    arvores_ordenadas[2] = new ArvoreSBB();                 //Árvore que terá 20000 elementos
    arvores_ordenadas[3] = new ArvoreSBB();                 //Árvore que terá 30000 elementos
    arvores_ordenadas[4] = new ArvoreSBB();                 //Árvore que terá 40000 elementos
    arvores_ordenadas[5] = new ArvoreSBB();                 //Árvore que terá 50000 elementos
    arvores_ordenadas[6] = new ArvoreSBB();                 //Árvore que terá 60000 elementos
    arvores_ordenadas[7] = new ArvoreSBB();                 //Árvore que terá 70000 elementos
    arvores_ordenadas[8] = new ArvoreSBB();                 //Árvore que terá 80000 elementos
    arvores_ordenadas[9] = new ArvoreSBB();                 //Árvore que terá 90000 elementos
    
    ArvoreSBB[] arvores_aleatorias = new ArvoreSBB[10];     //Criação das arvores ordenadas
    arvores_aleatorias[1] = new ArvoreSBB();                 //Árvore que terá 10000 elementos
    arvores_aleatorias[2] = new ArvoreSBB();                 //Árvore que terá 20000 elementos
    arvores_aleatorias[3] = new ArvoreSBB();                 //Árvore que terá 30000 elementos
    arvores_aleatorias[4] = new ArvoreSBB();                 //Árvore que terá 40000 elementos
    arvores_aleatorias[5] = new ArvoreSBB();                 //Árvore que terá 50000 elementos
    arvores_aleatorias[6] = new ArvoreSBB();                 //Árvore que terá 60000 elementos
    arvores_aleatorias[7] = new ArvoreSBB();                 //Árvore que terá 70000 elementos
    arvores_aleatorias[8] = new ArvoreSBB();                 //Árvore que terá 80000 elementos
    arvores_aleatorias[9] = new ArvoreSBB();                 //Árvore que terá 90000 elementos
    
    //Método para selecionar número randomicos diferentes
    //Baseado na resposta do forum acessado em: http://www.guj.com.br/t/resolvido-como-gerar-numeros-aleatorios-sem-repeticao/74652/4
    List<Integer> numeros = new ArrayList<Integer>();
    for (int i = 1; i < 95000; i++) { //Sequencia da mega sena
        numeros.add(i);
    }
    //Embaralhamos os números:
    Collections.shuffle(numeros);

    //Início do preenchimento das árvores
    while(contador<90000){      //Preenche a árvore
        x=new Item(contador);   //Criando o item para inserir nas árvores ordenadas
        w=new Item(numeros.get(contador));   //Criando o item para inserir nas árvores aleatórias
        
        arvores_ordenadas[9].insere(x);
        arvores_aleatorias[9].insere(w);
        
        if(contador<80000){
            arvores_ordenadas[8].insere(x);
            arvores_aleatorias[8].insere(w);
            if(contador<70000){
                arvores_ordenadas[7].insere(x);
                arvores_aleatorias[7].insere(w);
                if(contador<60000){
                    arvores_ordenadas[6].insere(x);
                    arvores_aleatorias[6].insere(w);
                    if(contador<50000){
                        arvores_ordenadas[5].insere(x);
                        arvores_aleatorias[5].insere(w);
                        if(contador<40000){
                            arvores_ordenadas[4].insere(x);
                            arvores_aleatorias[4].insere(w);
                            if(contador<30000){
                                arvores_ordenadas[3].insere(x);
                                arvores_aleatorias[3].insere(w);
                                if(contador<20000){
                                    arvores_ordenadas[2].insere(x);
                                    arvores_aleatorias[2].insere(w);
                                    if(contador<10000){
                                        arvores_ordenadas[1].insere(x);
                                        arvores_aleatorias[1].insere(w);
                                    }
                                    else if(contador==10000) System.out.println("Árvores com n = 1000 preenchida");
                                }
                                else if(contador==20000) System.out.println("Árvores com n = 2000 preenchida");
                            }
                            else if(contador==30000) System.out.println("Árvores com n = 3000 preenchida");
                        }
                        else if(contador==40000) System.out.println("Árvores com n = 4000 preenchida");
                    }
                    else if(contador==50000) System.out.println("Árvores com n = 5000 preenchida");
                }
                else if(contador==60000) System.out.println("Árvores com n = 6000 preenchida");
            }
            else if(contador==70000) System.out.println("Árvores com n = 7000 preenchida");
        }
        else if(contador==80000) System.out.println("Árvores com n = 8000 preenchida");
      contador++;
    }
    System.out.println("Árvores com n = 9000 preenchida\n");
    
    //Análise da busca nas árvores por um item que não existe nem nas ordenadas nem nas aleatorias (50000)
    System.out.println("Início Árvores Ordenadas");
    for(int y=1;y<=9;y++){
        System.out.printf("Busca na árvore ordenada de %d elementos\n",(y*10000));
        analise_arvore(arvores_ordenadas[y]);
    }
    
    System.out.println("\nInício Árvores Aleatórias");
    for(int y=1;y<=9;y++){
        System.out.printf("Busca na árvore aleatória de %d elementos\n",(y*10000));
        analise_arvore(arvores_aleatorias[y]);
    } 
  }
  public static void analise_arvore(ArvoreSBB arvore){
    Item x;                 //Para buscar na árvore
    x = new Item(99999);     //Item com um número qualquer acima do maior encontrado nas árvores
    double tempo_inicial, tempo_final;
    
    Variaveis.comparacoes = 0;          //zera número de comparações
    tempo_inicial=System.nanoTime();    //marcação do tempo inicial
    arvore.pesquisa(x);                 //pesquisar o item 99999 que não existe em nenhuma árvore
    tempo_final=System.nanoTime();      //marca tempo final da comparação
    System.out.print("Tempo: ");
    System.out.println(tempo_final-tempo_inicial);
    System.out.print("Comparações: ");
    System.out.println(Variaveis.comparacoes);
    System.out.print("\n");
  }
}
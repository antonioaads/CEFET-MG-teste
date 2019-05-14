/*
Prática 4
Aluno: Antônio Augusto Diniz Sousa
Engenharia de Computação - 4° Período
*/

import Item.Item;
import TAD.JHeapSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class main {
  
    public static void main(String[] args) {
        
        int contador=0; //Para preencher os heaps
        Item x;         //Para criar os itens para inserir nos heaps
        Item w;         //Para criar os itens para inserir nos heaps aleatorios
        
        Item[] crescente_1 = new Item[10000];    //instanciando os vetores crecentes
        Item[] crescente_2 = new Item[20000];
        Item[] crescente_3 = new Item[30000];
        Item[] crescente_4 = new Item[40000];
        Item[] crescente_5 = new Item[50000];
        Item[] crescente_6 = new Item[60000];
        Item[] crescente_7 = new Item[70000];
        Item[] crescente_8 = new Item[80000];
        Item[] crescente_9 = new Item[90000];
        Item[] crescente_10 = new Item[100000];
        
        Item[] decrescente_1 = new Item[10000];    //instanciando os vetores decrescentes
        Item[] decrescente_2 = new Item[20000];
        Item[] decrescente_3 = new Item[30000];
        Item[] decrescente_4 = new Item[40000];
        Item[] decrescente_5 = new Item[50000];
        Item[] decrescente_6 = new Item[60000];
        Item[] decrescente_7 = new Item[70000];
        Item[] decrescente_8 = new Item[80000];
        Item[] decrescente_9 = new Item[90000];
        Item[] decrescente_10 = new Item[100000];
        
        Item[] aleatorio_1 = new Item[10000];    //instanciando os vetores aleatorios
        Item[] aleatorio_2 = new Item[20000];
        Item[] aleatorio_3 = new Item[30000];
        Item[] aleatorio_4 = new Item[40000];
        Item[] aleatorio_5 = new Item[50000];
        Item[] aleatorio_6 = new Item[60000];
        Item[] aleatorio_7 = new Item[70000];
        Item[] aleatorio_8 = new Item[80000];
        Item[] aleatorio_9 = new Item[90000];
        Item[] aleatorio_10 = new Item[100000];
        
        //Método para selecionar número randomicos diferentes
        //Baseado na resposta do forum acessado em: http://www.guj.com.br/t/resolvido-como-gerar-numeros-aleatorios-sem-repeticao/74652/4
        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);
       
        //Início do preenchimento dos heaps
        while(contador<100000){      //Para aproveitar o mesmo while para todos os heaps
            x=new Item(contador);   //Criando o item para inserir nos heaps crescentes e decrescentes
            w=new Item(numeros.get(contador));   //Criando o item para inserir nos heaps aleatórios
            
            crescente_10[contador] = x;
            decrescente_10[99999-contador] = x;
            aleatorio_10[contador] = w;

            if(contador<90000){
                crescente_9[contador] = x;
                decrescente_9[89999-contador] = x;
                aleatorio_9[contador] = w;

                if(contador<80000){
                    crescente_8[contador] = x;
                    decrescente_8[79999-contador] = x;
                    aleatorio_8[contador] = w;
                    
                    if(contador<70000){
                        crescente_7[contador] = x;
                        decrescente_7[69999-contador] = x;
                        aleatorio_7[contador] = w;
                        
                        if(contador<60000){
                            crescente_6[contador] = x;
                            decrescente_6[59999-contador] = x;
                            aleatorio_6[contador] = w;
                            
                            if(contador<50000){
                                crescente_5[contador] = x;
                                decrescente_5[49999-contador] = x;
                                aleatorio_5[contador] = w;
                            
                                if(contador<40000){
                                    crescente_4[contador] = x;
                                    decrescente_4[39999-contador] = x;
                                    aleatorio_4[contador] = w;
                                
                                    if(contador<30000){
                                        crescente_3[contador] = x;
                                        decrescente_3[29999-contador] = x;
                                        aleatorio_3[contador] = w;
                                    
                                        if(contador<20000){
                                            crescente_2[contador] = x;
                                            decrescente_2[19999-contador] = x;
                                            aleatorio_2[contador] = w;
                                            
                                            if(contador<10000){
                                                crescente_1[contador] = x;
                                                decrescente_1[9999-contador] = x;
                                                aleatorio_1[contador] = w;
                                            }
                                            else if(contador==10000) System.out.println("Heaps com n = 10000 preenchidos");
                                        }
                                        else if(contador==20000) System.out.println("Heap com n = 20000 preenchidos");
                                    }
                                    else if(contador==30000) System.out.println("Heap com n = 30000 preenchidos");
                                }
                                else if(contador==40000) System.out.println("Heap com n = 40000 preenchidos");
                            }
                            else if(contador==50000) System.out.println("Heap com n = 50000 preenchidos");
                        }
                        else if(contador==60000) System.out.println("Heap com n = 60000 preenchidos");
                    }
                    else if(contador==70000) System.out.println("Heap com n = 70000 preenchidos");
                }
                else if(contador==80000) System.out.println("Heap com n = 80000 preenchidos");
            }
            else if(contador==90000) System.out.println("Heap com n = 90000 preenchidos");

            contador++;
        }
        System.out.println("Heap com n = 100000 preenchidos\n");
        
        //Impressão e heapsort dos elemntos crescentes
        System.out.println("Heaps crescentes");
        System.out.println();
        
        JHeapSort heap = new JHeapSort(crescente_1, 10000-1);	//Chamando o HeapSort
        System.out.print("Comparacoes heap de 10000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_2, 20000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 20000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_3, 30000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 30000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_4, 40000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 40000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_5, 50000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 50000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_6, 60000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 60000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_7, 70000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 70000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_8, 80000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 80000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_9, 90000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 90000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(crescente_10, 100000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 100000 elementos = ");
        System.out.println(heap.getComparacoes());
        System.out.println();
        System.out.println();
        
        //Impressão e heapsort dos elemntos decrescentes
        System.out.println("Heaps decrescentes");
        System.out.println();
        
        heap = new JHeapSort(decrescente_1, 10000-1);	//Chamando o HeapSort
        System.out.print("Comparacoes heap de 10000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_2, 20000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 20000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_3, 30000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 30000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_4, 40000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 40000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_5, 50000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 50000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_6, 60000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 60000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_7, 70000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 70000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_8, 80000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 80000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_9, 90000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 90000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(decrescente_10, 100000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 100000 elementos = ");
        System.out.println(heap.getComparacoes());
        System.out.println();
        System.out.println();
        
        //Impressão e heapsort dos elemntos aleatorios
        System.out.println("Heaps aleatorios");
        System.out.println();
        
        heap = new JHeapSort(aleatorio_1, 10000-1);	//Chamando o HeapSort
        System.out.print("Comparacoes heap de 10000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_2, 20000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 20000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_3, 30000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 30000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_4, 40000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 40000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_5, 50000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 50000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_6, 60000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 60000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_7, 70000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 70000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_8, 80000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 80000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_9, 90000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 90000 elementos = ");
        System.out.println(heap.getComparacoes());
        
        heap = new JHeapSort(aleatorio_10, 100000-1); //Chamando o HeapSort
        System.out.print("Comparacoes heap de 100000 elementos = ");
        System.out.println(heap.getComparacoes());
    }
}
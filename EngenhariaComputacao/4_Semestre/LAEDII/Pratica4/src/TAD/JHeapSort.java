package TAD;

import Item.Item;

public class JHeapSort
{	
	private int comparacoes;

	public int getComparacoes(){
		return this.comparacoes;
	}

	public JHeapSort (Item v[] , int n){	//Funcao de ordenacao pelo metodo heapsort 
		comparacoes = 0;

		JHeap heap = new JHeap (v); 		//Cria um novo heap a partir do vetor passado como parametro
		int dir = n;                            //Salva o tamanho do heap

		heap.constroi() ;                       //Constroi o heap 
		while (dir > 1){    //Ordena o vetor trocando os itens de lugar e refazendo o heap repetidamente até ter passado por todo o vetor
			Item x = v[1]; 
			v[1] = v[dir]; 
			v[dir] = x;
			dir--;

			heap.refaz (1, dir);
			comparacoes = comparacoes + heap.getComparacoes();  //Soma o numero de compracoes feitas pelo metodo refaz
		} 
	}
}
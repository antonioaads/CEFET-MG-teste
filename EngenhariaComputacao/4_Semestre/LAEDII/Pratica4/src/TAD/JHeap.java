package TAD;

import Item.Item;

public class JHeap{
	private Item v[];
	private int n;
	private int comparacoes;

	public JHeap (Item v[]){
            this.v = v; 
            this.n = this.v.length - 1; 
            this.comparacoes = 0;
	}

	public int getComparacoes(){
            return this.comparacoes;
	}

	//Metodo que informa o item com a maior chave
	public Item max (){ 
            return this.v[1];
	}

	//Metodo para refazer o heap
	public void refaz (int esq, int dir){ 
		this.comparacoes = 0;	//Número de comparações inicialmente em zero

		int j = esq*2; 			
		Item x = this.v[esq];	//x =primeiro item a esquerda
		
		while (j <= dir){		//Até o ultimo item a direita
			this.comparacoes++;

			if ((j < dir) && (this.v[j].compara (this.v[j + 1]) < 0)){	//Compara o item atual com o seguinte e, se estiverem ordenados (o item atual é menor que o seguinte), segue em frente
				j++;													
                        }
                        
			if (x.compara (this.v[j]) >= 0){ //Se j indicar um item menor ou igual ao primeiro item do vetor, a funcao sai do laco while
				break;
                        }
                        
			//Caso contrario, j indica um item maior que o o primeiro item do vetor e ees sao trocados de posicao para manter a propriedade do heap
			this.v[esq] = this.v[j]; 
			esq = j;    //Extende-se o heap para a esquerda
			j = esq*2;		
		}
		this.v[esq] = x;    //Ao final, coloca-se o item inicialmente na primeira posicao do vetor, na posicao atual
	}



	//Metodo que controi o heap
	public void constroi(){
		int esq = (n / 2) + 1;		//Itens a partir de (n/2)+1
		while (esq > 1)                 //Depois, o heap é extendido para a esquerda e refeito até que todo o vetor esteja ordenado
		{
			esq--;
			this.refaz(esq, this.n);
		} 
	}


	//Metodo que retira o maior item do vetor
	public Item retiraMax () throws Exception {
		Item maximo;
		if (this.n < 1){ //Caso o heap esteja vazio, o metodo indica o erro com uma excecao
			throw new Exception ("Erro: heap vazio");
                }
                else{								
			maximo = this.v[1];             //Item maximo do vetor é salvo na variavel maximo
			this.v[1] = this.v[this.n--];	//O ultimo item do vetor passa a ser o primeiro
			refaz (1, this.n);              //O heap é refeito de modo que suas propriedades sejam mantidas
		}
		return maximo;                          //O metodo retorna o valor maximo
	}


	//Metodo para aumentar a chave de um item do heap
	public void aumentaChave (int i , Object chaveNova) throws Exception {
		Item x = this.v[i];     //É passado como parametro para o metodo a posicao do vetor que contem o item cuja chave sera alterada. O Item x passa a apontar para o item do vetor
		
		if (chaveNova == null)  //Caso a chave nova recebida como parametro seja null,  metodo lanca um excecao
			throw new Exception ("Erro: chaveNova com valor null");

		x.alteraChave (chaveNova);  //A chave do item é alterada

		while ((i > 1) && (x.compara (this.v[i / 2]) >= 0)){ 
		
			this.v[i] = this.v[i / 2]; 
			i /= 2; 
		}
		
		this.v[i] = x;
	}


	//Metodo que insere um item novo no heap
	public void insere (Item x) throws Exception {
		this.n++;
		
		if (this.n == this.v.length) 		
			throw new Exception ("Erro: heap cheio");

		Object chaveNova = x.recuperaChave (); 			
		this.v[this.n] = x; 							
		this.v[this.n].alteraChave (new Integer(Integer.MIN_VALUE)); 	
		this.aumentaChave (this.n, chaveNova);			
	}
}
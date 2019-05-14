package TAD;

import Item.Item;
import Global.Variaveis;

public class ArvoreBinaria{

  private static class No {
    Item reg;
    No esq, dir;
  }

  private No raiz;

  public ArvoreBinaria(){
    raiz=null;
  }

  public No getRaiz(){
    return this.raiz;
  }

  public void insere(Item reg){
    this.raiz = this.insere(reg,this.raiz);
  }

  public Item pesquisa(Item reg){
    return this.pesquisa(reg,this.raiz);
  }

  public No insere(Item reg, No p){
    if(p==null){
      p=new No();   //Se tiver vazio irá colocar o valor de reg
      p.esq=null;   //Zerando os seus descendentes
      p.dir=null;
      p.reg=reg; 
    }

    else if(reg.compara(p.reg)<0){  //Se Reg for menor que o valor do nó atual, faz uma pesquisa na árvore esquerda do nó
      p.esq = insere(reg,p.esq);
    }

    else if(reg.compara(p.reg)>0){
      p.dir = insere(reg,p.dir); //Se Reg for maior que o valor do nó atual, faz uma pesquisa na árvore esquerda do nó
    }
    else{   //Se não passou em nenhum dos casos anteriores é porque o valor de reg é igual ao do nó atual
      System.out.println("Esse item já está na árvore");
    }
    return p;
  }

  public Item pesquisa(Item reg, No p){

    if(p==null){                        //valor não se encontra na arvore, pois percorreu até a folha e não o encontrou
      Variaveis.comparacoes += 1;       //Necessitou de uma comparação para chegar até aqui
      return null;
    }

    else if(reg.compara(p.reg)<0){      //Se o item for menor, faz uma pesquisa na árvore esquerda do nó
        Variaveis.comparacoes += 2;     //Necessitou de duas comparações para chegar até aqui
      return pesquisa(reg,p.esq); 
    }

    else if(reg.compara(p.reg)>0){      //Se o item for maior, faz uma pesquisa na árvore direita do nó
        Variaveis.comparacoes += 3;     //Necessitou de três comparações para chegar até aqui
      return pesquisa(reg,p.dir); 
    }
    else{                               //Se chegou nesse caso, é por o item é igual
        Variaveis.comparacoes += 4;     //Necessitou de quatro comparações para chegar até aqui
      return p.reg;                     //Retorna o valor do nó
    }
  }
}

package TAD;

import Global.Variaveis;
import Item.*;

public class ArvoreSBB{

  private static class No {
    Item reg;
    No esq, dir;
    byte incE,incD;
  }

  private static final byte Horizontal=0;
  private static final byte Vertical=1;

  private boolean propSBB;
  private No raiz;

  public ArvoreSBB(){
    //raiz.reg=null;
    //raiz.esq=null;
    //raiz.dir=null;
    raiz=null;
    this.propSBB=true;
  }

  public No getRaiz(){
    return this.raiz;
  }

  public void insere(Item reg){
    this.raiz = insere(reg,null,this.raiz,true); //Primeira chamda do insere
  }

  public Item pesquisa(Item reg){
    return this.pesquisa(reg,this.raiz);
  }

  public No insere(Item reg,No pai, No filho, boolean filhoEsq){

    if(filho==null){
      filho=new No();
      filho.reg=reg;
      filho.incE=Vertical;
      filho.incD=Vertical;
      filho.esq=null;
      filho.dir=null;

      if(pai!=null)
        if(filhoEsq)
          pai.incE=Horizontal;
        else
          pai.incD=Horizontal;
      this.propSBB=false;
    }

      else if(reg.compara(filho.reg)<0){ //Caso o filho seja menor
        filho.esq=insere(reg,filho,filho.esq,true);
        if(!this.propSBB)
          if(filho.incE==Horizontal){
            if(filho.esq.incE==Horizontal){
              filho=this.ee(filho); //transformação esquerda-esquerda
              if(pai!=null)
                if(filhoEsq)
                  pai.incE=Horizontal;
                else
                  pai.incD=Horizontal;
            }

            else if(filho.esq.incD==Horizontal){
              filho=this.ed(filho); //transformação esquerda-direita
                if(pai!=null)
                if(filhoEsq)
                pai.incE=Horizontal;
                  else
                  pai.incD=Horizontal;
            }
          }

          else
            this.propSBB=true;
      }

      else if(reg.compara(filho.reg)>0){ //Caso o filho seja maior
        filho.dir=insere(reg,filho,filho.dir,false);
        if(!this.propSBB)
          if(filho.incD==Horizontal){
            if(filho.dir.incD==Horizontal){
              filho=this.dd(filho); //direita-direita;
              if(pai!=null)
                if(filhoEsq)
                  pai.incE=Horizontal;
                else
                  pai.incD=Horizontal;
            }

            else if(filho.dir.incE==Horizontal){
              filho=this.de(filho); //direita esquerda;
                if(pai!=null)
                  if(filhoEsq)
                    pai.incE=Horizontal;
                  else
                    pai.incD=Horizontal;
            }
          }

          else
            this.propSBB=true;
      }

      else{//se não é menor nem maior é igual
        System.out.println("Erro:Registro já existente");
        this.propSBB=true;
      }

      return filho;
  }

  public Item pesquisa(Item reg, No p){
    if(p==null){ //chegou na folha nula de maneira recuriva sem encontrar o valor
        Variaveis.comparacoes += 1; //Realizou apenas uma comparação até aqui
        return null;
    }

    else if(reg.compara(p.reg)<0){
        Variaveis.comparacoes += 2; //Realizou duas comparações até aqui
        return pesquisa(reg,p.esq); //Se o item for menor, faz uma pesquisa na árvore esquerda do nó
    }

    else if(reg.compara(p.reg)>0){
        Variaveis.comparacoes += 3; //Realizou três comparações até aqui
        return pesquisa(reg,p.dir); //Se o item for maior, faz uma pesquisa na árvore direita do nó
    }
    else{ //econtrou
        Variaveis.comparacoes += 4; //Realizou quatro comparações até aqui
        return p.reg; //retorna o item encontrado
    }
  }

  //metodos auxiliares
  private No ee(No ap) {
  No ap1 = ap.esq;
  ap.esq = ap1.dir;
  ap1.dir = ap;
  ap1.incE = Vertical;
  ap.incE = Vertical;
  ap = ap1;
  return ap;
  }

  private No ed(No ap) {
  No ap1 = ap.esq;
  No ap2 = ap1.dir;
  ap1.incD = Vertical;
  ap.incE = Vertical;
  ap1.dir = ap2.esq;
  ap2.esq = ap1;
  ap.esq = ap2.dir;
  ap2.dir = ap;
  ap = ap2;
  return ap;
  }

  private No dd(No ap) {
  No ap1 = ap.dir;
  ap.dir = ap1.esq;
  ap1.esq = ap;
  ap1.incD = Vertical;
  ap.incD = Vertical;
  ap = ap1;
  return ap;
  }

  private No de(No ap) {
  No ap1 = ap.dir;
  No ap2 = ap1.esq;
  ap1.incE = Vertical;
  ap.incD = Vertical;
  ap1.esq = ap2.dir;
  ap2.dir = ap1;
  ap.dir = ap2.esq;
  ap2.esq = ap;
  ap = ap2;
  return ap;
  }
}

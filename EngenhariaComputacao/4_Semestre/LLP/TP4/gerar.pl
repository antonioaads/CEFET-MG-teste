inserir(X,Y,[X|Y]):- !.

gerar(X,X,[X]):- !.
gerar(X,Y,L):- W is X+1, gerar(W,Y,K), inserir(X,K,L).



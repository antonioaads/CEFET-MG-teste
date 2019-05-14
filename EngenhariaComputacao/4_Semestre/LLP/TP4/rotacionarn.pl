inserir(X,Y,[X|Y]):- !.

incrementar([],K,K):- !.
incrementar([X|L1],K,L2):- incrementar(L1,K,W), inserir(X,W,L2).

anexar(X,Y, Z):- incrementar(X,Y,Z). 

rotacionar([],[]):- !.
rotacionar([X|Y], L) :- anexar(Y,[X], L).

rotacionarn(0, L, L):- !.
rotacionarn(X, Y, L) :- rotacionar(Y, J), K is X-1, rotacionarn(K, J, L).

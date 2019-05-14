inserir(X,Y,[X|Y]):- !.

incrementar([],K,K):- !.
incrementar([X|L1],K,L2):- incrementar(L1,K,W), inserir(X,W,L2).

anexar(X,Y, Z):- incrementar(X,Y,Z). 

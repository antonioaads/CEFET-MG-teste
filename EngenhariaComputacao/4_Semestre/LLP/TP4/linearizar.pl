inserir(X,Y,[X|Y]):- !.

incrementar([],K,K):- !.
incrementar([X|L1],K,L2):- incrementar(L1,K,W), inserir(X,W,L2).

linearizar([],[]):- !.
linearizar([X|Y], Z):- linearizar(Y,W), incrementar(X,W,Z). 

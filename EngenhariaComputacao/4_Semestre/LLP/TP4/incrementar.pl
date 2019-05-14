inserirMaisUm(X,Y,[W|Y]):- W is X+1, !.

incrementar([],[]):- !.
incrementar([X|L1],L2):- incrementar(L1,K), inserirMaisUm(X,K,L2).

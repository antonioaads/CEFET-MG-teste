inserir(X,Y,[X|Y]):- !.

reverter2([],L2,L2):- !.
reverter2([X|L1],W, L2):- inserir(X,W,K), reverter2(L1,K,L2) .

reverter(X,Y):- reverter2(X,[],Y), !.

inserir(X, [], X).
inserir(X, W, [X|W]).

inserirfim(X, [], X):- !.
inserirfim(Y, [X], W):- inserir(X,[Y],W), !.
inserirfim(I, [X|Y], W):- inserirfim(I,Y,O), inserir(X, O, W), !.

remover(_,[],[]):- !.
remover(X,[Y|W],K) :- Y =:= X, remover(X,W,J), K = J, !.
remover(X,[Y|W],K) :- Y =\= X, remover(X,W,J), K = [Y|J].

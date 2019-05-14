soma([], 0).
soma([X|L], M) :- soma(L, B), M is X+B.

nelementos([],0).
nelementos([_|T],S):- nelementos(T,G), S is 1+G.

medio([], 0).
medio(L, M) :- soma(L, X), nelementos(L, Y), M is X/Y.

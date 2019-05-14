nelementos([],0).
nelementos([_|T],S):- nelementos(T,G), S is 1+G.

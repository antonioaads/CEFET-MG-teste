ultimo([H], H):- !.           		
ultimo([_|T], U):- ultimo(T,U), ! .

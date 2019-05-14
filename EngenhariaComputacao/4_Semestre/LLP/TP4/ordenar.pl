auxiliar2(X,[],[X]):- !.
auxiliar2(X,[Y|T],[X,Y|T]):-X=<Y, !.
auxiliar2(X,[Y|T],[Y|NT]):-X>Y,auxiliar2(X,T,NT).

auxiliar([],X,X):- !.
auxiliar([H|T],X,Y):-auxiliar2(H,X,O),auxiliar(T,O,Y), !.

ordenar([],[]):- !.
ordenar(X,Y):- auxiliar(X,[],Y).

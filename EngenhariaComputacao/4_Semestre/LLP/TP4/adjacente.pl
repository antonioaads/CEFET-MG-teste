adjacente(N, N2, [N,N2|_]):-!.
adjacente(N, N2, [N2,N|_]):-!.
adjacente(N, N2, [_|X]) :-adjacente(N, N2, X). 

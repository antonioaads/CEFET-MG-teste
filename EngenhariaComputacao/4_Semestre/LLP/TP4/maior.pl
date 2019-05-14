maior([X|L], M) :- maior2(L, X, M).
maior2([], M, M).
maior2([X|L],T,M) :- X>T, maior2(L, X, M).
maior2([X|L],T,M) :- X=<T, maior2(L, T, M).

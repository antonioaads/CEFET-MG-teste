disjuntas :: [Integer] -> [Integer] -> Bool
disjuntas x [] = True
disjuntas [] z = True
disjuntas (a:x)  (b:y) = nestaLista a (b:y) && disjuntas x (b:y)

nestaLista :: Integer -> [Integer] -> Bool
nestaLista n [] = True
nestaLista n (a:x)
  | n == a = False
  | otherwise = True && nestaLista n x


main = do
print $ disjuntas [1,2,3,9] [5, 8, 4, 8]
distintos :: [Integer] -> Bool
distintos [] = False
distintos (a:x) = False || estaLista a x || distintos x

estaLista :: Integer -> [Integer] -> Bool
estaLista n [] = False
estaLista n (a:x)
  | n == a = True
  | otherwise = False || estaLista n x

main = do
print $ distintos [1,1,4,9,5]
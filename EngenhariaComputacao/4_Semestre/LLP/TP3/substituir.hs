substituir :: Integer -> Integer -> [Integer] -> [Integer]
substituir velho novo [] = []
substituir velho novo (a:x)
 | a==velho = [novo] ++ substituir velho novo x
 | otherwise = [a] ++ substituir velho novo x

main = do
print $ substituir 2 0 [1,2,1,3,1]
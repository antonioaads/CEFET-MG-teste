somaImpares :: [Integer] -> Integer
somaImpares [] = 0
somaImpares (a:x)
  | a `mod` 2 == 0 = 0 + somaImpares x
  | otherwise = a + somaImpares x

main = do
print $ somaImpares[1,3,2,7,4,6,5]
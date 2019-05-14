binario :: Integer -> [Integer]
binario 0 = [0]
binario 1 = [1]
binario n 
  | n`mod`2==0 = binario (n`div`2) ++ [0]
  | otherwise = binario (n`div`2) ++ [1]

main = do
print $ binario 20
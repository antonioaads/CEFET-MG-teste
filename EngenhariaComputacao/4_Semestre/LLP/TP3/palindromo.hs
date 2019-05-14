palindromo :: [Int] -> Bool
palindromo n
  |length(n) == 0 = True
  |length(n) == 1 = True
  |otherwise = analise 0 (length(n) - 1) n
  
analise :: Int -> Int -> [Int] -> Bool
analise x y n
  |x > y = True
  |x == y = True
  |(n !! x) == (n !! y) = True && analise (x + 1) (y - 1) n
  |otherwise = False

main = do
print $ palindromo [2,1,2]
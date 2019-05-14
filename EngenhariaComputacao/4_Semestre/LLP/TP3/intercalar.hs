intercalar :: [Integer] -> [Integer] -> [Integer]
intercalar [] [] = []
intercalar x [] = x
intercalar [] x = x
intercalar (a:x) (b:y)
  | a > b = [b] ++ intercalar (a:x) (y)
  | a <= b = [a] ++ intercalar x (b:y)

main = do
print $ intercalar [1,5,10] [2,7,9,20,25]
perfeito :: Integer -> Bool
perfeito a 
  |a == 0 = False
  |divisores a (a-1) == a = True
  |otherwise = False

divisores :: Integer -> Integer -> Integer
divisores a b
  |b == 0 = 0
  |a `mod` b == 0 = b + divisores a (b-1)
  |otherwise = divisores a (b-1)

main = do
print $ perfeito 8128
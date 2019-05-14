primo :: Integer -> Bool
primo 0 = False
primo 1 = False
primo n = eprimo n (n-1)

eprimo :: Integer -> Integer -> Bool
eprimo a b
  |b == 0 = True
  |b == 1 = True
  |a `mod` b == 0 = False
  |otherwise = True && eprimo a (b-1)

main = do
print $ primo 5
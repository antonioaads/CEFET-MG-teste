potencia :: Integer -> Integer -> Integer
potencia base exp
  |exp == 0 = 1
  |otherwise = base * potencia base (exp-1)

main = do
print $ potencia 2 3
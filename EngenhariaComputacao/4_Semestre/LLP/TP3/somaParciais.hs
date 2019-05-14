somaParciais :: [Integer] -> [Integer]
somaParciais [] = []
somaParciais (a:x) = [soma a] ++ somaParciais x

soma :: Integer -> Integer
soma 1 = 1
soma n = n + soma (n-1)

main = do
print $ somaParciais [1,2,3,4]
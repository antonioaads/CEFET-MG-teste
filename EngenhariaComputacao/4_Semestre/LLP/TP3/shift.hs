shift :: Integer -> [Integer] -> [Integer]
shift 0 a = a
shift n [] = []
shift n (a:x) = shift (n-1) (x++[a])

main = do
print $ shift 3 [1,5,6,7,3,4,1]
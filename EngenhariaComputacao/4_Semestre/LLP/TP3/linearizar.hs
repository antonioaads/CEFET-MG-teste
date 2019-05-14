linearizar :: [[Integer]] -> [Integer]
linearizar [[]] = []
linearizar [a] = a
linearizar (a:x) = a ++ linearizar x

main = do
print $ linearizar [ [1,2], [5], [0,4,2] ]
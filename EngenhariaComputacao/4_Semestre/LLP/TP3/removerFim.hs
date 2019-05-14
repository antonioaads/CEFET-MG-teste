removerFim :: Int -> [Int] -> [Int]
removerFim 0 x = []
removerFim n [] = []
removerFim n (a:x) = [a] ++ removerFim (length(x)-(n)) x

main = do
print $ removerFim 2 [1,2,3,4,5,6]
trocar :: Integer -> [Integer]
trocar 0 = []
trocar 1 = [1]
trocar n  
  | n>=100          = trocar (n `mod` 100) ++ [100]
  | n>=50 && n<100  = trocar (n `mod` 50) ++ [50]
  | n>=10 && n<50   = trocar (n `mod` 10) ++ [10]
  | n>=5  && n<10   = trocar (n `mod` 5) ++ [5]
  | n<5             = trocar (n-1) ++ [1]

main = do
print $  trocar 162
# Asked in goldman sachs interview 
# https://stackoverflow.com/questions/72893126/number-of-palindromic-subsequences-of-
# length-5-in-binary-string
from collections import Counter
mod=10**9+7
def countSubSequences(s): # TC O(N^2) # SC O(N)
    ctr = Counter([''])
    fives = 0
    for c in s:
        for ss, cnt in list(ctr.items()):
            ss += c
            if len(ss) < 5:
                ctr[ss] += cnt
            elif ss == ss[::-1]:
                fives += cnt
    return fives % mod 

print(countSubSequences("10001010"))
print(countSubSequences("0100110"))
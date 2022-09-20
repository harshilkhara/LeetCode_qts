# Approach 1- DP (Bottom-Up) 
def findLength(A,B): # TC O(m*n) // SC O(m*n)
	ans=0
	memo = [[0] * (len(B) + 1) for _ in range(len(A) + 1)]
	for i in range(len(A) - 1, -1, -1):
	    for j in range(len(B) - 1, -1, -1):
	        if A[i] == B[j]:
	            memo[i][j] = memo[i + 1][j + 1] + 1
	            if ans< memo[i][j]:
	            	ans=memo[i][j]
	return ans

# Approach 2- Binary Search with naive check (NOTE- it times out)
def findLength1(A,B): # TC O((m+n)* min(m,n)*log(min(m,n)) SC O(m^2)
    def check(length):
        seen = set(tuple(A[i:i+length]) 
                   for i in range(len(A) - length + 1))
        return any(tuple(B[j:j+length]) in seen 
                   for j in range(len(B) - length + 1))

    lo, hi = 0, min(len(A), len(B)) + 1
    while lo < hi:
        mi = (lo + hi) // 2
        if check(mi):
            lo = mi + 1
        else:
            hi = mi
    return lo - 1

import collections
# Approach 3- Binary Search with Rolling Hash (Rabin-Karp)
def findLength2(A,B): # TC O((m+n) * log(min(m,n))) // SC O(m)
	P, MOD = 113, 10**9 + 7
	Pinv = pow(P, MOD - 2, MOD)
	def check(guess):
	    def rolling(A, length):
	        if length == 0:
	            yield 0, 0
	            return

	        h, power = 0, 1
	        for i, x in enumerate(A):
	            h = (h + x * power) % MOD
	            if i < length - 1:
	                power = (power * P) % MOD
	            else:
	                yield h, i - (length - 1)
	                h = (h - A[i - (length - 1)]) * Pinv % MOD

	    hashes = collections.defaultdict(list)
	    for ha, start in rolling(A, guess):
	        hashes[ha].append(start)
	    for ha, start in rolling(B, guess):
	        iarr = hashes.get(ha, [])
	        if any(A[i: i + guess] == B[start: start + guess] for i in iarr):
	            return True
	    return False

	lo, hi = 0, min(len(A), len(B)) + 1
	while lo < hi:
	    mi = (lo + hi) // 2
	    if check(mi):
	        lo = mi + 1
	    else:
	        hi = mi
	return lo - 1

print(findLength([1,2,3,2,1],[3,2,1,4,7]))
print(findLength1([1,2,3,2,1],[3,2,1,4,7]))
print(findLength2([1,2,3,2,1],[3,2,1,4,7]))

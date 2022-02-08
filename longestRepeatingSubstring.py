'''
Here we have "two in one" problem :

	1) Perform a search by a substring length in the interval from 1 to N.
	
	Subtask one : Binary search by a substring length
	A naive solution would be to check all possible string length one by one starting from N - 1: 
	if there is a duplicate substring of length N - 1, then of length N - 2, etc. Note that if 
	there is a duplicate substring of length k, that means that there is a duplicate substring of 
	length k - 1. Hence one could use a binary search by string length here, and have the first 
	problem solved in O(logN) time.

	2) Check if there is a duplicate substring of a given length L.

	Subtask two : Check if there is a duplicate substring of length L

	We will discuss here three different ideas how to proceed. They are all based on sliding window + 
	hashset, though their performance and space consumption are quite different.

	1) Linear-time slice + hashset of already seen strings O((N−L)L) time complexity 
	   and huge space consumption in the case of large strings.

	2) Linear-time slice + hashset of hashes of already seen strings O((N−L)L) time 
	   complexity and moderate space consumption even in the case of large strings.

	3) Rabin-Karp = constant-time slice + hashset of hashes of already seen strings. Hashes are 
	   computed with the rolling hash algorithm O(N−L) time complexity and moderate space 
	   consumption even in the case of large strings.

'''
'''
Approach 1- Binary search + hashset of already seen strings # TC O(n log n) // SC O(n^2)

The idea is straightforward :

	Move a sliding window of length L along the string of length N.

	Check if the string in the sliding window is in the hashset of already seen strings.

	If yes, the duplicate substring is right here.

	If not, save the string in the sliding window in the hashset.

'''
def search(L,n,s):
	"""
	Search a substring of given length
	that occurs at least 2 times.
	@return start position if the substring exits and -1 otherwise.
	"""
	seen = set()
	for start in range(0, n - L + 1):
	    tmp = s[start:start + L]
	    if tmp in seen:
	        return start
	    seen.add(tmp)
	return -1

def longestRepeatingSubstring(s): # TC O(n log n) // SC O(n^2)
	n = len(s)        
	# binary search, L = repeating string length
	left, right = 1, n
	while left <= right:
	    L = left + (right - left) // 2
	    if search(L, n, s) != -1:
	        left = L + 1
	    else:
	        right = L - 1
	       
	return left - 1

print(longestRepeatingSubstring("abbaba"))

'''
Approach 2- Binary Search + Hashset of HASHES of already seen strings # TC O(n log n) // SC O(n)

'''
def search1(L,n,s):
	"""
	Search a substring of given length
	that occurs at least 2 times.
	@return start position if the substring exits and -1 otherwise.
	"""
	seen = set()
	for start in range(0, n - L + 1):
	    tmp = s[start:start + L]
	    h = hash(tmp)
	    if h in seen:
	        return start
	    seen.add(h)
	return -1

def longestRepeatingSubstring1(s): # TC O(n log n) // SC O(n)
	n = len(s)        
	# binary search, L = repeating string length
	left, right = 1, n
	while left <= right:
	    L = left + (right - left) // 2
	    if search1(L, n, s) != -1:
	        left = L + 1
	    else:
	        right = L - 1
	       
	return left - 1

print(longestRepeatingSubstring1("abcd"))

'''
Approach 3- Binary Search + Rabin-Karp algorithm # TC O(n log n).O(log n) // SC O(n)

search(L) :

	Compute the hash of substring S.substring(0, L) and initiate the hashset of already seen 
	substring with this value.

	Iterate over the start position of substring : from 1 to N - LN−L.

		Compute rolling hash based on the previous hash value.

		Return start position if the hash is in the hashset, because that means one met the 
		duplicate.

		Otherwise, add hash in the hashset.

	Return -1, that means there is no duplicate string of length L.

'''
def search2(L, a, modulus, n, nums):
	"""
	Rabin-Karp with polynomial rolling hash.
	Search a substring of given length
	that occurs at least 2 times.
	@return start position if the substring exits and -1 otherwise.
	"""
	# compute the hash of string S[:L]
	h = 0
	for i in range(L):
	    h = (h * a + nums[i]) % modulus
	      
	# already seen hashes of strings of length L
	seen = {h} 
	# const value to be used often : a**L % modulus
	aL = pow(a, L, modulus) 
	for start in range(1, n - L + 1):
	    # compute rolling hash in O(1) time
	    h = (h * a - nums[start - 1] * aL + nums[start + L - 1]) % modulus
	    if h in seen:
	        return start
	    seen.add(h)
	return -1

def longestRepeatingSubstring2(s): # TC O(n log n).O(log n) // SC O(n)
	n = len(s)
	# convert string to array of integers
	# to implement constant time slice
	nums = [ord(s[i]) - ord('a') for i in range(n)]
	# base value for the rolling hash function
	a = 26
	# modulus value for the rolling hash function to avoid overflow
	modulus = 2**24

	# binary search, L = repeating string length
	left, right = 1, n
	while left <= right:
	    L = left + (right - left) // 2
	    if search2(L, a, modulus, n, nums) != -1:
	        left = L + 1
	    else:
	        right = L - 1
	       
	return left - 1

print(longestRepeatingSubstring2("aabcaabdaab"))


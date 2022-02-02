#Approach- Brute Force 
def findRepeatedDnaSequences(s): # TC O((n-l)l)  // SC O((n-l)l)
	L, n = 10, len(s)     
	seen, output = set(), set()

	# iterate over all sequences of length L
	for start in range(n-L+1):          # TC O(n-l)
	    tmp = s[start:start + L]         # TC O(l)
	    if tmp in seen:
	        output.add(tmp[:])
	    seen.add(tmp)
	return output

'''
Approach- Rabin-Karp: Constant-time slice using rolling hash

Rabin-Karp algorithm is used to perform a multiple pattern search. It's used for plagiarism detection 
and in bioinformatics to look for similarities in two or more proteins.

Detailed implementation of Rabin-Karp algorithm for quite a complex case you could find in the 
article Longest Duplicate Substring, here we do a very basic implementation.

The idea is to slice over the string and to compute the hash of the sequence in the sliding window, 
both in a constant time.

Let's use string AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT as an example. First, convert string to integer 
array:

'A' -> 0, 'C' -> 1, 'G' -> 2, 'T' -> 3
AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT -> 00000111110000011111100000222333. Time to compute hash for the 
first sequence of length L: 0000011111. The sequence could be considered as a number in a numeral 
system with the base 4 and hashed as

h = h * a + nums[i] ----> computing first hash

h = h * a - nums[start - 1] * aL + nums[start + L - 1] ---> slicing and hashing 

Voila, window slice and hash recomputation are both done in a constant time.

Algorithm

Iterate over the start position of sequence : from 1 to N - L.

	If start == 0, compute the hash of the first sequence s[0: L].

	Otherwise, compute rolling hash from the previous hash value.

	If hash is in the hashset, one met a repeated sequence, time to update the output.

	Otherwise, add hash in the hashset.

Return output list.

'''
def findRepeatedDnaSequences1(s): # TC O(n-l) // SC O(n-l)
	L, n = 10, len(s)
	if n <= L:
	    return []

	# rolling hash parameters: base a
	a = 4
	aL = pow(a, L) 

	# convert string to array of integers
	to_int = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
	nums = [to_int.get(s[i]) for i in range(n)]

	h = 0
	seen, output = set(), set()
	# iterate over all sequences of length L
	for start in range(n - L + 1):
	    # compute hash of the current sequence in O(1) time
	    if start != 0:
	        h = h * a - nums[start - 1] * aL + nums[start + L - 1]
	    # compute hash of the first sequence in O(L) time
	    else:
	        for i in range(L):
	            h = h * a + nums[i]
	    # update output and hashset of seen sequences
	    if h in seen:
	        output.add(s[start:start + L])   # SC O(n-l)
	    seen.add(h)
	return output

print(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
print(findRepeatedDnaSequences1("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
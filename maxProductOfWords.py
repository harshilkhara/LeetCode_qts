# Approach 1- Brute Force 
def maxProductOfWords(words):  # TC O(N^2*f(L1*L2)) // SC O(1)
	def no_common_letters(s1,s2):
		for i in s1:
			if i in s2:
				return False 
		return True 

	max_product=0
	for i in range(len(words)):
		for j in range(i+1,len(words)):
			if no_common_letters(words[i],words[j]):
				max_product=max(max_product,len(words[i]*len(words[j])))
	return max_product

# Approach 2- Bitmasks + Precomputation 
def maxProductOfWords1(words):# TC O(N^2+L) where L is total length of all words together// SC O(N)
	n = len(words)
	masks = [0] * n
	lens = [0] * n
	bit_number = lambda ch : ord(ch) - ord('a')

	for i in range(n):
	    bitmask = 0
	    for ch in words[i]:
	        # add bit number bit_number in bitmask
	        bitmask |= 1 << bit_number(ch)
	    masks[i] = bitmask
	    lens[i] = len(words[i])

	max_val = 0
	for i in range(n):
	    for j in range(i + 1, n):
	        if masks[i] & masks[j] == 0:
	            max_val = max(max_val, lens[i] * lens[j])
	return max_val

# Approach 3- Optimise the number of comparisons- Bitmasks + Precomputation + Hashmap


print(maxProductOfWords(["abcw","baz","foo","bar","xtfn","abcdef"]))
print(maxProductOfWords1(["abcw","baz","foo","bar","xtfn","abcdef"]))
#print(maxProductOfWords2(["abcw","baz","foo","bar","xtfn","abcdef"]))
	
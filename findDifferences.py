#Approach- Brute Force                 NOTE- t > s  and t = s + 1
def findDifferences(s,t): # TC O(n log n) // SC O(1) or SC O(n) depending on sorting algo
	# Sort both the strings
	sorted_s = sorted(s)
	sorted_t = sorted(t)

	# Character by character comparison
	i = 0
	while i < len(s):
	    if sorted_s[i] != sorted_t[i]:
	        return sorted_t[i]
	    i += 1
	return sorted_t[i]

#Approach- Hashmap
from collections import Counter       # NOTE- t > s  and t = s + 1
def findDifferences1(s,t):  # TC O(n) // SC O(1)
	# Prepare a counter for string s.
	# This holds the characters as keys and respective frequency as value.
	counter_s = Counter(s)
	# Iterate through string t and find the character which is not in s.
	for ch in t:
		if ch not in counter_s or counter_s[ch] == 0:
		    return ch
		else:
		    # Once a match is found we reduce frequency left.
		    # This eliminates the possibility of a false match later.
		    counter_s[ch] -= 1

#Approach- Bit manipulation 
def findDifferences2(s,t): # TC O(n) // SC O(n)
	# Initialize ch with 0, because 0 ^ X = X
	# 0 when XORed with any bit would not change the bits value.
	ch = 0

	# XOR all the characters of both s and t.
	for char_ in s:
	    ch ^= ord(char_)

	for char_ in t:
	    ch ^= ord(char_)

	# What is left after XORing everything is the difference.
	return chr(ch)

#Approach - Order sum and difference 
def findDifferences3(s,t):
	s_ord, t_ord = 0, 0
	for ss in s:
	 s_ord += ord(ss)
	for tt in t:
	 t_ord += ord(tt)
	return chr(t_ord - s_ord)

print(findDifferences("abcd","abcde"))
print(findDifferences1("abcd","abcde"))
print(findDifferences2("a","aa"))
print(findDifferences3("a","ab"))

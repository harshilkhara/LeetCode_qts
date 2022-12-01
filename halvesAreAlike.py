# Approach 1- Counting in place 
def halvesAreAlike(s): # TC O(n) // SC O(1)
	vowels="aeiouAEIOU"
	n=len(s)
	aVowel=0
	for i in range(n//2):
	    if s[i] in vowels:
	        aVowel+=1

	bVowel=0
	for i in range(n//2,n):
	    if s[i] in vowels:
	        bVowel+=1

	return aVowel==bVowel

print(halvesAreAlike("book"))
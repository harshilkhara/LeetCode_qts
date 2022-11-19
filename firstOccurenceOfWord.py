# Approach 1- Sliding window of fixed length 
# Very similar to approach 1 of findRepeatedDnaSequences.py 
def firstOccurenceOfWord(haystack,needle):
	l=len(needle)
	n=len(haystack)
	for i in range(n-l+1):
		temp=haystack[i:i+l]
		if temp==needle:
			return i 
	return -1 

# Approach 2- Built in function
def firstOccurenceOfWord1(haystack,needle):
	return haystack.index(needle)


print(firstOccurenceOfWord("sadbutsad","but"))
print(firstOccurenceOfWord1("sadbutsad","sad"))
# Approach 1- Concatenate and compare
def arrayStringsAreEqual(word1,word2): # TC O(n*k) // SC O(n*k)
	result1=""
	for word in word1:
		result1+=word 
	result2="" 
	for word in word2:
		result2+=word 
	if result1==result2:
		return True 
	return False 

print(arrayStringsAreEqual(["ab","c"],["a","bc"]))

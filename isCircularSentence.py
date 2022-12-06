# Approach 1- Single Iteration 
def isCircularSentence(sentence): # TC O(n) // SC O(n)
	words=sentence.split()
	for i in range(len(words)-1):
	    firstWordLength=len(words[i])      
	    if (words[i][firstWordLength-1]!=words[i+1][0]):
	        return False 

	lastWordLength=len(words[len(words)-1])

	if (words[len(words)-1][lastWordLength-1]!=words[0][0]):
	    return False 
	   
	return True

print(isCircularSentence("leetcode exercises sound delightful"))
# Approach 1- Simple two-for loops
def minDeletionSize(strs): # TC O(m*n) // SC O(1)
	wordLen=len(strs[0])
	n=len(strs)
	delete=0
	for i in range(wordLen):
	    for j in range(n-1):
	        if strs[j][i]>strs[j+1][i]:
	            delete+=1 
	            break 

	return delete 

print(minDeletionSize(["cba","daf","ghi"]))
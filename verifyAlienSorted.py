def verifyAlienSorted(words,order): # TC O(M) // SC O(1)
	orderMap={}
	for idx,char in enumerate(order):
	    orderMap[char]=idx

	for i in range(len(words)-1):
	    for j in range(len(words[i])):
	        if j>=len(words[i+1]):
	            return False 
	        
	        if words[i][j]!=words[i+1][j]:
	            if orderMap[words[i][j]]>orderMap[words[i+1][j]]:
	                return False
	            else:
	                break
	return True

print(verifyAlienSorted(["hello","leetcode"],"hlabcdefgijkmnopqrstuvwxyz"))
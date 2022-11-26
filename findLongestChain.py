# Approach 1- Greedy
def findLongestChain(pairs): # TC O(n log n) // SC O(n)
	pairs.sort(key=lambda x:x[1])
	cur,count=float('-inf'),0
	for pair in pairs:
		if cur < pair[0]:
			cur=pair[1]
			count+=1
	return count 

print(findLongestChain([[1,2],[2,3],[3,4]]))
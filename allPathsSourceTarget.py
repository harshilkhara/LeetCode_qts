# Approach 1- Backtrack
def allPathsSourceTarget(graph): # TC O(2^n.n) // SC O(n)

	def backtrack(path,node):
		if target==node:
			result.append(list(path))
			return 
		for nextNode in graph[node]:
			path.append(nextNode)
			backtrack(path,nextNode)
			path.pop()

	target=len(graph)-1
	result=[]
	path=[0]
	backtrack(path,0)
	return result
	

print(allPathsSourceTarget([[1,2],[3],[3],[]]))
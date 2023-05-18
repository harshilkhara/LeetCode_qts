class Solution:
# Approach 1- Counting indegrees of a node
	def findSmallestSetOfVertices(self, n, edges): # TC O(n) SC // O(n)
		incoming=[False]*n
		for edge in edges:
		    incoming[edge[1]]=True

		answer=[]
		for i in range(n):
		    if not incoming[i]:
		        answer.append(i)

		return answer

s=Solution()
print(s.findSmallestSetOfVertices(6, [[0,1],[0,2],[2,5],[3,4],[4,2]]))
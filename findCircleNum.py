from implementUnionFind import *  
from collections import deque
class Solution:
# Approach 1- DFS
	def findCircleNum(self, isConnected): # TC O(n^2) // SC O(n)
	    n=len(isConnected)
	    visited=[False]*n
	    
	    def dfs(node):
	        visited[node]=True
	        for i in range(n):
	            if isConnected[node][i]==1 and not visited[i]:
	                dfs(i)
	    
	    answer=0
	    for i in range(n):
	        if not visited[i]:
	            dfs(i)
	            answer+=1
	    
	    return answer

# Approach 2- BFS
	def findCircleNum1(self, isConnected): # TC O(n^2) // SC O(n)
		n=len(isConnected)
		visited=[False]*n

		def bfs(node):
		    queue=deque()
		    queue.append(node)
		    visited[node]=True
		    while queue:
		        node=queue.popleft()
		        
		        for i in range(n):
		            if isConnected[node][i]==1 and not visited[i]:
		                queue.append(i)
		                visited[i]=True

		answer=0
		for i in range(n):
		    if not visited[i]:
		        bfs(i)
		        answer+=1

		return answer

# Approach 3- Union-Find
	def findCircleNum2(self, isConnected): # TC O(n^2) // SC O(n)
		n=len(isConnected)
		uf=UnionFind(n)
		answer=n

		for i in range(n):
			for j in range(n):
				if isConnected[i][j]==1 and uf.find(i)!=uf.find(j):
					answer-=1
					uf.union(i,j)

		return answer

s=Solution()
print(s.findCircleNum([[1,0,0],[0,1,0],[0,0,1]]))
print(s.findCircleNum1([[1,0,0],[0,1,0],[0,0,1]]))
print(s.findCircleNum2([[1,0,0],[0,1,0],[0,0,1]]))

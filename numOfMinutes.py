class Solution:
# Approach 1- DFS
    def numOfMinutes(self, n, headID, manager, informTime): # TC O(n) // SC O(n)
        adj={}
        for i in range(n):
            if manager[i]!=-1:
                adj.setdefault(manager[i], []).append(i)

        def dfs(node, time):
            nonlocal maxTime
            
            maxTime=max(time, maxTime)
            
            if node not in adj: return 
            
            for child in adj[node]:
                dfs(child, time+informTime[node])
        
        maxTime=float('-inf')
        
        dfs(headID, 0)
        
        return maxTime

s=Solution()
print(s.numOfMinutes(6,2,[2,2,-1,2,2,2],[0,0,1,0,0,0]))

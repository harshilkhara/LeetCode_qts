from collections import deque
class Solution:
# Approach 1- Topological sort [using Kahn's algorithm]
    def largestPathValue(self, colors, edges): # TC O(m+n) // SC O(m+n)
        n=len(colors)
        adj={}
        indegrees=[0]*n 
        for a,b in edges:
            adj.setdefault(a,[]).append(b)
            indegrees[b]+=1 

        #
        count=[[0 for _ in range (26)] for _ in range(n)]
        q=deque()
        for i in range(n):
            if indegrees[i]==0:
                q.append(i)

        answer, nodeSeen=1, 0 
        while q:
            node=q.popleft()
            count[node][ord(colors[node])-ord('a')]+=1
            answer=max(answer, count[node][ord(colors[node])-ord('a')])
            nodeSeen+=1
            if node not in adj:
                continue 

            for neighbor in adj[node]:
                for i in range(26):
                    count[neighbor][i]=max(count[neighbor][i], count[node][i])

                indegrees[neighbor]-=1 
                if indegrees[neighbor]==0:
                    q.append(neighbor)

        return -1 if nodeSeen<n else answer

s=Solution()
print(s.largestPathValue("abaca",[[0,1],[0,2],[2,3],[3,4]]))
        
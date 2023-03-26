from collections import deque
class Solution:
    def longestCycle(self, edges): # TC O(n) // SC O(n)
        n=len(edges)
        indegrees=[0]*n
        visit=[False]*n
        
        for edge in edges:
            if edge!=-1:
                indegrees[edge]+=1
        
        # Kahn's algorithm starts
        q=deque()
        for i in range(n):
            if indegrees[i]==0:
                q.append(i)
        
        while q:
            node=q.popleft()
            visit[node]=True 
            neighbor=edges[node]
            if neighbor!=-1:
                indegrees[neighbor]-=1
                if indegrees[neighbor]==0:
                    q.append(neighbor)
        
        # Kahn's algorithm ends 
        answer=-1
        for i in range(n):
            if not visit[i]:
                visit[i]=True
                neighbor=edges[i]
                count=1
                while neighbor!=i:
                    visit[neighbor]=True
                    count+=1
                    neighbor=edges[neighbor]
                
                answer=max(answer, count)
        
        return answer

s=Solution()
print(s.longestCycle([3,3,4,2,3]))
from collections import deque
class Solution:
# Approach 1- DFS
    def minReorder(self, n, connections): # TC O(n) // SC O(n)
        
        def dfs(node, parent):
            nonlocal answer
            
            if node not in adj: return 
            
            for neighbor in adj[node]:
                child=neighbor[0]
                sign=neighbor[1]
                if child!=parent:
                    answer+=sign
                    dfs(child, node)
        
        adj={}
        answer=0
        
#         for conn in connections:
#             if conn[0] not in adj:
#                 conn[0]=[]
#             if conn[1] not in adj:
#                 conn[1]=[]
            
#             adj[conn[0]].append([conn[1], 1])
#             adj[conn[1]].append([conn[0],0])
#         adj = {}

        for conn in connections:
            adj.setdefault(conn[0], []).append([conn[1], 1])
            adj.setdefault(conn[1], []).append([conn[0], 0])
        
        dfs(0,-1)
        return answer
        
# Approach 2- BFS
    def minReorder1(self, n, connections): # TC O(n) // SC O(n)

        def bfs(node):
            nonlocal answer
            visit=[False]*(n+1)
            visit[node]=True
            q=deque()
            q.append(node)
            while q:
                node=q.popleft()
                if node not in adj: continue 
                
                for child,sign in adj[node]:
                    if not visit[child]:
                        answer+=sign
                        visit[child]=True
                        q.append(child)
            
            
            return
                  
        adj={}
        answer=0
        
#         for conn in connections:
#             if conn[0] not in adj:
#                 conn[0]=[]
#             if conn[1] not in adj:
#                 conn[1]=[]
            
#             adj[conn[0]].append([conn[1], 1])
#             adj[conn[1]].append([conn[0],0])
#         adj = {}

        for conn in connections:
            adj.setdefault(conn[0], []).append([conn[1], 1])
            adj.setdefault(conn[1], []).append([conn[0], 0])
        
        bfs(0)
        return answer 


s=Solution()
print(s.minReorder(6,[[0,1],[1,3],[2,3],[4,0],[4,5]]))
print(s.minReorder1(6,[[0,1],[1,3],[2,3],[4,0],[4,5]]))

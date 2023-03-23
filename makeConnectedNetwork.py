class Solution:
# Approach 1- DFS
    def makeConnectedNetwork(self, n, connections): # TC O(n+e) // SC O(n+e)
            def dfs(node):
                visit[node]=True
                if node not in adj:
                    return
                
                for neighbor in adj[node]:
                    if not visit[neighbor]:
                        visit[neighbor]=True
                        dfs(neighbor)
    
        
        if len(connections)<n-1: return -1
        
        adj = {}
        for connection in connections:
            if connection[0] not in adj:
                adj[connection[0]] = []
            if connection[1] not in adj:
                adj[connection[1]] = []
            adj[connection[0]].append(connection[1])
            adj[connection[1]].append(connection[0])
        
        visit=[False]*(len(connections)+1)
        answer=0
        for i in range(n):
            if not visit[i]:
                answer+=1
                dfs(i)
        
        return answer-1

# Approach 2- BFS
    def makeConnectedNetwork(self, n, connections): # TC O(n+e) // SC O(n+e)
            def bfs(node):
                q=deque()
                q.append(node)
                visit[node]=True
                while q:
                    node=q.popleft()
                    if node not in adj: continue 
                    
                    for neighbor in adj[node]:
                        if not visit[neighbor]:
                            visit[neighbor]=True
                            q.append(neighbor)
                
                return

        if len(connections)<n-1: return -1
        
        adj = {}
        for connection in connections:
            if connection[0] not in adj:
                adj[connection[0]] = []
            if connection[1] not in adj:
                adj[connection[1]] = []
            adj[connection[0]].append(connection[1])
            adj[connection[1]].append(connection[0])
        
        visit=[False]*(len(connections)+1)
        answer=0
        for i in range(n):
            if not visit[i]:
                answer+=1
                bfs(i)
        
        return answer-1


# Approach 3- Union-Find (Disjoint sets)    
    def makeConnectedNetwork(self, n, connections): # TC O(n+e) // SC O(n)
        
        if len(connections) <n-1: return -1
        
        def find(vertex):
            if parent[vertex]!=vertex:
                parent[vertex]=find(parent[vertex])
            
            return parent[vertex] 
        
        def union(v1, v2):
            v1=find(v1)
            v2=find(v2)
            
            if v1!=v2:
                if size[v1]>size[v2]:
                    size[v1]+=size[v2]
                    parent[v2]=v1
                else:
                    size[v2]+=size[v1]
                    parent[v1]=v2
            
            return 
        
        parent=[i for i in range(n)]
        size=[1 for i in range(n)]
        answer=n
        
        for conn in connections:
            if find(conn[0])!=find(conn[1]):
                answer-=1
                union(conn[0],conn[1])
        
        return answer-1


s=Solution()
print(s.makeConnectedNetwork(4,[[0,1],[0,2],[1,2]]))
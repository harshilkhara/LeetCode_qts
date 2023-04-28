from collections import deque
class Solution:
# Approach 1- BFS 
    def numSimilarGroups(self, strs): # TC O(n^2 . m) // SC O(n^2)

        def isSimilar(a, b):
            diff=0
            for i in range(len(a)):
                if a[i]!=b[i]:
                    diff+=1
            
            return diff==0 or diff==2
        
        def bfs(node, adj, visited):
            queue=deque()
            queue.append(node)
            visited[node]=True
            while queue:
                node=queue.popleft()
                
                if node not in adj:
                    continue 
                
                for neighbor in adj[node]:
                    if not visited[neighbor]:
                        visited[neighbor]=True
                        queue.append(neighbor)
    
        n=len(strs)
        count=0
        adj={}
        visited=[False]*n
        for i in range(n):
            for j in range(i+1, n):
                if isSimilar(strs[i], strs[j]):
                    adj.setdefault(i, []).append(j)
                    adj.setdefault(j, []).append(i)
        
        for i in range(n):
            if not visited[i]:
                bfs(i, adj, visited)
                count+=1
        
        return count

# Approach 2- DFS
    def numSimilarGroups1(self, strs): # TC O(n^2 . m) // SC O(n^2)

        def isSimilar(a, b):
            diff=0
            for i in range(len(a)):
                if a[i]!=b[i]:
                    diff+=1
            
            return diff==0 or diff==2
        
        def dfs(node, adj, visited):
            visited[node]=True      
            if node not in adj:
                return

            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor]=True
                    dfs(neighbor, adj, visited)
    
        n=len(strs)
        count=0
        adj={}
        visited=[False]*n
        for i in range(n):
            for j in range(i+1, n):
                if isSimilar(strs[i], strs[j]):
                    adj.setdefault(i, []).append(j)
                    adj.setdefault(j, []).append(i)
        
        for i in range(n):
            if not visited[i]:
                dfs(i, adj, visited)
                count+=1
        
        return count

# Approach 3-DSU
    def numSimilarGroups2(self, strs): # TC O(n^2 . m) // SC O(n)
        def isSimilar(a, b):
            diff=0
            for i in range(len(a)):
                if a[i]!=b[i]:
                    diff+=1
            
            return diff==0 or diff==2
        
        def find(vertex, parent):
            if parent[vertex]!=vertex:
                parent[vertex]=find(parent[vertex], parent)

            return parent[vertex]
            

        def union(v1 ,v2, parent, size):
            v1=find(v1, parent)
            v2=find(v2, parent)

            if v1!=v2:
                if size[v1]>size[v2]:
                    parent[v2]=v1
                    size[v1]+=size[v2]
                else:
                    parent[v2]=v1
                    size[v2]+=size[v1]

            return 

        n=len(strs)
        count=n
        adj={}
        parent=[i for i in range(n)]
        size=[1]*n
        for i in range(n):
            for j in range(i+1, n):
                if isSimilar(strs[i], strs[j]) and find(i, parent)!=find(j, parent):
                    count-=1
                    union(i, j, parent, size)
        
        return count



s=Solution()
print(s.numSimilarGroups(["tars","rats","arts","star"]))
print(s.numSimilarGroups1(["tars","rats","arts","star"]))
print(s.numSimilarGroups2(["tars","rats","arts","star"]))

from collections import deque
class Solution:
# Approach 1- Topological sort using Kahn's algorithm
    def eventualSafeNodes(self, graph): # TC O(n+m) SC O(n+m)
        n = len(graph)
        indegree = [0] * n
        adj = [[] for _ in range(n)]

        for i in range(n):
            for node in graph[i]:
                adj[node].append(i)
                indegree[i] += 1

        q = deque()
        # Push all the nodes with indegree zero in the queue.
        for i in range(n):
            if indegree[i] == 0:
                q.append(i)

        safe = [False] * n
        while q:
            node = q.popleft()
            safe[node] = True

            for neighbor in adj[node]:
                # Delete the edge "node -> neighbor".
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)

        safeNodes = []
        for i in range(n):
            if safe[i]:
                safeNodes.append(i)

        return safeNodes

# Approach 2- DFS
    def dfs(self, node, adj, visit, inStack): # TC O(n+m) SC O(n+m)
        # If the node is already in the stack, we have a cycle.
        if inStack[node]:
            return True
        if visit[node]:
            return False
        # Mark the current node as visited and part of current recursion stack.
        visit[node] = True
        inStack[node] = True
        for neighbor in adj[node]:
            if self.dfs(neighbor, adj, visit, inStack):
                return True
        # Remove the node from the stack.
        inStack[node] = False
        return False

    def eventualSafeNodes1(self, graph):
        n = len(graph)
        adj = [[] for _ in range(n)]

        for i in range(n):
            for node in graph[i]:
                adj[i].append(node)

        visit = [False] * n
        inStack = [False] * n

        for i in range(n):
            self.dfs(i, adj, visit, inStack)

        safeNodes = []
        for i in range(n):
            if not inStack[i]:
                safeNodes.append(i)

        return safeNodes

s=Solution()
print(s.eventualSafeNodes([[1,2],[2,3],[5],[0],[5],[],[]]))
print(s.eventualSafeNodes1([[1,2],[2,3],[5],[0],[5],[],[]]))


from collections import deque
class Solution:
# Approach 1- DFS 
    def dfs(self, grid, r, c, visited): # TC O(m*n) // SC O(m*n)
        rows=len(grid)
        columns=len(grid[0])
        
        if r<0 or r>=rows or c<0 or c>=columns:
            return False 
        
        if grid[r][c]==1 or visited[r][c]:
            return True
        
        
        visited[r][c]=True
        isClosed=True
        
        for i,j in [[0,-1],[0,1],[1,0],[-1,0]]:
            if not self.dfs(grid, r+i, c+j, visited):
                isClosed=False 
        
        return isClosed

    def closedIsland(self, grid):
        rows=len(grid)
        columns=len(grid[0])
        visited=[[False for _ in range(columns)] for _ in range(rows)]
        closedIslands=0
        for r in range(rows):
            for c in range(columns):
                if grid[r][c]==0 and not visited[r][c] and self.dfs(grid, r, c, visited):
                    closedIslands+=1
        
        
        return closedIslands

# Approach 2- BFS 
    def bfs(self, grid, r, c, visited): # TC O(m*n) // SC O(m*n)
        rows=len(grid)
        columns=len(grid[0])
        q=deque()
        q.append([r,c])
        visited[r][c]=True 
        isClosed=True 
        while q:
            x,y=q.popleft()

            for i,j in [[0,-1],[0,1],[1,0],[-1,0]]:
                m=x+i
                n=y+j 

                if m<0 or m>=rows or n<0 or n>=columns:
                    isClosed=False 
                elif grid[m][n]==0 and not visited[m][n]:
                    q.append([m,n])
                    visited[m][n]=True 

        return isClosed

    def closedIsland1(self, grid):
        rows=len(grid)
        columns=len(grid[0])
        visited=[[False for _ in range(columns)] for _ in range(rows)]
        closedIslands=0
        for r in range(rows):
            for c in range(columns):
                if grid[r][c]==0 and not visited[r][c] and self.bfs(grid, r, c, visited):
                    closedIslands+=1
        
        
        return closedIslands
        
        
s=Solution()
print(s.closedIsland([[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]))
print(s.closedIsland1([[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]))
import collections

# Approach 1- BFS  (From neetcode youtube)
def numIslands(grid):
    if not grid:
        return 0 
    
    rows, cols= len(grid), len(grid[0])
    visited=set()
    islands=0
    
    def bfs(r,c):
        q=collections.deque()
        visited.add((r,c))
        q.append((r,c))
        
        while q:
            row,col=q.popleft() # if we just pop() it will behave as stack, hence DFS (Iterative)
            directions=[[1,0],[0,1],[0,-1],[-1,0]]
            
            for dr,dc in directions:
                r,c= row+dr, col+dc
                if (r in range(rows) and c in range(cols) and grid[r][c]=="1"
                   and ((r,c) not in visited)):
                    q.append((r,c))
                    visited.add((r,c))
        
    
    for r in range(rows):
        for c in range(cols):
            if grid[r][c]=="1" and (r,c) not in visited:
                bfs(r,c)
                islands+=1
    return islands

print(numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
        
        
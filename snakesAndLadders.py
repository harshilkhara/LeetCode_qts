from collections import deque
# Approach 1- BFS 
def snakesAndLadders(board): # TC O(n^2) // SC O(n^2)
    n=len(board)
    columns=list(range(0,n))
    label=1
    cells=[None]*(n*n+1)
    for row in range(n-1,-1,-1):
        for col in columns:
            cells[label]=(row,col)
            label+=1
        columns.reverse()
    
    dist=[-1]*(n*n+1)
    dist[1]=0
    q=deque([1])
    while q:
        curr=q.popleft()
        for next in range(curr+1, min(curr+6,n*n)+1):
            row,col=cells[next]
            destination=(board[row][col] if board[row][col]!=-1 else next)
            if dist[destination]==-1:
                dist[destination]=dist[curr]+1
                q.append(destination)
    return dist[n*n]

print(snakesAndLadders([[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],
    [-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],
    [-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]))
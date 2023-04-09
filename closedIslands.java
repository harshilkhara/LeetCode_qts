import java.util.*;
// Approach 1- DFS
class Solution{ // TC O(m*n) SC O(m*n)
	public boolean dfs(int[][] grid, int r, int c, boolean[][] visited){
		int rows=grid.length;
		int columns=grid[0].length;

		if (r<0 || r>=rows || c<0 || c>=columns){
			return false;
		}

		if (grid[r][c]==1 || visited[r][c]){
			return true;
		}

		visited[r][c]=true;
		boolean isClosed=true;
		int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
		for(int[] dir: directions){
			int i=r+dir[0], j=c+dir[1];
			if(!dfs(grid, i, j, visited)){
				isClosed=false;
			}
		}
		return isClosed;
	}

	public int closedIslands(int[][] grid){
		int rows=grid.length;
		int columns=grid[0].length;
		boolean[][] visited=new boolean[rows][columns];
		int count=0;
		for(int r=0; r<rows; r++){
			for(int c=0; c<columns; c++){
				if(grid[r][c]==0 && !visited[r][c] && dfs(grid,r,c,visited)){
					count++;
				}
			}
		}
		return count;
	}
}

// Approach 2- BFS 
class Solution { // TC O(m*n) SC O(m*n)
	public boolean bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        boolean isClosed = true;

        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int r = x +dirx[i];
                int c = y +diry[i];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    // (x, y) is a boundary cell.
                    isClosed = false;
                } else if (grid[r][c] == 0 && !visit[r][c]) {
                    q.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }
        return isClosed;
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visit[i][j] && bfs(i, j, m, n, grid, visit)) {
                    count++;
                }
            }
        }
        return count;
    }
}


class closedIslands{
	public static void main(String[] args) {
		int[][] grid={{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},
		{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		Solution s= new Solution();
		System.out.println(s.closedIslands(grid));
	}
}
import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(m*n) SC O(m*n)
    public void dfs(int[][] grid, int r, int c, boolean[][] visited){
        int rows=grid.length;
        int columns=grid[0].length;
        
        if(r<0 || r>=rows || c<0 || c>=columns || grid[r][c]==0 || visited[r][c]){
            return;
        }

        visited[r][c]=true;
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] dir: directions){
            int i=r+dir[0], j=c+dir[1];
            dfs(grid, i, j, visited);
            }
        return;
    }
    
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[rows][columns];
        
        
        for(int i=0; i<rows; i++){
            // first column
            if(grid[i][0]==1 && !visited[i][0]){
                dfs(grid, i, 0,visited);
            }
            
            // last column
            if(grid[i][columns-1]==1 && !visited[i][columns-1]){
                dfs(grid, i, columns-1, visited);
            }
        }
        
        
        for(int i=0; i<columns; i++){
            // first row
            if(grid[0][i]==1 && !visited[0][i]){
                dfs(grid, 0, i,visited);
            }
            
            // last row
            if(grid[rows-1][i]==1 && !visited[rows-1][i]){
                dfs(grid, rows-1, i, visited);
            }
        }
        
        for(int r=0; r<rows; r++){
            for(int c=0; c<columns; c++){
                if(grid[r][c]==1 && !visited[r][c]){
                    count++;
                }
            }
        }
        return count;
    }
}

// Approach 2- BFS 
class Solution1{ // TC O(m*n) SC O(m*n)
    public void bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];  // row nnumber
            y = temp[1];  // column number

            for (int i = 0; i < 4; i++) {
                int r = x + dirx[i];
                int c = y + diry[i];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    continue;
                } else if (grid[r][c] == 1 && !visit[r][c]) {
                    q.offer(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }
        return;
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            // First column.
            if (grid[i][0] == 1 && !visit[i][0]) {
                bfs(i, 0, m, n, grid, visit);
            }
            // Last column.
            if (grid[i][n - 1] == 1 && !visit[i][n - 1]) {
                bfs(i, n - 1, m, n, grid, visit);
            }
        }

        for (int i = 0; i < n; ++i) {
            // First row.
            if (grid[0][i] == 1 && !visit[0][i]) {
                bfs(0, i, m, n, grid, visit);
            }
            // Last row.
            if (grid[m - 1][i] == 1 && !visit[m - 1][i]) {
                bfs(m - 1, i, m, n, grid, visit);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

class numEnclaves{
    public static void main(String[] args) {
        int[][] grid={{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        Solution s=new Solution();
        System.out.println(s.numEnclaves(grid));
    }
}
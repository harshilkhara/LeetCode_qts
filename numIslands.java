import java.util.*;

// Approach 1- DFS (Recursive)
class Solution { // TC O(m*n) SC O(m*n)
  void dfs(String [][] grid, int r, int c,boolean [][]visited) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == "0" || visited[r][c]) {
      return;
    }

    visited[r][c] = true;
    dfs(grid, r - 1, c, visited);
    dfs(grid, r + 1, c, visited);
    dfs(grid, r, c - 1, visited);
    dfs(grid, r, c + 1, visited);
  }

  public int numIslands(String [][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    boolean [][] visited= new boolean[nr][nc];
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == "1" && visited[r][c]==false) {
          dfs(grid, r, c,visited);
          num_islands++;
        }
      }
    }

    return num_islands;
  }
}

// Approach 2- BFS 
class Solution1{
  public int numIslands(String[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == "1") {
          ++num_islands;
          grid[r][c] = "0"; // mark as visited
          Queue<Integer> neighbors = new LinkedList<>();
          neighbors.add(r * nc + c);
          while (!neighbors.isEmpty()) {
            int id = neighbors.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == "1") {
              neighbors.add((row-1) * nc + col);
              grid[row-1][col] = "0";
            }
            if (row + 1 < nr && grid[row+1][col] == "1") {
              neighbors.add((row+1) * nc + col);
              grid[row+1][col] = "0";
            }
            if (col - 1 >= 0 && grid[row][col-1] == "1") {
              neighbors.add(row * nc + col-1);
              grid[row][col-1] = "0";
            }
            if (col + 1 < nc && grid[row][col+1] == "1") {
              neighbors.add(row * nc + col+1);
              grid[row][col+1] = "0";
            }
          }
        }
      }
    }

    return num_islands;
  }
}

class numIslands{
  public static void main(String[] args) {
    String [][] grid={{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},
    {"0","0","0","0","0"}};
    String [][] grid1={{"1","1","0","0","0"},
  {"1","1","0","0","0"},
  {"0","0","1","0","0"},
  {"0","0","0","1","1"}};
    Solution s= new Solution();
    Solution1 s1= new Solution1();
    System.out.println(s.numIslands(grid));
    System.out.println(s1.numIslands(grid1));
  }
}
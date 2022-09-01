import java.util.*;
// Approach 1- BFS [using queue]
class Solution { // TC O(m*n) SC O(m*n)
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;
        
        // Setup each queue with cells adjacent to their respective ocean
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, numCols - 1});
        }
        for (int i = 0; i < numCols; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{numRows - 1, i});
        }
        
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] pacificReachable = bfs(pacificQueue);
        boolean[][] atlanticReachable = bfs(atlanticQueue);
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // This cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) { // Check all 4 directions
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                // Check if new cell is within bounds
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue;
                }
                // Check that the new cell hasn't already been visited
                if (reachable[newRow][newCol]) {
                    continue;
                }
                // Check that the new cell has a higher or equal height,
                // So that water can flow from the new cell to the old cell
                if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
                    continue;
                }
                // If we've gotten this far, that means the new cell is reachable
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return reachable;
    }
}


// Approach 2- DFS (Recursive) [using call-stack]

class Solution1{ // TC O(m*n) SC O(m*n)
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        
        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;
        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];
        
        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }
        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);
        }
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    private void dfs(int row, int col, boolean[][] reachable) {
        // This cell is reachable, so mark it
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) { // Check all 4 directions
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // Check if new cell is within bounds
            if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                continue;
            }
            // Check that the new cell hasn't already been visited
            if (reachable[newRow][newCol]) {
                continue;
            }
            // Check that the new cell has a higher or equal height,
            // So that water can flow from the new cell to the old cell
            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }
            // If we've gotten this far, that means the new cell is reachable
            dfs(newRow, newCol, reachable);
        }
    }
}

class pacificAtlantic{
    public static void main(String[] args) {
        int [][] matrix= {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        Solution s= new Solution();
        System.out.println(s.pacificAtlantic(matrix));
        Solution1 s1= new Solution1();
        System.out.println(s1.pacificAtlantic(matrix));
    }
}
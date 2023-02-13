import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
// Approach 1- BFS
class Solution { // TC O(n^2) SC O(n^2)
    // Four directions: Up, Down, Left and Right.
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        // A copy matrix of the grid to mark water cells as land once visited.
        int[][] visited = new int[grid.length][grid[0].length];

        // Insert all the land cells in the queue.
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Copy grid to the visited matrix.
                visited[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        int distance = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();

            // Iterate over all the current cells in the queue.
            while (qSize-- > 0) {
                Pair landCell = q.poll();

                // From the current land cell, traverse to all the four directions
                // and check if it is a water cell. If yes, convert it to land
                // and add it to the queue.
                for (int[] dir : direction) {
                    int x = landCell.row + dir[0];
                    int y = landCell.col + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && visited[x][y] == 0) {
                        // Marking as 1 to avoid re-iterating it.
                        visited[x][y] = 1;
                        q.offer(new Pair(x, y));
                    }
                }
            }

            // After each iteration of queue elements, increment distance 
            // as we covered 1 unit distance from all cells in every direction.
            distance++;
        }

        // If the distance is 0, there is no water cell.
        return distance == 0 ? -1 : distance;
    }
}

// Approach 2- DP 
class Solution1{ // TC O(n^2) SC O(n^2)
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        // Although it's a square matrix, using different variable for readability.
        int cols = grid[0].length;
        
        // Maximum manhattan distance possible + 1.
        final int MAX_DISTANCE = rows + cols + 1;

        int[][] dist = new int[rows][cols];
        for (int[] arr : dist)
            Arrays.fill(arr, MAX_DISTANCE);

        // First pass: check for left and top neighbours
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Distance of land cells will be 0.
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                } else {
                    // Check left and top cell distances if they exist and update the current cell distance.
                    dist[i][j] = Math.min(dist[i][j], Math.min(i > 0 ? dist[i - 1][j] + 1 : MAX_DISTANCE,
                                                               j > 0 ? dist[i][j - 1] + 1 : MAX_DISTANCE));
                }
            }
        }

        // Second pass: check for the bottom and right neighbours.
        int ans = Integer.MIN_VALUE;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                // Check the right and bottom cell distances if they exist and update the current cell distance.
                dist[i][j] = Math.min(dist[i][j], Math.min(i < rows - 1 ? dist[i + 1][j] + 1 : MAX_DISTANCE,
                                                           j < cols - 1 ? dist[i][j + 1] + 1 : MAX_DISTANCE));
                
                ans = Math.max(ans, dist[i][j]);
            }
        }

        // If ans is 0, it means there is no water cell,
        // If ans is MAX_DISTANCE, it implies no land cell.
        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }
}

// Approach 3- Space Optimized DP 
class Solution2{ // TC O(n^2) SC O(1) // not asked in interview 
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        // Although it's a square matrix, using different variable for readability.
        int cols = grid[0].length;
        
        // Maximum manhattan distance possible + 1.
        final int MAX_DISTANCE = rows + cols + 1;

        // First pass: check for left and top neighbours
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Distance of land cells will be 0.
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = MAX_DISTANCE;
                    // Check left and top cell distances if they exist and update the current cell distance.
                    grid[i][j] = Math.min(grid[i][j], Math.min(i > 0 ? grid[i - 1][j] + 1 : MAX_DISTANCE,
                                                               j > 0 ? grid[i][j - 1] + 1 : MAX_DISTANCE));
                }
            }
        }

        // Second pass: check for the bottom and right neighbours.
        int ans = Integer.MIN_VALUE;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                // Check the right and bottom cell distances if they exist and update the current cell distance.
                grid[i][j] = Math.min(grid[i][j], Math.min(i < rows - 1 ? grid[i + 1][j] + 1 : MAX_DISTANCE,
                                                           j < cols - 1 ? grid[i][j + 1] + 1 : MAX_DISTANCE));
                
                ans = Math.max(ans, grid[i][j]);
            }
        }

        // If ans is 1, it means there is no water cell,
        // If ans is MAX_DISTANCE, it implies no land cell.
        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }
};

class maxDistanceOfWaterCell{
    public static void main(String[] args) {
        int[][] grid={{1,0,1},{0,0,0},{1,0,1}};
        Solution s= new Solution();
        System.out.println(s.maxDistance(grid));
    }
}
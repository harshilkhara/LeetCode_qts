import java.util.*;
// Obviously similar to spiralOrder.java & .py
// Approach 1- Simulating the spiral order
class Solution { // TC O(n.m) SC O(1)
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int col_start = 0, col_end = n - 1;
        int row_start = 0, row_end = n - 1;
        int element = 1;
        while(col_start <= col_end && row_start <= row_end) {
            //top
            for(int j = col_start; j <= col_end; j++) {
                matrix[row_start][j] = element++;
            }
            
            // right side
            for(int i = row_start + 1; i <= row_end; i++) {
                matrix[i][col_end] = element++;
            }
            
            //bottom side
            for(int j = col_end - 1; j >= col_start; j--) {
                matrix[row_end][j] = element++;
            }
            
            //left side
            for(int i = row_end - 1; i > row_start; i--) {
                matrix[i][col_start] = element++;
            }
            
            col_start++;
            col_end--;
            row_start++;
            row_end--;
        }
        return matrix;
    }
}

// Approach 2- Traverse layer by layer in spiral form
class Solution1{ // TC O(n.m) SC O(1)
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }
        return result;
    }
}


class spiralOrderII{
    public static void main(String[] args) {
        int n=3;
        Solution s=new Solution();
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
    }
}
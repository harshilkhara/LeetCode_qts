import java.util.*;
// Approach 1- Brute Force using DFS (Recursive)
// Note- It times out!
class Solution{ // TC O(N.3^N) SC O(n)
    public int minFallingPathSum(int[][] matrix) {

        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, findMinFallingPathSum(matrix, 0, startCol));
        }
        return minFallingSum;
    }

    public int findMinFallingPathSum(int[][] matrix, int row, int col) {
        // check if we are out of the left or right boundary of the matrix
        if (col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        //check if we have reached the last row
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }

        // calculate the minimum falling path sum starting from each possible next step
        int left = findMinFallingPathSum(matrix, row + 1, col);
        int middle = findMinFallingPathSum(matrix, row + 1, col + 1);
        int right = findMinFallingPathSum(matrix, row + 1, col - 1);

        return Math.min(left, Math.min(middle, right)) + matrix[row][col];
    }
}

// Approach 2- Top Down DP with memoization
class Solution1{ // TC O(N^2) SC O(N^2)
    public int minFallingPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        Integer memo[][] = new Integer[matrix.length][matrix[0].length];

        // start a DFS (with memoization) from each cell in the top row
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum,
                findMinFallingPathSum(matrix, 0, startCol, memo));
        }
        return minFallingSum;
    }

    public int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
        //base cases
        if (col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        //check if we have reached the last row
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        //check if the results are calculated before
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // calculate the minimum falling path sum starting from each possible next step
        int left = findMinFallingPathSum(matrix, row + 1, col, memo);
        int middle = findMinFallingPathSum(matrix, row + 1, col + 1, memo);
        int right = findMinFallingPathSum(matrix, row + 1, col - 1, memo);

        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];
        return memo[row][col];
    }
}

// Approach 3- Bottom Up DP with tabulation
class Solution2{ // TC O(N^2) SC O(N^2)
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    dp[row][col] =
                        Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    dp[row][col] =
                        Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row + 1][col],
                        Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1])) + matrix[row][col];
                }
            }
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
        }
        return minFallingSum;
    }
}

// Approach 4- Bottom Up DP with space optimized
class Solution3{ // TC O(N^2) SC O(N)
    public int minFallingPathSum(int[][] matrix) {
        int dp[] = new int[matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            int currentRow[] = new int[matrix.length + 1];
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col - 1]) + matrix[row][col];
                } else {
                    currentRow[col] = Math.min(dp[col],
                        Math.min(dp[col + 1], dp[col - 1])) + matrix[row][col];
                }
            }
            dp = currentRow;
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[startCol]);
        }
        return minFallingSum;
    }
}

class minFallingPathSum{
    public static void main(String[] args) {
        int[][] matrix= {{2,1,3},{6,5,4},{7,8,9}};
        Solution s= new Solution();
        System.out.println(s.minFallingPathSum(matrix));
        Solution1 s1= new Solution1();
        System.out.println(s1.minFallingPathSum(matrix));
        Solution2 s2= new Solution2();
        System.out.println(s2.minFallingPathSum(matrix));
        Solution3 s3= new Solution3();
        System.out.println(s3.minFallingPathSum(matrix));
    }
}
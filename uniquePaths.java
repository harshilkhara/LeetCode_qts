// Approach 1- DP (Bottom- Up) 
import java.util.*;
class Solution{ // TC O(M*N) SC O(M*N)
  public int uniquePaths(int m, int n) {
    int[][] d = new int[m][n];

    for(int[] arr : d) {
      Arrays.fill(arr, 1);
    }
    for(int col = 1; col < m; ++col) {
      for(int row = 1; row < n; ++row) {
        d[col][row] = d[col - 1][row] + d[col][row - 1];
      }
    }
    return d[m - 1][n - 1];
  }
}

class uniquePaths{
  public static void main(String[] args) {
    int m=3;
    int n=7; 
    Solution s= new Solution();
    System.out.println(s.uniquePaths(m,n));
  }
}
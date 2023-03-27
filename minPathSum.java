// Approach 1- DP (From bottom right to top left)
class Solution{ // TC O(m*n) SC O(n)
	public int minPathSum(int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int[] dp=new int[m];
		for(int row=n-1; row>=0; row--){
			for(int col=m-1; col>=0; col--){
				if(row==n-1 && col!=m-1){
					dp[col]=grid[row][col]+dp[col+1];
				} else if (col==m-1 && row!=n-1){
					dp[col]=grid[row][col]+dp[col];
				} else if (row!=n-1 && col!=m-1){
					dp[col]=grid[row][col]+ Math.min(dp[col], dp[col+1]);
				} else {
					dp[col]=grid[row][col];
				}
			}
		}
		return dp[0];
	}
}

// Approach 2- DP (From top left to bottom right)
class Solution{ // TC O(m*n) SC O(n)
	public int minPathSum(int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int[] dp=new int[m];
		for(int row=0; row<n; row++){
			for(int col=0; col<m; col++){
				if(row==0 && col!=0){
					dp[col]=grid[row][col]+dp[col-1];
				} else if (col==0 && row!=0){
					dp[col]=grid[row][col]+dp[col];
				} else if (row!=0 && col!=0){
					dp[col]=grid[row][col]+ Math.min(dp[col], dp[col-1]);
				} else {
					dp[col]=grid[row][col];
				}
			}
		}
		return dp[m-1];
	}
}

class minPathSum{
	public static void main(String[] args) {
		int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
		Solution s= new Solution();
		System.out.println(s.minPathSum(grid));
	}
}
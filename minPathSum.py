class Solution:
# Approach 1- DP (From bottom right to top left)
    def minPathSum(self, grid): # TC O(m*n) // SC O(n)
        n=len(grid)
        m=len(grid[0])
        dp=[0]*(m)
        for row in range(n-1,-1,-1):
            for col in range(m-1, -1, -1):
                if row==n-1 and col!=m-1:
                    dp[col]=grid[row][col]+dp[col+1]
                elif col==m-1 and row!=n-1:
                    dp[col]=grid[row][col]+dp[col]
                elif col!=m-1 and row!=n-1:
                    dp[col]=grid[row][col]+min(dp[col], dp[col+1])
                else:
                    dp[col]=grid[row][col]
        
        return dp[0]

s=Solution()
print(s.minPathSum([[1,3,1],[1,5,1],[4,2,1]]))
class Solution:
# Approach 1- Iterating over diagonal elements
    def diagonalSum(self, mat): # TC O(n) // SC O(1)
        ans=0
        n=len(mat)
        for i in range(n):
            ans+=mat[i][i]
            ans+=mat[n-1-i][i]
        
        if n%2!=0:
            ans-=mat[n//2][n//2]
        
        return ans

s=Solution()
print(s.diagonalSum([[1,2,3], [4,5,6], [7,8,9]]))
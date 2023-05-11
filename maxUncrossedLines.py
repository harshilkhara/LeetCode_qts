class Solution:
# Approach 3- Optimized Bottom-up DP 
    def maxUncrossedLines(self, nums1, nums2): # TC O(n.m) // SC O(n)
        n1=len(nums1)
        n2=len(nums2)
        dpPrev=[0]*(n2+1)
        dp=[0]*(n2+1)
        for i in range(1, n1+1):
            for j in range(1, n2+1):
                if nums1[i-1]==nums2[j-1]:
                    dp[j]=1+dpPrev[j-1]
                else:
                    dp[j]=max(dp[j-1], dpPrev[j])
            dpPrev=dp[:]
        
        return dp[n2]

s=Solution()
print(s.maxUncrossedLines([1,2,4], [1,4,2]))
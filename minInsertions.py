class Solution:
# Very similar to longestPalindromeSubsequence
    def minInsertions(self, s): # TC O(n^2) // SC O(n)
        
        def lps(s):
            n=len(s)
            dp=[0]*n
            dpPrev=[0]*n
            for i in range(n-1, -1, -1):
                dp[i]=1
                for j in range(i+1,n):
                    if s[i]==s[j]:
                        dp[j]=2+dpPrev[j-1]
                    else:
                        dp[j]=max(dpPrev[j], dp[j-1])
                
                dpPrev=dp[:]
            
            return dp[n-1]
        
        
        x=lps(s)
        answer=len(s)-x
        
        return answer

s=Solution()
print(s.minInsertions("mbadm"))
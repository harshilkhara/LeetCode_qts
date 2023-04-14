class Solution:
# Approach 1- Recursive (Top-down DP)
    def longestPalindromeSubseq(self, s): # TC O(n^2) // SC O(n^2)
        n = len(s)
        
        memo = {}
        def lps(l, r):
            if (l,r) in memo:
                return memo[(l,r)]
            if l > r:
                return 0
            if l == r:
                return 1

            if s[l] == s[r]:
                memo[(l,r)] = lps(l + 1, r - 1) + 2
            else:
                memo[(l,r)] = max(lps(l, r - 1), lps(l + 1, r))
            return memo[(l, r)]

        return lps(0, n - 1)

# Approach 2- Bottom-up DP
    def longestPalindromeSubseq1(self, s): # TC O(n^2) // SC O(n^2)
        n = len(s)
        dp = [[0] * n for _ in range(n)]

        for i in range(n - 1, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, n):
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])

        return dp[0][n - 1]

# Approach 3- Bottom-up DP (Space Optimized)
    def longestPalindromeSubseq2(self, s): # TC O(n^2) // SC O(n)
        n = len(s)
        dp, dpPrev = [0] * n, [0] * n

        for i in range(n - 1, -1, -1):
            dp[i] = 1
            for j in range(i + 1, n):
                if s[i] == s[j]:
                    dp[j] = dpPrev[j - 1] + 2
                else:
                    dp[j] = max(dpPrev[j], dp[j - 1])
            dpPrev = dp[:]

        return dp[n - 1]

s=Solution()
print(s.longestPalindromeSubseq("bbbab"))
print(s.longestPalindromeSubseq1("bbbab"))
print(s.longestPalindromeSubseq2("bbbab"))

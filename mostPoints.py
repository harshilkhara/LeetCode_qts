class Solution:
# Approach 1- Bottom up DP
	def mostPoints(self, questions): # TC O(n) // SC O(n)
		n=len(questions)
		dp=[0]*n
		dp[-1]=questions[-1][0]
		for i in range(n-2, -1, -1):
			dp[i], skip=questions[i]
			if i+skip+1<n:
				dp[i]+=dp[i+skip+1]

			# dp[i] = max(skip it, solve it)
			dp[i]=max(dp[i], dp[i+1])

		return dp[0]

# Approach 2- Top Down DP
	def mostPoints(self, questions): # TC O(n) // SC O(n)
		 n = len(questions)
        dp = [0] * n
        
        def dfs(i):
            if i >= n:
                return 0
            if dp[i]:
                return dp[i]
            points, skip = questions[i]

            # dp[i] = max(skip it, solve it)
            dp[i] = max(dfs(i + 1), points + dfs(i + skip + 1))
            return dp[i]
        
        return dfs(0)



s=Solution()
print(s.mostPoints([[3,2],[4,3],[4,4],[2,5]]))
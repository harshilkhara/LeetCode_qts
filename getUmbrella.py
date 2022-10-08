# Similar to coin change 
# Approach 1- DP (Bottom-Up)
def getUmbrella(requirements,sizes):
	dp=[requirements+1]*(requirements+1)
	dp[0]=0

	for size in sizes:
		for i in range(size,requirements+1):
			dp[i]=min(dp[i],dp[i-size]+1)

	return dp[requirements] if dp[requirements]!=requirements+1 else -1

print(getUmbrella(6,[3,5]))
from functools import lru_cache
def winnerSquareGame(n):        # TC O(n sqrt(n)) // SC O(n)
	@lru_cache(maxsize=None)
	def dfs(remain):   # TC O(n)
	    if remain == 0:
	        return False
	    sqrt_root = int(remain**0.5)
	    for i in range(sqrt_root,0,-1):       # TC O(sqrt (n))
	        # if there is any chance to make the opponent lose the game in the next round,
	        #  then the current player will win.
	        if not dfs(remain - i*i):
	            return True
	    return False
	return dfs(n)                  

def winnerSquareGame1(n):      # TC O(n sqrt(n)) // SC O(n)
	dp = [False]*(n+1)
	for i in range(1, n+1):
	    for k in range(1, int(i**0.5)+1):
	        if dp[i-k*k] == False:
	            dp[i] = True
	            break
	return dp[n]

def winnerSquareGame2(n):      # TC O(n sqrt(n)) // SC O(n)
	dp=[False]*(n+1)
	for i in range(n+1):
		if dp[i]==True:
			continue
		for k in range(1, int(n**0.5)+1):
			if i+k*k<=n:
				dp[i+k*k]=True
			else:
				break
	return dp[n]

print(winnerSquareGame(2))
print(winnerSquareGame1(6))
print(winnerSquareGame2(4))
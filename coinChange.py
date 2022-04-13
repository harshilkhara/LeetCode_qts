def coinChange(coins,amount): # TC O(amount*len(coins)) // SC O(amount)
	dp=[amount+1]*(amount+1)
	dp[0]=0

	for a in range(1,amount+1):
	    for c in coins:
	        if a-c>=0:
	            dp[a]=min(dp[a],1+dp[a-c])
	return dp[amount] if dp[amount]!=amount+1 else -1

# Leetcode solution with flipped for loop and no if condition 
def coinChange1(coins,amount):
	dp = [float('inf')] * (amount + 1)
	dp[0] = 0

	for coin in coins:
	    for x in range(coin, amount + 1):
	        dp[x] = min(dp[x], dp[x - coin] + 1)
	return dp[amount] if dp[amount] != float('inf') else -1 

print(coinChange([1,2,5],11))
print(coinChange1([1,3,4,5],7))
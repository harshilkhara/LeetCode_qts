def coinChangeII(coins,amount): # TC O(amount*len(coins)) // SC O(amount)
	dp = [0] * (amount + 1)
	dp[0] = 1

	for coin in coins:
	    for x in range(coin, amount + 1):
	        dp[x] += dp[x - coin]
	return dp[amount]

print(coinChangeII([1,2,5],5))

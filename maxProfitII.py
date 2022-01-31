def maxProfitII(prices): # TC O(n) // SC O(1)
	maxP=0
	for i in range(len(prices)):
		if prices[i]>prices[i-1]:
			maxP+=prices[i]-prices[i-1]
	return maxP

print(maxProfitII([1, 7, 2, 3, 6, 7, 6, 7]))
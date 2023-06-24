class Solution:
# Approach 1- DP (Bottom-Up)
    def maxProfit(self, prices, fee): # TC O(n) // SC O(n)
        n = len(prices)
        hold, free = [0] * n, [0] * n
        
        # In order to hold a stock on day 0, we have no other choice but to buy it for prices[0].
        hold[0] = -prices[0]
        
        for i in range(1, n):
            hold[i] = max(hold[i - 1], free[i - 1] - prices[i])
            free[i] = max(free[i - 1], hold[i - 1] + prices[i] - fee)
        
        return free[-1]

# Approach 2- Space Optimized DP
    def maxProfit1(self, prices, fee): # TC O(n) // SC O(1)
        n = len(prices)
        hold, free = -prices[0], 0
        
        for i in range(1, n):
            tmp = hold
            hold = max(hold, free - prices[i])
            free = max(free, tmp + prices[i] - fee)
        
        return free

s=Solution()
print(s.maxProfit([1,3,2,8,4,9], 2))
print(s.maxProfit1([1,3,2,8,4,9], 2))

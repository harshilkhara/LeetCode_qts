// Approach 1- DP (Bottom-Up)
class Solution{ // TC O(n) SC O(n)
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n], hold = new int[n];
        
        // In order to hold a stock on day 0, we have no other choice but to buy it for prices[0].
        hold[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }
        
        return free[n - 1];
    }
}

// Approach 2- Space Optimized DP
class Solution1{ // TC O(n) SC O(1)
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int free = 0, hold = -prices[0];
        
        for (int i = 1; i < n; i++) {
            int tmp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, tmp + prices[i] - fee);
        }
        
        return free;
    }
}

class maxProfitIII{
    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int fee=2;
        Solution s= new Solution();
        System.out.println(s.maxProfit(prices, fee));
        Solution1 s1=new Solution1();
        System.out.println(s1.maxProfit(prices, fee));
    }
}
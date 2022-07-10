import java.util.*;

// Approach 1- Bottom Up DP 
class Solution{     // TC O(N) SC O(N)
    public int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int minimumCost[] = new int[cost.length + 1];
        
        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }
}

// Approach 2- Top Down DP  (Recursion + memoization)

class Solution1{
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    private int minimumCost(int i, int[] cost) {
        // Base case, we are allowed to start at either step 0 or step 1
        if (i <= 1) {
            return 0;
        }

        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // If not, cache the result in our hash map and return it
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }
}

// Approach 3- Bottom Up DP (Space Optimized)

class Solution2{ // TC O(N) SC O(1)
    public int minCostClimbingStairs(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }
        
        return downOne;
    }
}

class minCostClimbingStairs{
    public static void main(String[] args) {
        int [] cost={1,4,10,15,20}; 
        Solution s= new Solution();
        System.out.println(s.minCostClimbingStairs(cost));
        Solution1 s1= new Solution1();
        System.out.println(s1.minCostClimbingStairs(cost));
        Solution2 s2= new Solution2();
        System.out.println(s2.minCostClimbingStairs(cost));

    }
}
import java.util.*;
// Approach 1- Bottom-up DP 
class Solution { // TC O(n) SC O(n)
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        
        for (int i = n - 2; i >= 0; --i) {
            dp[i] = questions[i][0];
            int skip = questions[i][1];
            if (i + skip + 1 < n) {
                dp[i] += dp[i + skip + 1];
            }
            
            // dp[i] = max(solve it, skip it)
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        
        return dp[0];
    }
}

// Approach 2- Top Down DP
class Solution1{ // TC O(n) SC O(n)
    long dp[];
    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long points = questions[i][0];
        int skip = questions[i][1];

        // dp[i] = max(solve it, skip it)
        dp[i] = Math.max(points + dfs(questions, i + skip + 1), dfs(questions, i + 1));
        return dp[i];
    }
    
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        
        return dfs(questions, 0);
    }
}

class mostPoints{
    public static void main(String[] args) {
        int[][] questions={{3,2},{4,3},{4,4},{2,5}};
        Solution s= new Solution();
        System.out.println(s.mostPoints(questions));
        Solution1 s1= new Solution1();
        System.out.println(s1.mostPoints(questions));
    }
}
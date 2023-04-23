import java.util.*;
// Approach 1- Top-down DP (Recursive)
class Solution { // TC O(m log k) SC O(m)
    int mod = 1_000_000_007;

    // Number of possible splits for substring s[start ~ m-1].
    private int dfs(int[] dp, int start, String s, int k) {
        // If we have already updated dp[start], return it.
        if (dp[start] != 0)
            return dp[start];

        // There is only 1 split for an empty string.
        if (start == s.length())
            return 1;

        // Number can't have leading zeros.
        if (s.charAt(start) == '0')
            return 0;

        // For all possible starting number, add the number of arrays 
        // that can be printed as the remaining string to count.
        int count = 0;
        for (int end = start; end < s.length(); ++end) {
            String currNumber = s.substring(start, end + 1);
            if (Long.parseLong(currNumber) > k)
                break;
            count = (count + dfs(dp, end + 1, s, k)) % mod;
        }

        // Update dp[start] so we don't recalculate it later.
        dp[start] = count;
        return count;
    }
    
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return dfs(dp, 0, s, k);
    }
}

// Approach 2- Bottom-Up DP
class Solution1{ // TC O(m log k) SC O(m)
    public int numberOfArrays(String s, int k) {
        int m = s.length(), n = String.valueOf(k).length();
        int mod = 1_000_000_007;
        
        // dp[i] records the number of arrays that can be printed as
        // the prefix substring s[0 ~ i - 1]
        int[] dp = new int[m + 1];
        
        // Empty string has 1 valid split.
        dp[0] = 1;
        
        // Iterate over every digit, for each digit s[start]
        for (int start = 0; start < m; ++start) {
            if (s.charAt(start) == '0')
                continue;
            
            // Iterate over ending digit end and find all valid numbers 
            // s[start ~ end].
            for (int end = start; end < m; ++end) {
                String currNumber = s.substring(start, end + 1);
                
                if (Long.parseLong(currNumber) > k)
                    break;
                
                // If s[start ~ end] is valid, increment dp[end + 1] by dp[start].
                dp[end + 1] = (dp[end + 1] + dp[start]) % mod;
            }
        }
        return dp[m];
    }
}

// Approach 3- Bottom-Up DP (Space Optimized)
class Solution2{ // TC O(m log k) SC O(log k)
    public int numberOfArrays(String s, int k) {
        int m = s.length(), n = String.valueOf(k).length();
        int mod = 1_000_000_007;
        
        // dp[i % (n + 1)] stands for the number of splits for substring s[0 ~ i - 1]
        int[] dp = new int[n + 1];
        
        // Empty string has 1 valid split.
        dp[0] = 1;
        
        // Iterate over every digit, for each digit s[start]
        for (int start = 0; start < m; ++start) {
            if (s.charAt(start) == '0') {
                dp[start % (n + 1)] = 0;
                continue;
            }
            
            // We travers forward to find all valid numbers s[start ~ end].
            for (int end = start; end < m; ++end) {
                String currNumber = s.substring(start, end + 1);
                
                if (Long.parseLong(currNumber) > k)
                    break;
                
                // If s[start ~ end] is valid, increment dp[(end + 1) % (n + 1)] by dp[start].
                dp[(end + 1) % (n + 1)] = (dp[(end + 1) % (n + 1)] + dp[start % (n + 1)]) % mod;
            }

            // Set dp[start % (n + 1)] as 0.
            dp[start % (n + 1)] = 0;
        }
        return dp[m % (n + 1)];
    }
}

class numberOfArrays{
    public static void main(String[] args) {
        String x="1317";
        int k=2000;
        Solution s= new Solution();
        System.out.println(s.numberOfArrays(x,k));
        Solution1 s1= new Solution1();
        System.out.println(s1.numberOfArrays(x,k));
        Solution2 s2= new Solution2();
        System.out.println(s2.numberOfArrays(x,k));
    }
}
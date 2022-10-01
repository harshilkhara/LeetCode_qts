import java.util.*;
// Approach 1- Top down DP (Recursive with memoization)
class Solution { // TC O(n) SC O(n)
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }
    
    private int recursiveWithMemo(int index, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }


        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
             ans += recursiveWithMemo(index + 2, str);
         }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }
}

// Approach 2- Bottom Up (Iterative)
class Solution1{ // TC O(n) SC O(n)
     public int numDecodings(String s) {
        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
               dp[i] = dp[i - 1];  
            }
            
            // Check if successful two digit decode is possible.
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

// Approach 3- Bottom up but constant space(Iterative)
class Solution2{ // TC O(n) SC O(1)
    public int numDecodings(String s) {  
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < n; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current = oneBack;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
           
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}
class numDecodings{
    public static void main(String[] args) {
        String x = "226";
        Solution s =new Solution();
        System.out.println(s.numDecodings(x));
        Solution1 s1 =new Solution1();
        System.out.println(s1.numDecodings(x));
        Solution2 s2 =new Solution2();
        System.out.println(s2.numDecodings(x));
        
    }
}
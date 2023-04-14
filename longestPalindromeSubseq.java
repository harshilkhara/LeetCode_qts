import java.util.*;
// Approach 1- Recursive (Top-down DP)
class Solution { // TC O(n^2) SC O(n^2)
    String s;
    int[][] memo;
    
    public int lps(int i, int j){
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        
        if(i>j) return 0;
        if(i==j) return 1;
        
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j]=2 + lps(i+1, j-1);
        } else {
            memo[i][j]=Math.max(lps(i+1, j), lps(i, j-1));
        }
        
        return memo[i][j];
    }
    
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        this.s=s;
        this.memo=new int[n][n];
        return lps(0,n-1);
    }
}

// Approach 2- Bottom-up DP
class Solution1{ // TC O(n^2) SC O(n^2)
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        
        for(int i=n-1; i>=0; i--){
            dp[i][i]=1;
            for(int j=i+1; j<n; j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2 + dp[i+1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

// Approach 3- Bottom-up DP (Space Optimized)
class Solution2{ // TC O(n^2) SC O(n)
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            dp[i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = dpPrev[j - 1] + 2;
                } else {
                    dp[j] = Math.max(dpPrev[j], dp[j - 1]);
                }
            }
            dpPrev = dp.clone();
        }

        return dp[n - 1];
    }
}

class longestPalindromeSubseq{
    public static void main(String[] args) {
        String x="bbbab";
        Solution s=new Solution();
        System.out.println(s.longestPalindromeSubseq(x));
        Solution1 s1=new Solution1();
        System.out.println(s1.longestPalindromeSubseq(x));
        Solution2 s2=new Solution2();
        System.out.println(s2.longestPalindromeSubseq(x));
    }
}
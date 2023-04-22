import java.util.*;
// Very similar to longestPalindromeSubsequence
class Solution { // TC O(n^2) SC O(n^2)
    public int lps(String s) {
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
    
    public int minInsertions(String s) {
        int x=lps(s);
        int answer=s.length()-x;
        return answer;
    }
    
}

class minInsertions{
    public static void main(String[] args) {
        String x="mbadm";
        Solution s= new Solution();
        System.out.println(s.minInsertions(x));
    }
}
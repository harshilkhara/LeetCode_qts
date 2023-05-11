import java.util.*;
// Very similar to longestPalindromeSubsequence.java & .py
// Approach 1- Bottom-up DP
class Solution { // TC O(n.m) SC O(n.m)
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] dp=new int[n1+1][n2+1];
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}

// Approach 2- Top-down DP 
class Solution1{ // TC O(n.m) SC O(n.m)
    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] memo){
        if (i<=0 || j<=0) return 0;
        
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        if(nums1[i-1]==nums2[j-1]){
            memo[i][j]=1+solve(i-1, j-1, nums1, nums2, memo);
        } else {
            memo[i][j]=Math.max(solve(i, j-1, nums1, nums2, memo), solve(i-1, j, nums1, nums2, memo));
        }
        return memo[i][j];
        
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] memo=new int[n1+1][n2+1];
        
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return solve(n1, n2, nums1, nums2, memo);
        
    }
}

// Approach 3- Optimized Bottom-up DP 
class Solution2{ // TC O(n.m) SC O(n)
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] dp=new int[n2+1];
        int[] dpPrev=new int[n2+1];
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[j]=1+dpPrev[j-1];
                } else {
                    dp[j]=Math.max(dp[j-1], dpPrev[j]);
                }
                dpPrev=dp.clone();
            }
        }
        return dp[n2];
    }
}

class maxUncrossedLines{
    public static void main(String[] args) {
        int[] nums1={1,4,2};
        int[] nums2={1,2,4};
        Solution s= new Solution();
        System.out.println(s.maxUncrossedLines(nums1, nums2));
        Solution1 s1= new Solution1();
        System.out.println(s1.maxUncrossedLines(nums1, nums2));
        Solution2 s2= new Solution2();
        System.out.println(s2.maxUncrossedLines(nums1, nums2));
    }
}
class Solution { // TC O(1) SC O(1)
    public int tribonacci(int n) {
        int[] dp=new int[38];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3; i<=n; i++){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}

class tribonacci{
    public static void main(String[] args) {
        int n=5;
        Solution s= new Solution();
        System.out.println(s.tribonacci(n));
    }
}
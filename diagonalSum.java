// Approach 1- Iterating over diagonal elements
class Solution { // TC O(n) SC O(1)
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        for (int i=0; i<n; i++){
            sum+=mat[i][i];
            sum+=mat[n-1-i][i];
        }
        
        if(n%2!=0) sum-=mat[n/2][n/2];
        
        return sum;
    }
}

class diagonalSum{
    public static void main(String[] args) {
        int[][] mat={};
        Solution s= new Solution();
        System.out.println(s.diagonalSum(mat));
    }
}
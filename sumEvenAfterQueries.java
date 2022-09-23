import java.util.*;
class Solution { // TC O(N+Q) SC O(Q)
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }
        return ans;
    }
}

class sumEvenAfterQueries{
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[][] queries={{1,0},{-3,1},{-4,0},{2,3}};
        Solution s= new Solution();
        int[] ans= s.sumEvenAfterQueries(nums,queries);
        System.out.println(Arrays.toString(ans));
    }
}
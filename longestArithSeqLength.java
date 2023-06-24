import java.util.*;
// Approach 1- DP (Bottom-Up)
class Solution { // TC O(n^2) SC O(n^2)
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int maxLength=0;
        HashMap<Integer, Integer> [] dp =new HashMap[n];
        for(int right=0; right<n; right++){
            dp[right]=new HashMap<>();
            for(int left=0;  left<right; left++){
                int diff=nums[left]-nums[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1)+1);
                maxLength=Math.max(maxLength, dp[right].get(diff));
            }        
        }
     
        return maxLength;
    }
}

class longestArithSeqLength{
    public static void main(String[] args) {
        int[] nums={3,6,9,12};
        Solution s= new Solution();
        System.out.println(s.longestArithSeqLength(nums));
    }
}
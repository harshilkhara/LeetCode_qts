import java.util.*;
// Approach 1- Sliding window
class Solution { // TC O(n) SC O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];
            
            while(sum>=target){
                ans=Math.min(ans, right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE ? 0: ans;
    }
}

class minSubArrayLen{
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        Solution s= new Solution();
        System.out.println(s.minSubArrayLen(target, nums));

    }
}
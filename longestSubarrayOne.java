import java.util.*;
// Approach 1- Sliding window
class Solution { // TC O(n) SC O(1)
    public int longestSubarray(int[] nums) {
        int left=0, right=0;
        int ans=0, zeroCount=0;
        while (right<nums.length){
            zeroCount+=(nums[right]==0) ? 1:0;
            
            while(zeroCount>1){
                zeroCount-= nums[left]==0 ? 1:0;
                left++;
            }
            ans=Math.max(ans, right-left);
            right++;
        }
        return ans;
    }
}

class longestSubarrayOne{
    public static void main(String[] args) {
        int[] nums={1,1,0,1};
        Solution s= new Solution();
        System.out.println(s.longestSubarray(nums));
    }
}
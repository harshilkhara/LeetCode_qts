import java.util.*;
// Approach 1- Bottom-Up DP 
// The very base DP problem
class Solution { // TC O(n) SC O(n)
    public int[] runningSum(int[] nums) {
        int[] ans=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            ans[i]=nums[i]+ans[i-1];
        }
        return ans;
    }
}

class runningSum{
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.runningSum(nums)));
    }
}
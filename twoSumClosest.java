import java.util.*;
class Solution { // TC O( n log n) SC O(log n)
    public static int[] twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int lo = 0, hi = nums.length - 1; lo < hi; ) {
            int sum = nums[lo] + nums[hi];
            int diff = Math.abs(target - sum);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = nums[lo];
                result[1] = nums[hi];
            }
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                break;
            }
        }
        return result;
    }
}

class twoSumClosest{
    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5}; 
        int target=10; 
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.twoSumClosest(nums,target)));
    }
}

// Approach 1- DP        TC O(N) // SC O(1)
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}

// Approach 2- Greedy Method  TC O(N) // SC O(1)
class Solution1{
    public int wiggleMaxLength(int [] nums){
        if(nums.length<2)
            return nums.length;
        int prevdiff= nums[1]-nums[0];
        int count= prevdiff!=0 ? 2:1;
        for (int i =2; i<nums.length; i++){
            int diff=nums[i]-nums[i-1];
            if(diff > 0 && prevdiff<=0 || diff < 0 && prevdiff>=0){
                count++;
                prevdiff=diff;
            }
        }
        return count;
    }
}


 class wiggleMaxLength{
    public static void main(String[] args) {
        int [] nums = {1,7,4,9,2,5};
        Solution s= new Solution(); 
        System.out.println(s.wiggleMaxLength(nums)); 
        Solution1 s1= new Solution1(); 
        System.out.println(s1.wiggleMaxLength(nums)); 
    }
 }
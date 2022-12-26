import java.util.*;
// Approach 1- Backtracking 
class Solution{ // TC O(2^n) SC O(n)
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}
// Approach 2- Top Down DP 
// Just like above backtracking. Only this time we memoize the calculation
enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution1{ // TC O(n^2) SC O(n)
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}

// Approach 3- Bottom Up DP 
class Solution2{ // TC O(n^2) SC O(n)
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}

// Approach 4- Greedy Method
class Solution3{ // TC O(n) SC O(1)
    public boolean canJump(int[] nums){
        int lastPosition=nums.length-1;
        for(int i=lastPosition; i>=0; i--){
            if(i+nums[i]==lastPosition){
                lastPosition=i;
            }
        }
        return lastPosition==0;
    }
}

class canJump{
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        Solution s= new Solution();
        System.out.println(s.canJump(nums));
        Solution1 s1= new Solution1();
        System.out.println(s1.canJump(nums));
        Solution2 s2= new Solution2();
        System.out.println(s2.canJump(nums));
        Solution3 s3= new Solution3();
        System.out.println(s3.canJump(nums));
    }
}
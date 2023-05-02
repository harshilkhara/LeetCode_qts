import java.util.*;
// Approach 1- Counting the negative numbers
class Solution { // TC O(n) SC O(1)
    public int arraySign(int[] nums) {
        int negativeNumber=0;
        for(int num: nums){
            if(num<0){
                negativeNumber++;
            } else if (num==0){
                return 0;
            }
        }
        
        return (negativeNumber%2==0) ? 1:-1;
    }
}

// Approach 2- Flipping the sign
class Solution1{ // TC O(n) SC O(1)
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -1 * sign;
            }
        }

        return sign;
    }
}

class arraySign {
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,3,2,1};
        Solution s=new Solution();
        System.out.println(s.arraySign(nums));
        Solution1 s1=new Solution1();
        System.out.println(s1.arraySign(nums));
    }

}
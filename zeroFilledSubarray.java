import java.util.*;
// Approach 1- Count the no. of consecutive 0's at each index
class Solution { // TC O(n) SC O(1)
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        long zeroSubarray=0;
        for(int num: nums){
            if (num==0){
                zeroSubarray++;
            } else {
                zeroSubarray=0;
            }
            ans+=zeroSubarray;
        }
        return ans;
    }
}

class zeroFilledSubarray{
    public static void main(String[] args) {
        int[] nums={1,3,0,0,2,0,0,4};
        Solution s= new Solution();
        System.out.println(s.zeroFilledSubarray(nums));
    }
}
import java.util.*;
// Approach 1- Prefix sum and counting the remainders
class Solution { // TC O(n) SC O(n)
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }
}

class subarrayDivByK{
    public static void main(String[] args) {
        int[] nums={1,11,12,23,5};
        int k=2;
        Solution s= new Solution();
        System.out.println(s.subarraysDivByK(nums,k));
    }
}
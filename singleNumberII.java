import java.util.*;
// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}

// Approach 2- Bit manipulation 
class Solution1{ // TC O(n) SC O(1)
    public int singleNumber(int[] nums) {

        // Loner
        int loner = 0;

        // Iterate over all bits
        for (int shift = 0; shift < 32; shift++) {
            int bitSum = 0;

            // For this bit, iterate over all integers
            for (int num : nums) {

                // Compute the bit of num, and add it to bitSum
                bitSum += (num >> shift) & 1;
            }

            // Compute the bit of loner and place it
            int lonerBit = bitSum % 3;
            loner = loner | (lonerBit << shift);
        }
        return loner;
    }
}

class singleNumberII{
    public static void main(String[] args) {
        int[] nums={2,2,3,2};
        Solution s =new Solution();
        System.out.println(s.singleNumber(nums));
        Solution1 s1 =new Solution1();
        System.out.println(s1.singleNumber(nums));
    }
}
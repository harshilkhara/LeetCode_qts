import java.util.*;
// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int ans=0;
        for(int num: nums){
            ans+=map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return ans;
    }
}

class numIdenticalPairs{
    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,3};
        Solution s=new Solution();
        System.out.println(s.numIdenticalPairs(nums));
    }
}
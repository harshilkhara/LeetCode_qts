import java.util.*;
// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int minFreq=n/3;
        Map<Integer, Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key=entry.getKey(), value=entry.getValue();
            if(value>minFreq){
                ans.add(key);
            }
        }
        return ans;
    }
}

class majorityElementII{
    public static void main(String[] args) {
    int[] nums={1,2,3,3};
    Solution s=new Solution();
    System.out.println(s.majorityElement(nums));

    }
}


import java.util.*;
// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
    private HashMap<Integer, List<Integer>> indices;
    private Random rand;
    
    public Solution(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l; ++i) {
            // if (!this.indices.containsKey(nums[i])) {
            //     this.indices.put(nums[i], new ArrayList<>());
            // }
            // this.indices.get(nums[i]).add(i);
            this.indices.computeIfAbsent(nums[i], v-> new ArrayList<Integer>()).add(i);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        // pick an index at random
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
    }
}

class pickRandomIndex{
    public static void main(String[] args) {
        int[] nums={1,3,9,4,9,4,4};
        Solution s= new Solution(nums);
        System.out.println(s.pick(4));
        System.out.println(s.pick(1));
    }
}


import java.util.*;
// Approach 1- Backtrack with no return 
// Very similar to second approach of permuteII.java 
class Solution {
    public void backtrack(List<List<Integer>> ans,  Set<List<Integer>> set, List<Integer> sub,int[] nums, int idx){
        if (sub.size()>1){
            set.add(new ArrayList<>(sub));
        }
        for(int i=idx; i<nums.length; i++){
            if(sub.isEmpty() || sub.get(sub.size()-1)<=nums[i]){
                sub.add(nums[i]);
                backtrack(ans,set,sub,nums,i+1);
                sub.remove(sub.size()-1);
            }
        }
    }
    
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Set<List<Integer>> set= new HashSet<>();
        List<Integer> sub= new ArrayList<>();
        backtrack(ans,set,sub,nums,0);
        return new ArrayList<>(set);
    }
}

class findSubsequences{
    public static void main(String[] args) {
        int[] nums={4,6,7,7};
        Solution s= new Solution();
        System.out.println(s.findSubsequences(nums));
    }
}

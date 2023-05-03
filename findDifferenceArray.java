import java.util.*;
// Approach 1- HashSet
class Solution { // TC O(n+m) SC O(max(n, m))
    public List<Integer> getElementOfFirstList(int[] nums1, int[] nums2){
        Set<Integer> seen=new HashSet<>();
        for(int num2: nums2){
            seen.add(num2);
        }
        
        Set<Integer> firstList=new HashSet<>();
        for(int num1: nums1){
            if (!seen.contains(num1)){
                firstList.add(num1);
            }
        }
        return new ArrayList<>(firstList);
        
    }
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        return Arrays.asList(getElementOfFirstList(nums1, nums2), getElementOfFirstList(nums2, nums1));
        
    }
}

class findDifferenceArray{
    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,4,6};
        Solution s= new Solution();
        System.out.println(s.findDifference(nums1, nums2));
    }
}


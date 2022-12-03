// 1 2 5 3 4  ans- 1 
// 1 4 2 5 3  ans- 2

/* https://ledarryl.medium.com/find-the-minimum-number-of-move-backs-required-
   to-sort-an-array-7bb2bb47ebf6
   Asked in tiktok interview 
*/

// Approach 1- Copy and sort the array and then compare 
import java.util.*;
class Solution{ // TC O(n log n) SC O(n)
    public int minStepsToSort(int[] nums){
        int[] sorted= new int[nums.length];
        System.arraycopy(nums,0,sorted,0,nums.length);
        Arrays.sort(sorted);
        int sortedIdx=0;
        for (int i=0; i<nums.length; i++){
        	if(nums[i]==sorted[sortedIdx]){
        		sortedIdx++;
        	}
        }
        return nums.length-sortedIdx;

    }
} 

class minStepsToSort{
	public static void main(String[] args) {
		int[] nums= {1,4,2,5,3};
		Solution s= new Solution();
		System.out.println(s.minStepsToSort(nums));
	}
}
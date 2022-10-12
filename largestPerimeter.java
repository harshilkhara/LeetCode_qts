import java.util.*;
// Approach 1- Sorting 
// The length of any side of a triangle is shorter than the sum of the other two sides
// i.e. c<a+b 
class Solution{ // TC O(n log n)  SC O(n) or O(log n) depending on sorting algo it uses
	public int largestPerimeter(int[] nums){
		Arrays.sort(nums);
		for(int i=nums.length-3; i>=0; i--){
			if (nums[i]+nums[i+1]>nums[i+2]){
				return nums[i]+nums[i+1]+nums[i+2];
			}
		}
		return 0;
	}
}

class largestPerimeter{
	public static void main(String[] args) {
		int[] nums={2,2,1};
		Solution s =new Solution();
		System.out.println(s.largestPerimeter(nums));
	}
}
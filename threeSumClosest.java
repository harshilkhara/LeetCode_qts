// Approach 1- Sort and Two Pointers 
// Similar to threeSum
import java.util.*;
class Solution{
	public int threeSumClosest(int[] nums, int target){
		Arrays.sort(nums);
		int diff=Integer.MAX_VALUE; 
		for(int i=0; i<nums.length;i++){
			int l=i+1, r=nums.length-1;
			while(l<r){
				int sum=nums[i]+nums[l]+nums[r];
				if (Math.abs(target-sum)<Math.abs(diff)){
					diff=target-sum;
				}
				if (sum < target)
					l++;
				else
					r--;
			}
			if (diff==0)
				break;
		}
		return target-diff;
	}
}
class threeSumClosest{
	public static void main(String[] args) {
		int[] nums={-1,2,1,-4};
		int target=1;
		Solution s= new Solution();
		System.out.println(s.threeSumClosest(nums,target));
	}
}
// Two pointers (Direct Method)
import java.util.*;
class minOperations{
	public static void main(String [] args){
	int [] nums={1,3,2,3,5,1,7};
	int x=14; 
	int left=0;
	int current=0;
	int mini= Integer.MAX_VALUE;
	for (int num : nums){
		current+=num;
	}
	for (int right=0; right<nums.length;right++){
		current-=nums[right];
		while (current < x && left<=right){
			current+=nums[left];
			left++;
		}
		if (current==x){
			mini=Math.min(mini, (nums.length-right-1)+left); 

		}
	}
	System.out.println((mini!=Integer.MAX_VALUE) ? mini : -1);
	}
}
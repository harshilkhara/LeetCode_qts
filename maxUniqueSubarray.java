// Two Pointers approach  TC O(2N) --> (N) // SC O(N)
import java.util.*;
public class maxUniqueSubarray{
	public static void main (String[] args){
	int [] nums={4,2,4,5,6};
	int current_sum=0; 
	int result=0; 
	int start=0; 
	HashSet<Integer> set = new HashSet<>();
	for (int end=0; end<nums.length;end++){
		while (set.contains(nums[end])){
		set.remove(nums[start]);
		current_sum-=nums[start];
		start++;
		}
		current_sum+=nums[end];
		set.add(nums[end]);
		result=Math.max(result,current_sum);
	}
	System.out.println(result);
	}
}
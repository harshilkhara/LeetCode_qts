import java.util.*;
// Approach 1- Priority Queue
class Solution{ // TC O(k log n) SC O(n)
	public int minimumDeviation(int[] nums){
		PriorityQueue<Integer> evens= new PriorityQueue<>((a,b)->b-a);
		int minimum=Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++){
			if(nums[i]%2==0){
				evens.add(nums[i]);
				minimum=Math.min(minimum,nums[i]);
			} else {
				evens.add(nums[i]*2);
				minimum=Math.min(minimum,nums[i]*2);
			}
			
		}
		int minDev=Integer.MAX_VALUE;
		while (!evens.isEmpty()){
			int maximum=evens.poll();
			minDev=Math.min(minDev,maximum-minimum);
			if(maximum%2==0){
				minimum=Math.min(minimum,maximum/2);
				evens.add(maximum/2);
			} else {
				break;
			}
		}
		return minDev;
	}
	
}

class minimumDeviation{
	public static void main(String[] args) {
		int[] nums={1,2,3,4};
		Solution s= new Solution();
		System.out.println(s.minimumDeviation(nums));
	}
}
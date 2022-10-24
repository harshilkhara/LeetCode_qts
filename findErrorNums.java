import java.util.*;
// Approach 1- HashMap
class Solution{ // TC O(n) SC O(n) 
	public int[] findErrorNums(int[] nums){
		HashMap<Integer, Integer> map= new HashMap<>();
		int dup=-1,miss=-1;
		for(int n: nums){
			map.put(n,map.getOrDefault(n,0)+1);
		}
		
		for(int i=1; i<=nums.length;i++){
			if(map.containsKey(i)){
				if(map.get(i)==2)
					dup=i;
			} else
				miss=i;
		}
		return new int[] {dup,miss};
	}
}

// Approach 2- Invert Index (Constant Space)
class Solution1{ // TC O(n) SC O(1)
	public int[] findErrorNums(int[] nums){
		int dup=-1, miss=1;
		for(int n: nums){
			if(nums[Math.abs(n)-1]<0)
				dup=Math.abs(n);
			else 
				nums[Math.abs(n)-1]*=-1;
		}
		for(int i=1; i<nums.length; i++){
			if(nums[i]>0)
				miss=i+1;
		}
		return new int[] {dup,miss};
	}
}

class findErrorNums{
	public static void main(String[] args) {
		int[] nums={1,2,2,4};
		Solution s= new Solution();
		int[] result= s.findErrorNums(nums);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(s.findErrorNums(nums)));
	}
}
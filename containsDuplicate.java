import java.util.*;
class Solution{ // TC O(n) SC O(n)
	public boolean containsDuplicate(int[] nums){
		Set<Integer> set= new HashSet<>();
		for(int num: nums){
			if (set.contains(num))
				return true;
			set.add(num);
		}
		return false;
	}
	
}

class containsDuplicate{
	public static void main(String[] args) {
		int[] nums={1,2,3,1};
		Solution s= new Solution();
		System.out.println(s.containsDuplicate(nums));
	}
}
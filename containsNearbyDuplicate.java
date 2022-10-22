import java.util.*;
// Approach 1- HashMap (Very much inspired from twosum)
class Solution{ // TC O(n) SC O(n)
	public boolean containsNearbyDuplicate(int[] nums, int k){
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if ((map.containsKey(nums[i])) && (i-map.get(nums[i]))<=k)
				return true;
			map.put(nums[i],i);
		}
		return false;
	}
}

// Approach 2- Sliding window 
class Solution1{ // TC O(n) SC O(k)
	public boolean containsNearbyDuplicate(int[] nums, int k){
		Set<Integer> set= new HashSet<>();
		for (int i=0; i<nums.length; i++){
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if(set.size()>k) // window constraint
				set.remove(nums[i-k]);
		}
		return false;
	}
}

class containsNearbyDuplicate{
	public static void main(String[] args) {
		int[] nums={1,2,3,1};
		int k=3; 
		Solution s= new Solution();
		System.out.println(s.containsNearbyDuplicate(nums,k));
		Solution1 s1= new Solution1();
		System.out.println(s1.containsNearbyDuplicate(nums,k));
	}
}
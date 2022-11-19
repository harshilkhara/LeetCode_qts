import java.util.*;
class Solution{
	public void backtrack(int[] nums, List<List<Integer>> answer, Set<Integer> seen, List<Integer> permute){
		if(permute.size()==nums.length){
			answer.add(new ArrayList<>(permute));
			return;
		}

		for (int i=0; i<nums.length; i++){
			if(!seen.contains(nums[i])){
				seen.add(nums[i]);
				permute.add(nums[i]);
				backtrack(nums,answer,seen,permute);
				seen.remove(nums[i]);
				permute.remove(permute.size()-1);
			}
		}

	}

	public List<List<Integer>> permute(int[] nums){
		Set<Integer> seen = new HashSet<>();
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> permute= new ArrayList<>();
        backtrack(nums,answer,seen,permute);
        return answer;
	}
}

class permute{
	public static void main(String[] args) {
		int[] nums={1,2,3};
		Solution s= new Solution();
		System.out.println(s.permute(nums));
	}
}
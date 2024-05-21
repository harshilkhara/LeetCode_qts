// Approach 1- Bayer moore's voting algorithm
class Solution{ // TC O(n) SC O(1)
	public int majorityElement(int[] nums){
		int count = 0;
		Integer candidate = null;
		for(int num: nums){
			if(count == 0){
				candidate = num;
			}
			count+= (candidate == num) ? 1 : -1;
		}
		return count;
	}
}

class majorityElement{
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,3,1,1,1,3,3,2,2};
		System.out.println(s.majorityElement(nums));
	}
}


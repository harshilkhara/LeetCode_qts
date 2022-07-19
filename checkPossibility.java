class Solution{
	public boolean checkPossibility(int[] nums){
		int numViolations=0;
		for (int i=1; i<nums.length;i++){
			if (nums[i-1]>nums[i]){
				if (numViolations==1){
					return false;
				}
			numViolations++;

			if (i<2 || nums[i-2]<=nums[i]){
				nums[i]=nums[i-1];
			}else{
				nums[i-1]=nums[i];
				}
			}
		}
		return true;
	}
}

class checkPossibility{
	public static void main(String[] args){
		int [] nums={4,2,1};
		Solution s= new Solution();
		System.out.println(s.checkPossibility(nums));
	}
}
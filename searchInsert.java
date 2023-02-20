class Solution{ // TC O(log n) SC O(1)
	public int searchInsert(int[] nums, int target){ 
		int left=0, right=nums.length-1;
		while (left<=right){
			int mid=left+(right-left)/2;
			// int mid=(left+right)/2;
			// int mid=(left+right)>>>1;
			if (nums[mid]==target){
				return mid;
			} else if (nums[mid]<target){
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		return left;
	}
}

class searchInsert{
	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		int target=4;
		Solution s= new Solution();
		System.out.println(s.searchInsert(nums,target));
	}
}
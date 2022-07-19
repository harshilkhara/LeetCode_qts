class Solution{
	public int binarySearch(int[] nums, int target){
		int left=0;
		int right=nums.length-1;
		while (left<=right){
			int mid=(right-left)+left/2; 
			if (nums[mid]==target){
				return mid;
			}else if(nums[mid]<target){
				left=mid+1;
			}
			else{
				right=mid-1;
			}
		}
		return -1;
	}
}

class binarySearch{
	public static void main(String[] args){
		int [] nums={-1,0,3,5,9,12};
		int target= 3;
		Solution s= new Solution();
		System.out.println(s.binarySearch(nums,target));
	}
}
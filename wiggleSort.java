import java.util.*;
// Approach 1- Sorting 
class Solution{ // TC O(n log n) SC O(log n)
	public void swap(int[] nums,int a, int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}

	public int[] wiggleSort(int[] nums){
		Arrays.sort(nums);
		for(int i=1; i<nums.length-1; i+=2){
			swap(nums,i,i+1);
		}
		return nums;
	}
}

// Approach 2- Kinda bubble sort like 
class Solution1{ // TC O(n) SC O(1)
	public void swap(int[] nums,int a, int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}

	public int[] wiggleSort(int[] nums){
		for(int i=1; i<nums.length; i++){
			if(i%2==1){
				if(nums[i]<nums[i-1]){
					swap(nums,i,i-1);
				}
			} else {
				if(nums[i]>nums[i-1]){
					swap(nums,i,i-1);
				}
			}
		}
		return nums;
	}

}

class wiggleSort{
	public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6};
		Solution s= new Solution();
		Solution1 s1= new Solution1();
		System.out.println(Arrays.toString(s.wiggleSort(nums)));
		System.out.println(Arrays.toString(s1.wiggleSort(nums)));
	}
}
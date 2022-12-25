import java.util.*;
// Approach 1- Sort and count
class Solution{ // TC O(n.m + n log n) SC O(n)
	public int[] answerQueries(int[] nums, int[] queries){
		Arrays.sort(nums);
		int[] answer=new int[queries.length];
		for(int i=0; i<queries.length; i++){
			int count=0;
			int query=queries[i];
			for(int num: nums){
				if(query>=num){
					count++;
					query-=num;
				} else {
					break;
				}
			}
			answer[i]=count;
		}
		return answer;
	}
}

// Approach 2- Prefix sum and Binary Search 
class Solution1{ // TC O((n+m) log n) SC O(n)
	public int binarySearch(int[] nums, int query){
		int l=0, r=nums.length-1;
		while (l<r){
			int mid=(l+r)/2;
			if(nums[mid]==query){
				return mid+1;
			}
			if(nums[mid]>query){
				r=mid-1;
			} else {
				l=mid+1;
			}
		}
		return nums[l]>query ? l:l+1;
	}

	public int[] answerQueries(int[] nums, int[] queries){
		Arrays.sort(nums);
		// prefix sum- running sum 
		for(int i=1; i<nums.length; i++){
			nums[i]+=nums[i-1];
		}
		int[] ans=new int[queries.length];
		for(int i=0; i<queries.length; i++){
			int index=binarySearch(nums,queries[i]);
			ans[i]=index;
		}
		return ans;
	} 
}

class answerQueries{
	public static void main(String[] args) {
		int[] nums={4,5,2,1};
		int[] queries={3,10,21};
		Solution s= new Solution();
		System.out.println(Arrays.toString(s.answerQueries(nums,queries)));
		Solution1 s1= new Solution1();
		System.out.println(Arrays.toString(s1.answerQueries(nums,queries)));
	}
}
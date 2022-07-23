import java.util.*;
class Solution{
	public int [] sortedSquares(int [] nums){
		int [] result= new int[nums.length]; 
		int l=0, r= nums.length-1;
		int square;
		for(int i=nums.length-1;i>=0;i--){
			if(Math.abs(nums[l])<Math.abs(nums[r])){
				square=nums[r];
				r--;
			}else{
				square=nums[l];
				l++;
			}
			result[i]=square*square;
		}
		return result; 
	}
}

class sortedSquares{
	public static void main(String[] args) {
		int [] nums={-3,-1,2,4,10};
		Solution s= new Solution();
		System.out.println(Arrays.toString(s.sortedSquares(nums)));
	}
}
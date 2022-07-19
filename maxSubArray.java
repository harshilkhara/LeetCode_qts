class maxSubArray{
	public static void main(String [] args){
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int total_sum=nums[0];
		int max_sum=nums[0];
		for( int n : nums){
			total_sum=Math.max(n,total_sum+n);
			max_sum=Math.max(max_sum,total_sum);

	}
	System.out.println(max_sum);
	}

}
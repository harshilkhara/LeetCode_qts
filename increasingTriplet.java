// Approach 1- Linear Scan 
// Think of LIS too here
class Solution{ // TC O(N) SC O(1)
	public boolean increasingTriplet(int[] nums){
		int firstNumber=Integer.MAX_VALUE;
		int secondNumber=Integer.MAX_VALUE;
		for (int num:nums){
			if (num<=firstNumber)
				firstNumber=num;
			else if (num<=secondNumber)
				secondNumber=num;
			else
				return true;
		}
		return false;
	}
}

class increasingTriplet{
	public static void main(String[] args) {
		int[] nums={1,2,0,3};
		Solution s= new Solution();
		System.out.println(s.increasingTriplet(nums));
	}
}
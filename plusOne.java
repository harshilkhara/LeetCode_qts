import java.util.*;

class Solution{
	public int[] plusOne(int [] digits){
		int n=digits.length; 
		for(int i=n-1; i>=0; i--){
			if (digits[i]==9){
				digits[i]=0;
			}else{
				digits[i]++;
				return digits;
			}
		}
		digits=new int[n+1];
		digits[0]=1;
		return digits;
	}
}

class plusOne{
	public static void main(String[] args){
		int [] digits={9,9};
		Solution s= new Solution();
		int [] x=s.plusOne(digits);
		System.out.println(Arrays.toString(x));
	}
}
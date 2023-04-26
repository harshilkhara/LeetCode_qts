import java.util.*;
// Approach 1- Brute Force
class Solution{ // TC O(log n) SC O(1)
	public int addDigits(int num){
		int sum=0;
		while (num>0){
			sum+=num%10;
			num/=10;
			if (sum>9 && num==0){
				num=sum;
				sum=0;
			}
		}
		return sum;
	}
}

// Approach 2- Maths 
class Solution1{ // TC O(1) SC O(1)
	public int addDigits(int num){
		if(num==0) return 0;
		return (num%9==0) ? 9 : num%9;
	}
}

class addDigits{
	public static void main(String[] args) {
		int num=934;
		Solution s= new Solution();
		System.out.println(s.addDigits(num));
		Solution1 s1= new Solution1();
		System.out.println(s.addDigits(num));
	}
}
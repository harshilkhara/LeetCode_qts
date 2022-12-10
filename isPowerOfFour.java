import java.util.*;
class Solution{ // TC O(log n) SC O(1)
	public boolean isPowerOfFour(int n){
		if (n==0) return false; 
		while(n%4==0){
			n/=4;
		}
		return n==1;
	}
}

// Approach 2- Brute Force + Precomputation  

class Solution1{ // TC O(1)  SC O(1)

	List<Integer> nums= new ArrayList<>();

	public void powers(){
		int n=15;
		int lastNum=1;
		nums.add(lastNum);
		for (int i=1; i<n+1;i++){
			lastNum*=4;
			nums.add(lastNum);
		}
	}

	public boolean isPowerOfFour(int n){
		powers();
		return nums.contains(n);
	}
  
}

class isPowerOfFour{
	public static void main(String[] args) {
		int n= 16; 
		Solution s = new Solution();
		Solution1 s1= new Solution1();
		System.out.println(s.isPowerOfFour(n));
		System.out.println(s1.isPowerOfFour(n));
	}
}
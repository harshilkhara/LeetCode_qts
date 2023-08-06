import java.util.*;
// Approach 1- Balance
class Solution{ // TC O(n) SC O(1)
	public int minAddToMakeValid(String s){
		int ans=0, bal=0;
		for(char c: s.toCharArray()){
			bal+= c=='(' ? 1 : -1;
			if(bal==-1){
				ans++;
				bal++;
			}
		}
		return ans+bal;
	}
}

class minAddToMakeValid{
	public static void main(String[] args){
		String x="(())))(";
		Solution s= new Solution();
		System.out.println(s.minAddToMakeValid(x));
	}
}
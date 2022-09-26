import java.util.*;
// Approach 1- Two Pointer (sliding window)
class Solution{ // TC O(2n) -> O(n) SC O(min(m,n))
	public int lengthOfLongestSubstring(String s){
		int[] freq= new int[128];
		int left=0, right=0;
		int res=0;
		while (right<s.length()){
			char r= s.charAt(right);
			freq[r]++;

			if (freq[r]>1){
				char l= s.charAt(left);
				freq[l]--;
				left++;
			}
			
			res=Math.max(right-left+1,res);
			right++;
		}
		return res;
	}
}

class lengthOfLongestSubstring{
	public static void main(String[] args) {
		String x= "abcabcbb";
		Solution s= new Solution();
		System.out.println(s.lengthOfLongestSubstring(x));
	}
}
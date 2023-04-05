import java.util.*;
// Approach 1- Greedy method
class Solution{ // TC O(n) SC O(1)
	public int partitionString(String s){
		int[] lastSeen=new int[26];
		int count=1, lastSubstring=0;
		Arrays.fill(lastSeen, -1);
		for(int i=0; i<s.length(); i++){
			if(lastSeen[s.charAt(i)-'a']>=lastSubstring){
				count++;
				lastSubstring=i;
			}
			lastSeen[s.charAt(i)-'a']=i;
		}
		return count;
	}
}

class partitionString{
	public static void main(String[] args) {
		String x="abacaba";
		Solution s= new Solution();
		System.out.println(s.partitionString(x));
	}
}
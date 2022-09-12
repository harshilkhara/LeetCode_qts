import java.util.*;
// Approach 1- Two Pointers 
class Solution{ // TC O(n log n) SC O(log n) --> (variant of quicksort)
	public int bagOfTokensScore(int []tokens,int power){
		Arrays.sort(tokens);
		int l=0, r= tokens.length-1;
		int points=0, ans=0;
		while(l<=r &&(power>=tokens[l] || points>0)){
			while(l<=r && power>=tokens[l]){
				power-=tokens[l++];
				points++;
			}
			ans=Math.max(ans,points);
			if(l<=r && points>0){
				power+=tokens[r--];
				points--;
			}
		}
		return ans;
	}
}

class bagOfTokensScore{
	public static void main(String[] args) {
		int [] tokens= {100,200,300,400,500};
		int power= 200;
		Solution s= new Solution();
		System.out.println(s.bagOfTokensScore(tokens,power));
	}
}
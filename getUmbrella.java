import java.util.*;
class Solution{
	public int getUmbrella(int requirements, int[] sizes){
		int max= requirements+1;
		int[] dp= new int [max];
		Arrays.fill(dp,max);
		dp[0]=0; 
		for (int i: sizes){
			for (int j=i; j<max;j++){
				dp[j]=Math.min(dp[j],dp[j-i]+1);
			}
		}
		return dp[requirements]>requirements ? -1:dp[requirements];
	}
}

class getUmbrella{
	public static void main(String[] args) {
		int requirements=6;
		int[] sizes={3,5};
		Solution s =new Solution();
		System.out.println(s.getUmbrella(requirements,sizes));
	}
}
import java.util.*;
// Approach 1- Greedy Method- Max heap 
class Solution{ // TC O((n+k)* log n)  SC O(n)
	public int minStoneSum(int[] piles, int k){
		PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
		for(int stones: piles){
			queue.add(stones);
		}

		while(k>0){
			int maxStone=queue.poll();
			int remove=maxStone/2;
			queue.add(maxStone-remove);
			k--;
		}

		int sum=0;
		for(int stones: queue){
			sum+=stones;
		}
		return sum; 
	}
}

class minStoneSum{
	public static void main(String[] args) {
		int[] piles={5,4,9};
		int k=2; 
		Solution s= new Solution();
		System.out.println(s.minStoneSum(piles,k));
	}
}
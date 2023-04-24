import java.util.*;
// Approach 1- Max heap 
class Solution{ // TC O(n log n) SC O(n)
	public int lastStoneWeight(int[] stones){
		PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
		for(int stone: stones){
			pq.offer(stone);
		}
		while(pq.size()>1){
			int y=pq.poll(), x=pq.poll();
			if(x==y) continue;
			pq.offer(y-x);
		}
		return pq.isEmpty() ? 0 : pq.poll(); 
	}
}

class lastStoneWeight{
	public static void main(String[] args) {
		int[] stones={2,7,4,1,8,1};
		Solution s=new Solution();
		System.out.println(s.lastStoneWeight(stones));
	}
}
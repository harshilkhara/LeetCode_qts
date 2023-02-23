import java.util.*;
// Approach 1- Greedy 
class Solution{ // TC O(n log n) SC O(n)
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
		int n=profits.length;
		int[][] projects=new int[n][2];
		for(int i=0; i<n; i++){
			projects[i][0]=capital[0];
			projects[i][1]=profits[1];
		}
		Arrays.sort(projects, (a,b)->a[0]-b[0]);

		PriorityQueue<Integer> pq=new PriorityQueue<>(n,(a,b)->b-a);
		int ptr=0;
		for(int i=0; i<k; i++){
			while(ptr<n && projects[ptr][0]<=w){
				pq.add(projects[ptr++][1]);
			}
			if(pq.isEmpty()) break;
			w+=pq.poll();
		}
		return w;
	}
}

class findMaximizedCapital{
	public static void main(String[] args) {
		int[] profits={1,2,3};
		int[] capital={0,1,1};
		int k=2;
		int w=0; 
		Solution s= new Solution();
		System.out.println(s.findMaximizedCapital(k,w,profits,capital));
	}
}
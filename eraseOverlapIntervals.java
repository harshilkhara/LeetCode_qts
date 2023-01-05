import java.util.*;
// Approach 1- Greedy
class Solution{ // TC O(n log n) SC O(log n) 
	public int eraseOverlapIntervals(int[][] intervals){
		Arrays.sort(intervals, (a,b)->(a[1]-b[1]));
		int firstEnd=intervals[0][1];
		int remove=0;
		for (int i=1; i<intervals.length; i++){
			if(intervals[i][0]<firstEnd){
				remove++;
			} else {
				firstEnd=intervals[i][1];
			}
		}
		return remove;
	}
}
class eraseOverlapIntervals{
	public static void main(String[] args) {
		int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
		Solution s =new Solution();
		System.out.println(s.eraseOverlapIntervals(intervals));
	}
}
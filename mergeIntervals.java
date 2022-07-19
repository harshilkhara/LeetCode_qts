import java.util.*;
class mergeIntervals{
	public static void main(String[] args){
		int [][] intervals={{1,3},{2,6},{8,10},{15,18}};
		LinkedList<int []> merged= new LinkedList<int []>();
		Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
		for (int [] interval: intervals){
			if (merged.isEmpty() || merged.getLast()[1]<interval[0]){
				merged.push(interval);
			}
		 else {
			merged.getLast()[1]=Math.max(merged.getLast()[1], interval[1]);
			}
		
		}
		System.out.println(Arrays.toString((merged.toArray(new int[merged.size()][]))));
	}
}
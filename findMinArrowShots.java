import java.util.*;
// Approach 1- Greedy 
class Solution { // TC O(n log n) SC O(log n) --> variant of quicksort algo
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }
}

class findMinArrowShots{
	public static void main(String[] args) {
		int[][] points={{10,16},{2,8},{1,6},{7,12}};
		Solution s= new Solution();
		System.out.println(s.findMinArrowShots(points));
	}
}
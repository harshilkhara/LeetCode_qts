import java.util.*;
// Approach 1- Brute Force
class Solution{ // TC O(n^2) SC O(1)
	public int countNegatives(int[][] grid){
		int nr=grid.length;
		int nc=grid[0].length;
		int count=0;
		for(int i=0; i<nr; i++){
			for(int j=0; j<nc; j++){
				if(grid[i][j]<0){
					count++;
				}
			}
		}
		return count;
	}
}

// Approach 2- Binary Search
class Solution1{ // TC O(n log n) SC O(1)
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        // Iterate on all rows of the matrix one by one.
        for (int[] row : grid) {
            // Using binary search find the index
            // which has the first negative element.
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;  
                }
            }
            // 'left' points to the first negative element,
            // which means 'n - left' is the number of all negative elements.
            count += (n - left);
        }
        return count;
    }
}

// Approach 3- Linear Traversal
class Solution2{ // TC O(n) SC O(1)
    public int countNegatives(int[][] grid) {
        int n=grid[0].length;
        int count=0, negativeIndex=n-1;
        for(int[] row: grid){
            while (negativeIndex>=0 && row[negativeIndex]<0){
                negativeIndex--;
            }
            count+=(n-(negativeIndex+1));
        }
        return count;
    }
}

class countNegativesMatrix{
	public static void main(String[] args) {
		int[][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		Solution s= new Solution();
		System.out.println(s.countNegatives(grid));
		Solution1 s1= new Solution1();
		System.out.println(s1.countNegatives(grid));
		Solution2 s2= new Solution2();
		System.out.println(s2.countNegatives(grid));

	}
}
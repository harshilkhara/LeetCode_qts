import java.util.*;
// Approach 1- Group by category 
class Solution { // TC O(m*n) SC O(m+n)
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
}

// Approach 2- Compare with top-left neighbor
class Solution1{ // TC O(m*n) SC O(1)
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}

class isToeplitzMatrix{ 
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        Solution s= new Solution();
        System.out.println(s.isToeplitzMatrix(matrix));
        Solution1 s1= new Solution1();
        System.out.println(s1.isToeplitzMatrix(matrix));
    }
}
import java.util.*;
// Approach 1- Hash Tables of Heaps
class Solution { // TC O(N*M*log(min(N,M))) SC O(N*M)
    public int[][] diagonalSort(int[][] mat) {
        // Store the matrix dimensions
        int m = mat.length;
        int n = mat[0].length;
        
        // Data structure to store the diagonals.
        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
        
        // Insert values into the HashMap.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) { 
                diagonals.putIfAbsent(row - col, new PriorityQueue<>());
                diagonals.get(row - col).add(mat[row][col]);
            }   
        }

        // Take values back out of the HashMap.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = diagonals.get(row - col).remove();
            }
        }
        
        return mat;
    }
}

// Approach 2- Sort diagonals one by one using heaps
class Solution1{ // TC O(N*M*log(min(N,M))) SC O (min(N*M))
    public int[][] diagonalSort(int[][] mat) {
        // Store the matrix dimensions.
        int m = mat.length;
        int n = mat[0].length;
        
        // Sort each diagonal that starts on a row.
        for (int row = 0; row < m; row++) {
            sortDiagonal(row, 0, mat);       
        } 

        // Sort each diagonal that starts on a col.
        // Note that we've already sorted the one starting
        // at col = 0; this is the same as the one starting
        // at row = 0.
        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, mat);  
        } 
        
        return mat;
    }

    private void sortDiagonal(int row, int col, int[][] mat) {
        int m = mat.length; 
        int n = mat[0].length;
        Queue<Integer> diagonal = new PriorityQueue<>();
        
        int diagonalLength = Math.min(m - row, n - col);
        // Put values on this diagonal into the heap.
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(mat[row + i][col + i]);
        }
        // Put values on heap back into this diagonal
        for (int i = 0; i < diagonalLength; i++) {
            mat[row + i][col + i] = diagonal.remove();
        }
    }
}

class diagonalSort{
    public static void main(String[] args) {
        int[][] matrix={{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        Solution s= new Solution();
        System.out.println(Arrays.deepToString(s.diagonalSort(matrix)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.deepToString(s1.diagonalSort(matrix)));
    }
}
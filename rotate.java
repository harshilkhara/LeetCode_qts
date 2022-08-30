import java.util.*;

//Approach 1- Transpose and reflect 
class Solution { // TC O(m)  SC O(1) m--> no. of cells 
    public String rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
        return Arrays.deepToString(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

//Approach 2- Rotate groups of 4 cells
class Solution1{ // TC O(m)  SC O(1) m--> no. of cells 
    public String rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return Arrays.deepToString(matrix);
    }
}

class rotate{
    public static void main(String[] args) {
        int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        System.out.println(s.rotate(matrix));
        System.out.println(s1.rotate(matrix));
    }
}
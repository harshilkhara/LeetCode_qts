import java.util.*;
// Approach 1- BFS
class Solution { // TC O(m.n) SC O(m.n)
    int rows, cols;
    int[][] directions;

    public boolean validMatrix(int row, int col){
        return 0 <= row && row < rows && 0 <= col && col < cols;
    }

    public int[][] updateMatrix(int[][] mat) {
        this.rows= mat.length;
        this.cols= mat[0].length;
        this.directions=new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};

        int[][] ans=new int[rows][cols];
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean [rows][cols];

        for(int row=0; row < rows; row++){
            for(int col=0; col < cols; col++){
                ans[row][col]=mat[row][col];
                if(mat[row][col]==0){
                    queue.add(new int[] {row, col, 0});
                    visited[row][col]= true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] state=queue.poll();
            int row=state[0], col= state[1], steps=state[2];

            for(int[] dir: directions){
            int newRow=row+dir[0], newCol=col+dir[1];
                if(validMatrix(newRow, newCol) && !visited[newRow][newCol]){
                    queue.add(new int[] {newRow, newCol, steps+1});
                    visited[newRow][newCol]=true;
                    ans[newRow][newCol]=steps+1;
                }
            }
        }
        return ans;
    }
}

class binaryMatrix{
    public static void main(String[] args) {
        int[][] matrix={{0,0,0}, {0,1,0}, {0,0,0}};
        Solution s= new Solution();
        System.out.println(Arrays.deepToString(s.updateMatrix(matrix)));
    }
    
}
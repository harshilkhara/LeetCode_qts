import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) { // TC O(n^2) SC O(n^2)
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}

class isValidSudoko{
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Solution s= new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
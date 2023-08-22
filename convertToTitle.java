import java.util.*;
// Approach 1- Math
class Solution { // TC O(log n) SC O(1)
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;

            sb.append((char)((columnNumber)%26 + 'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}

class convertToTitle{
    public static void main(String[] args) {
        int columnNumber = 902;
        Solution s= new Solution();
        System.out.println(s.convertToTitle(columnNumber));
    }
}
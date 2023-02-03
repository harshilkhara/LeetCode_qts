import java.util.*;
// Approach 1- Simulate Zig-Zag movement
class Solution { // TC O(numRows*n) SC O(numRows*n)
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int n=s.length();
        int sections= (int) Math.ceil(n/(2*numRows-2.0));
        int numCols=sections*(numRows-1);
        
        char[][] matrix=new char[numRows][numCols];
        for(char[] row: matrix){
            Arrays.fill(row, ' ');
        }
        
        int currRow=0, currCol=0, currentIndex=0;
        
        while(currentIndex<n){
            // down
            while(currRow<numRows && currentIndex<n){
                matrix[currRow++][currCol]=s.charAt(currentIndex++);
            }
            
            currRow-=2;
            currCol++;
            // diagonal
            while(currRow>0 && currCol<numCols && currentIndex<n){
                matrix[currRow--][currCol++]=s.charAt(currentIndex++);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(char[] row: matrix){
            for(char c: row){
                if(c!=' '){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

// Approach 2- String Traversal
class Solution1{ // TC O(n) SC O(1)
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int charsInSection=2*numRows-2;
        for(int currRow=0; currRow<numRows; currRow++){
            int index=currRow;
            while(index<n){
                sb.append(s.charAt(index));
                if(currRow!=0 && currRow!=numRows-1){
                    int charsInBetween=charsInSection-2*currRow;
                    int secondIndex=index+charsInBetween;
                    
                    if(secondIndex<n){
                        sb.append(s.charAt(secondIndex));
                    }
                }
                index+=charsInSection;
            }
        }
        return sb.toString();
    }
}

class zigzagConversion{
    public static void main(String[] args) {
        String x="HARSHILISHIRED";
        int rows=3;
        Solution s= new Solution();
        System.out.println(s.convert(x,rows));
        Solution1 s1= new Solution1();
        System.out.println(s1.convert(x,rows));
    }
}
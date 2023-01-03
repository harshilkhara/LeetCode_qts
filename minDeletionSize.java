import java.util.*;
// Approach 1- Simple two-for loops 
class Solution { // TC O(m*n) SC O(1)
    public int minDeletionSize(String[] strs) {
        int del=0;
        int n=strs[0].length();
        for (int j=0; j<n; j++){
            for(int i=0; i<strs.length-1; i++){
                if(strs[i].charAt(j)>strs[i+1].charAt(j)){
                    del++;
                    break;
                }
            }
        }
        return del;
    }
}

class minDeletionSize{
    public static void main(String[] args) {
        String[] strs={"cba","daf","ghi"};
        Solution s= new Solution();
        System.out.println(s.minDeletionSize(strs));
    }
}
import java.util.*;
// Approach 1- Single Iteration 
class Solution { // TC O(n) SC O(n)
    public boolean isCircularSentence(String sentence) {
        String[] s= sentence.split(" ");
        int lastWordLength=s[s.length-1].length();
        if (s[s.length-1].charAt(lastWordLength-1)!=s[0].charAt(0)){
            return false;
        } 
        for (int i=0; i<s.length-1; i++){
            int wordLength=s[i].length();
            if (s[i].charAt(wordLength-1)!=s[i+1].charAt(0)){
                return false;
            }        
        }
        return true;
    }
}

class isCircularSentence{
    public static void main(String[] args) {
        String sentence= "leetcode exercises sound delightful";
        Solution s= new Solution();
        System.out.println(s.isCircularSentence(sentence));
    }
}
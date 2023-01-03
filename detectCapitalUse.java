import java.util.*;
// Approach 1- Character by Character 
class Solution { // TC O(n) SC O(1)
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        if (n==1) return true;
        
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            for (int i=2; i<n; i++){
                if(!Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        } else {
            for(int i=1; i<n; i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}

// Approach 2- Regex
class Solution1{ // TC O(n) SC O(1)
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}

class detectCapitalUse{
    public static void main(String[] args) {
        String word="Google";
        Solution s= new Solution();
        System.out.println(s.detectCapitalUse(word));
        Solution1 s1= new Solution1();
        System.out.println(s1.detectCapitalUse(word));
    }
}
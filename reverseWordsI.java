import java.util.*;
// Approach 1- Traversing from the end of list and append to a new result 
// Similar approach to Second one in reverseString.java 
class Solution { // TC O(n) SC O(n)
    public String reverseWordsI(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            if (!words[i].isEmpty())
                result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }
}

class reverseWordsI{
    public static void main(String[] args) {
        String x= "the sky is blue";
        Solution s= new Solution();
        System.out.println(s.reverseWordsI(x)); 
    }
}
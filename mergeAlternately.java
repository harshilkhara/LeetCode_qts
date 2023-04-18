import java.util.*;
// Approach 1- With substring
class Solution { // TC O(max(m,n)) O(1)
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int m=word1.length(), n=word2.length();
        for(int i=0; i<Math.min(m,n); i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(m<n){
            sb.append(word2.substring(m));
        } else {
            sb.append(word1.substring(n));
        }
        return sb.toString();

    }
}

// Approach 2- Without substring
class Solution1{ // TC O(max(m,n)) O(1)
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int m=word1.length(), n=word2.length();
        for(int i=0; i<Math.max(m,n); i++){
            if (i<m)
                sb.append(word1.charAt(i));
            if (i<n)
                sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}

class mergeAlternately{
    public static void main(String[] args) {
        String word1="abcde";
        String word2="pqr";
        Solution s= new Solution();
        System.out.println(s.mergeAlternately(word1, word2));
        Solution1 s1= new Solution1();
        System.out.println(s.mergeAlternately(word1, word2));
    }
}
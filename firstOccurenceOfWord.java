import java.util.*;
// Approach 1- Sliding window of fixed length 
// Similar to approach 1 of findRepeatedDnaSequences.py 
class Solution {
    public int strStr(String haystack, String needle) {
        int l=needle.length();
        for (int i=0; i<haystack.length()-l+1; i++){
            String temp=haystack.substring(i,i+l);
            if (temp.equals(needle))
                return i;
            
        }
        return -1;
    }
}

// Approach 2- Using built-in function 
class Solution1{
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

class firstOccurenceOfWord{
    public static void main(String[] args) {
        String haystack ="sadbutsad";
        String needle="sad";
        Solution s= new Solution();
        System.out.println(s.strStr(haystack,needle));
        Solution1 s1= new Solution1();
        System.out.println(s1.strStr(haystack,needle));
    }
}
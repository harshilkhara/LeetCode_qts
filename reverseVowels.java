import java.util.*;
// very similar to reverse string.java 
// Approach 1- Two Pointers
class Solution { // TC O(n) SC O(n)
    public void swap(char[] sChar, int a, int b){
        char temp= sChar[a];
        sChar[a]=sChar[b];
        sChar[b]=temp;
    }
    
    public String reverseVowels(String s) {
        Set<Character> set= new HashSet<>(Arrays.asList('A','a','E','e',
                                                       'I','i','O','o','U','u'));
        
        int l=0, r=s.length()-1;
        char[] sChar= s.toCharArray();
        while(l<r){
            while(l<s.length()-1 && !set.contains(sChar[l])){
                l++;
            }
            while(r>=0 && !set.contains(sChar[r])){
                r--;
            }
            if (l<r){
                swap(sChar,l++,r--);
            }
        }
        return new String(sChar);
    }
}

class reverseVowels{
    public static void main(String[] args) {
        String x= "hello";
        Solution s= new Solution();
        System.out.println(s.reverseVowels(x));
    }
}
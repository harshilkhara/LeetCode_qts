import java.util.*;
// Exactly same as findAnagrams.java & .py
// Approach 1- Sliding window with Arrays
class Solution { // TC O(Ns1+Ns2) SC O(1)
    public boolean checkInclusion(String s1, String s2) {
        int ns1=s1.length();
        int ns2=s2.length();
        if (ns1>ns2) return false;
        
        int[] s1Count=new int[26];
        int[] s2Count=new int[26];
        for (char c: s1.toCharArray()){
            s1Count[c-'a']++;
        }
        for(int i=0; i<ns2; i++){
            char c=s2.charAt(i);
            s2Count[c-'a']++;
            if (i>=ns1){
                s2Count[s2.charAt(i-ns1)-'a']--;
            }
            if(Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }
        return false;
    }
}

class checkInclusion{
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        Solution s= new Solution();
        System.out.println(s.checkInclusion(s1,s2));
    }
}
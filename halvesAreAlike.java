import java.util.*;
// Appraoch 1- Counting in place
class Solution { // TC O(n) SC O(1)
    public boolean halvesAreAlike(String s) {
        int n = s.length();

        String vowels = "aeiouAEIOU";
        int aVowelCount = 0;
        for (int i=0; i<n/2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                aVowelCount++;
            }
        }

        int bVowelCount = 0;
        for (int i =n/2; i<n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                bVowelCount++;
            }
        }

        return aVowelCount == bVowelCount;
    }
}

class halvesAreAlike{
    public static void main(String[] args) {
        String x= "book";
        Solution s= new Solution();
        System.out.println(s.halvesAreAlike(x));
    }
}
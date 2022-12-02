import java.util.*;
// Approach 1- Two for loops 
class Solution{ // TC O(n) SC O(1)
    public int lengthOfLastWord(String s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        // compute the length of last word
        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }
}

// Approach 2- One for loop
class Solution1{ // TC O(n) SC O(1)
    public int lengthOfLastWord(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (s.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
  }
}

// Approach 3- Built in functions 
class Solution2{ // TC O(n) SC O(n)
    public int lengthOfLastWord(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}


class lengthOfLastWord{
    public static void main(String[] args) {
        String words= "Hello World";
        Solution s= new Solution();
        System.out.println(s.lengthOfLastWord(words));
        Solution1 s1= new Solution1();
        System.out.println(s1.lengthOfLastWord(words));
        Solution2 s2= new Solution2();
        System.out.println(s2.lengthOfLastWord(words));
    }
}
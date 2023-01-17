import java.util.*;
// Approach 1- Dynamic Window
class Solution { // TC O(n) SC O(1)
    public int minFlipsMonoIncr(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;
    }
}

// Approach 2- DP 
class Solution1{ // TC O(n) SC O(1)
    public int minFlipsMonoIncr(String s) {
        int ans = 0, ones = 0;
        /*
        for (char c: s.toCharArray()) {
            if (c == '0') {
        */
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ones, ans + 1);
            } else {
                ++ones;
            }
        }
        return ans;
    }
}

class minFlipsMonoIncr{
    public static void main(String[] args) {
        String x= "010110";
        Solution s= new Solution();
        System.out.println(s.minFlipsMonoIncr(x));
        Solution1 s1= new Solution1();
        System.out.println(s1.minFlipsMonoIncr(x));
    }
}
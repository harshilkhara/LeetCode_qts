import java.util.*;
// Approach 1- Stack
class Solution { // TC O(n) SC O(n)
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

class backspaceCompare{
    public static void main(String[] args) {
        String x="y#fo##f";
        String t="y#f#o##f";
        Solution s= new Solution();
        System.out.println(s.backspaceCompare(x,t));
    }
}


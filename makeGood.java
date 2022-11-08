import java.util.*;
// Approach 1- Stack 
class Solution { // TC O(n) SC O(n)
    public String makeGood(String s) {
        // Use stack to store the visited characters.
        Stack<Character> stack = new Stack<>();
        
        // Iterate over 's'.
        for (char currChar : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (!stack.isEmpty() && Math.abs(stack.peek() - currChar) == 32) 
                stack.pop();
            else
                stack.add(currChar);
        }
        
        // Returns the string concatenated by all characters left in the stack.
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack) 
            ans.append(currChar);

        //char c= 'a';
        //System.out.println((int) c);
        //System.out.println('A'-'b');
        return ans.toString();
    }
}

// Approach 2- Brute Force (Recursive) [using implict call stack]
class Solution1{ // TC O(n) SC O(n)
    public String makeGood(String s) {
        // If we find a pair in 's', remove this pair from 's'
        // and solve the remaining string recursively.
        for (int i = 0; i < s.length() - 1; ++i) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32)
                return makeGood(s.substring(0, i) + s.substring(i + 2));
        }

        // Base case, if we can't find a pair, just return 's'.
        return s;
    }
}

class makeGood{
    public static void main(String[] args) {
        String x="leeEetcode";
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        System.out.println(s.makeGood(x));
        System.out.println(s1.makeGood(x));
    }
}


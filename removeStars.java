import java.util.*;
// Approach 1- Using stack
class Solution { // TC O(n) SC O(n)
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='*'){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        //return String.valueOf(stack);
        
        StringBuilder answer=new StringBuilder();
        for(char c: stack){
            answer.append(c);
        }
        return answer.toString();
    }
}

// Approach 2- String manipulation
class Solution {
    public String removeStars(String s) {
        int j = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                answer.deleteCharAt(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}

class removeStars{
    public static void main(String[] args) {
        String x="leet**cod*e";
        Solution s= new Solution();
        System.out.println(s.removeStars(x));
    }
}
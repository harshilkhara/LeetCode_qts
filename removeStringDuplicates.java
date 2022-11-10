import java.util.*;
// Approach 1- Implementing sb as a stack 
class Solution{ // TC O(n) SC O(n)
  public String removeStringDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    int sbLength = 0;
    for(char character : S.toCharArray()) {
      if (sbLength != 0 && character == sb.charAt(sbLength - 1))
        sb.deleteCharAt(sbLength-- - 1);
      else {
        sb.append(character);
        sbLength++;
      }
    }
    return sb.toString();
  }
}

// Approach 2- Purely using stack similar to makeGood.java 
class Solution1{ // TC O(n) SC O(n)
    public String removeStringDuplicates(String s) {
        Stack<Character> stack =new Stack<>();
        for(char c: s.toCharArray()){
            if (!stack.isEmpty() && (stack.peek()==c)){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb= new StringBuilder();
        for(char c: stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}

class removeStringDuplicates{
  public static void main(String[] args) {
    String x= "abbaca";
    Solution s= new Solution();
    System.out.println(s.removeStringDuplicates(x));
    Solution1 s1= new Solution1();
    System.out.println(s1.removeStringDuplicates(x));
  }
}
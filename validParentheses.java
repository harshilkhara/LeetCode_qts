import java.util.*;
class Solution{ // TC O(n) SC O(n)
	public boolean validParentheses(String s){ 
		Map<Character, Character> map=new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack=new Stack<>();
		for(char c: s.toCharArray()){
			if(map.containsKey(c)){
				char topElement= stack.isEmpty() ? '#': stack.pop();
				if(topElement!=map.get(c)){
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}

class validParentheses{
	public static void main(String[] args) {
		String x= "([])";
		Solution s= new Solution();
		System.out.println(s.validParentheses(x));
	}
}

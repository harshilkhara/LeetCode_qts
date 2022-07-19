import java.util.*;
public class validParentheses {

	public static void main(String[] args) {
		String s= "([])";
		HashMap<Character, Character> map= new HashMap<>();
		Stack<Character> stack= new Stack<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		for (int i=0; i<s.length();i++) {
			char c=s.charAt(i);
			if (map.containsKey(c)) {
				char top_element= (stack.empty()) ? '#' : stack.pop();
				
				if (top_element!=map.get(c)) {
					System.out.println(false);
				} 
				}else {
					stack.push(c);
			}
			
		}
		System.out.println(stack.isEmpty());
		

	}

}

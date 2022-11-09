import java.util.*;
// Approach 1- Monotonic Stack
class Solution{
	Stack<int[]> stack; 

	public Solution(){
		stack= new Stack<>();
	}

	public int next(int price){
		int count=1;
		while(!stack.isEmpty() && stack.peek()[0]<=price){
			count+=stack.pop()[1];
		}
		stack.push(new int[]{price,count});
		return count;
	}
}

class stockSpanner{
	public static void main(String[] args) {
		Solution sp= new Solution();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
	}
}
import java.util.*;
// Approach 1- Iterative DFS [using explicit stack]
class Solution{ // TC O(N+E) SC O(N)
	public boolean canVisitAllRooms(List<List<Integer>> rooms){
		boolean[] seen= new boolean[rooms.size()];
		Stack<Integer> stack= new Stack<>();
		seen[0]=true;
		stack.push(0);
		while(!stack.isEmpty()){
			int room=stack.pop();
			for(int key: rooms.get(room)){
				if(!seen[key]){
					seen[key]=true;
					stack.push(key);
				}
			}
		}

		for(boolean visited:seen){
			if(!visited) return false;
		}
		return true;
	}
}

class canVisitAllRooms{
	public static void main(String[] args) {
		List<List<Integer>> rooms= new ArrayList<>(Arrays.asList(Arrays.asList(1),
			Arrays.asList(2),Arrays.asList(3),Arrays.asList()));
		Solution s= new Solution();
		System.out.println(s.canVisitAllRooms(rooms));
	}
}

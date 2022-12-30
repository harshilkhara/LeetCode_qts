import java.util.*;
// Approach 1- Backtrack
class Solution{ // TC O(2^n.n)  SC O(n)
	int[][] graph;

	public void backtrack(List<List<Integer>> result, List<Integer> path, int target, int node){
		if (node==target){
			result.add(new ArrayList<>(path));
			return;
		}
		for (int nextNode: graph[node]){
			path.add(nextNode);
			backtrack(result,path,target,nextNode);
			path.remove(path.size()-1);
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph){
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> path=new ArrayList<>(Arrays.asList(0));
		this.graph=graph;
		int target=graph.length-1; 
		backtrack(result,path,target,0);
		return result;
	}
}
class allPathsSourceTarget{
	public static void main(String[] args) {
		int[][] graph={{1,2},{3},{3},{}};
		Solution s= new Solution();
		System.out.println(s.allPathsSourceTarget(graph));
	}
}

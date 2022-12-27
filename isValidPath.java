import java.util.*;
// Approach 1- BFS [using queue]
class Solution{ // TC O(n+m) SC O(n+m)
    public boolean isValidPath(int n, int[][] edges, int source, int destination) {
        //Store all edges in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

            // For all the neighbors of the current node, if we haven't visit it before,            
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}

// Approach 2- DFS (Recursive) [using implicit call-stack]
class Solution1{ // TC O(n+m) SC O(n+m)
    public boolean isValidPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        return dfs(graph, seen, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int nextNode : graph.get(currNode)) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Approach 3- DFS (Iterative) [using explicit call-stack]
class Solution2{ // TC O(n+m) SC O(n+m)
    public boolean isValidPath(int n, int[][] edges, int source, int destination) {
        // Store all edges according to nodes in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Start from source node, add it to stack.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination) {
                return true;
            }
            // Add all unvisited neighbors of the current node to stack'
            // and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
        
        return false; 
    }
} 

// Approach 4- Disjoint Sets (DSU) [union-find]
class Solution3{ // TC O(m . aplha(n)) SC O(n)
	public int find(int vertex, int[] root){
		if(root[vertex]!=vertex){
			root[vertex]=find(root[vertex],root);
		}
		return root[vertex];
	}

	public void union(int v1, int v2, int[] root, int[] size){
		v1=find(v1,root);
		v2=find(v2,root);

		if(v1!=v2){
			if(size[v1]>size[v2]){
				size[v1]+=size[v2];
				root[v2]=v1;
			} else {
				size[v2]+=size[v1];
				root[v1]=v2;
			}
		}
	}

	public boolean isValidPath(int n, int[][] edges, int source, int destination){
		int[] root=new int[n];
		int[] size=new int[n];

		for(int i=0; i<n; i++){
			root[i]=i;
			size[i]=1;
		}

		for(int[] edge: edges){
			union(edge[0],edge[1],root,size);
		}

		return find(source,root)==find(destination,root);
	}
}

class isValidPath{
	public static void main(String[] args) {
		int[][]edges={{0,1},{0,2},{3,5},{5,4},{4,3}};
		int n=6;
		int source=0;
		int destination=5;
		Solution s= new Solution();
		System.out.println(s.isValidPath(n,edges,source,destination));
		Solution1 s1= new Solution1();
		System.out.println(s1.isValidPath(n,edges,source,destination));
		Solution2 s2= new Solution2();
		System.out.println(s2.isValidPath(n,edges,source,destination));
		Solution3 s3= new Solution3();
		System.out.println(s3.isValidPath(n,edges,source,destination));
	}
}
//n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
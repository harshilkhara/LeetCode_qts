import java.util.*;
// Approach 1- BFS 
class Solution { // TC O(N+E) SC O(N+E)
    public boolean bfs(int source, Map<Integer, List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0; // Start with marking source as `RED`.

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == color[node])
                    return false;
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // 0 stands for red and 1 stands for blue.

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // For each pending component, run BFS.
                if (!bfs(i, adj, color))
                    // Return false, if there is conflict in the component.
                    return false;
            }
        }
        return true;
    }
}

// Approach 2- DFS
class Solution { // TC O(N+E) SC O(N+E)
    public boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> adj, int[] color) {
        color[node] = nodeColor;
        if (!adj.containsKey(node))
            return true;
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == color[node])
                return false;
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - nodeColor, adj, color))
                    return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // 0 stands for red and 1 stands for blue.

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // For each pending component, run DFS.
                if (!dfs(i, 0, adj, color))
                    // Return false, if there is conflict in the component.
                    return false;
            }
        }
        return true;
    }
}


// Approach 3- Disjoint Sets (DSU) 
class Solution{ // TC O(N+E) SC O(N+E)
	public int find(int[] parents, int vertex){
		if(parents[vertex]!=vertex){
			parents[vertex]=find(parents,parents[vertex]);
		}
		return parents[vertex];
	}

	public void union(int[] parents, int[] size, int v1, int v2){
		v1=find(parents,v1);
		v2=find(parents,v2);

		if(v1!=v2){
			if(size[v1]>size[v2]){
				size[v1]+=size[v2];
				parents[v2]=v1;
			} else {
				size[v2]+=size[v1];
				parents[v1]=v2;
			}
		}
	}

	public boolean possibleBipartition(int n, int[][] dislikes){
		int[] parents=new int[n+1];
		int[] size= new int[n+1];
		for(int i=0; i<n; i++){
			parents[i]=i;
			size[i]=1;
		}

		Map<Integer, List<Integer>> map= new HashMap<>();
		for(int[] edge: dislikes){
			int a=edge[0], b=edge[1];
			map.computeIfAbsent(a,value->new ArrayList<Integer>()).add(b);
			map.computeIfAbsent(b,value->new ArrayList<Integer>()).add(a);
		}

		for(int node=1; node<=n; node++){
			if(!map.containsKey(node)){
				continue;
			}
			for(int nei: map.get(node)){
				if(find(parents,nei)==find(parents,node)){
					return false;
				}
				union(parents,size,map.get(node).get(0),nei);
			}
		}

		return true;
	}
	
}

class possibleBipartition{
	public static void main(String[] args) {
		int[][] dislikes={{1,2},{1,3},{2,4}};
		int n=4; 
		Solution s= new Solution();
		System.out.println(s.possibleBipartition(n,dislikes));
	}
}
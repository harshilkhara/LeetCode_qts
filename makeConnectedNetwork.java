import java.util.*;
// Approach 1- DFS (Recursive)
class Solution{ // TC O(n+e) SC O(n+e)
    public void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        if (!adj.containsKey(node)) {
            return;
        }
        for (int neighbor : adj.get(node)) {
            if (!visit[neighbor]) {
                visit[neighbor] = true;
                dfs(neighbor, adj, visit);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        }

        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                dfs(i, adj, visit);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}

// Approach 2- BFS 
class Solution1{ // TC O(n+e) SC O(n+e)
    public void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        }

        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                bfs(i, adj, visit);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}

// Approach 3- Union-Find (Disjoint sets)
class Solution2{ // TC O(n+e) SC O(n)
    public int find(int vertex, int[] parent){
        if(parent[vertex]!=vertex){
            parent[vertex]=find(parent[vertex], parent);
        }
        return parent[vertex];
    }
    
    
    public void union(int v1, int v2, int[] parent, int[] size){
        v1=find(v1, parent);
        v2=find(v2, parent);
        if(v1!=v2){
            if(size[v1]>size[v2]){
                size[v1]+=size[v2];
                parent[v2]=v1;
            } else {
                size[v2]+=size[v1];
                parent[v1]=v2;
            }
        }
        return;
    }
    
    public int makeConnectedNetwork(int n, int[][] connections) {
        
        if(connections.length < n-1) {
            return -1;
        }
        
        int[] parent=new int[n];
        int[] size=new int[n];
        
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        
        int answer=n;
        for(int[] connection: connections){
            if(find(connection[0], parent)!=find(connection[1], parent)){
                answer--;
                union(connection[0], connection[1], parent, size);
            }
        }
        return answer-1;
    }
}

class makeConnectedNetwork{
    public static void main(String[] args) {
        int[][] connections={{0,1},{0,2},{1,2}};
        int n=4;
        Solution s=new Solution();
        System.out.println(s.makeConnectedNetwork(n, connections));
    }
}
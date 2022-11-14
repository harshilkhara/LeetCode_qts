import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(E+V) SC O(E+V)
    
     private void dfs(List<Integer>[] adjList, boolean[] visited, int startNode) {
        visited[startNode] = true;
         
        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == false) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) { 
        int components = 0;
        boolean[] visited = new boolean[n];
        
        List<Integer>[] adjList = new ArrayList[n]; 
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
}

// Approach 2- Disjoint sets (DSU) [union-find]
class Solution1{ // TC O(E. alpha(V)) SC O(V)

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }
        
        return representative[vertex] = find(representative, representative[vertex]);
    }
    
    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);
        
        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for (int i = 0; i < edges.length; i++) { 
            components -= combine(representative, size, edges[i][0], edges[i][1]);
            System.out.println(components);
        }

        return components;
    }
}

class countComponents{
    public static void main(String[] args) {
        int n= 5; 
        int[][] edges= {{0,1},{1,2},{3,4}};
        Solution s= new Solution();
        System.out.println(s.countComponents(n,edges));
        Solution1 s1= new Solution1();
        System.out.println(s1.countComponents(n,edges));
    }
}
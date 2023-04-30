import java.util.*;
class UnionFind{
    int[] parent;
    int[] size;
    int components;
    public UnionFind(int n){
        components=n;
        parent=new int[n+1];
        size=new int[n+1];
        
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    public int find(int vertex){
        if(parent[vertex]!=vertex){
            parent[vertex]=find(parent[vertex]);
        }
        return parent[vertex];
    }
    
    public int union(int v1, int v2){
        v1=find(v1);
        v2=find(v2);
        
        if(v1==v2) return 0;
        if(v1!=v2){
            if(size[v1]>size[v2]){
                parent[v2]=v1;
                size[v1]+=size[v2];
            } else {
                parent[v1]=v2;
                size[v2]+=size[v1];
            }
        }
        components--;
        return 1;
    }
    
    public boolean isConnected(){
        return components==1;
    }
}

// Approach 1- DSU
class Solution { // # TC O(e+v) SC O(n)
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Different objects for Alice and Bob.
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;
        // Perform union for edges of type = 3, for both Alice and Bob.
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (Alice.union(edge[1], edge[2]) | Bob.union(edge[1], edge[2]));
            }
        }

        // Perform union for Alice if type = 1 and for Bob if type = 2.
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += Alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                edgesRequired += Bob.union(edge[1], edge[2]);
            }
        }
        
        if (Alice.isConnected() && Bob.isConnected()) {
            return edges.length - edgesRequired;
        }
        
        return -1;
    }
}

class maxNumEdgesToRemove{
    public static void main(String[] args) {
        int n=4;
        int[][] edges={{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        Solution s= new Solution();
        System.out.println(s.maxNumEdgesToRemove(n, edges));
    }
}
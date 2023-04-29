import java.util.*;
// Approach 1- DSU
class Solution { // TC O(n + e log e + q log q) SC O(n+q)
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
                parent[v2]=v1;
                size[v1]+=size[v2];
            } else {
                parent[v1]=v2;
                size[v2]+=size[v1];
            }
        }
        return;
    }

    private void sort(int[][] array) {
        Arrays.sort(array, new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return a[2] - b[2];
          }
        });
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int queriesCount=queries.length;
        int[] parent=new int[n];
        int[] size=new int[n];
        
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        
        boolean[] answer=new boolean[queriesCount];
        
        int[][] queriesWithIndex=new int[queriesCount][4];
        for (int i = 0; i < queriesCount; ++i) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        
        Arrays.sort(edgeList, (a,b)->a[2]-b[2]);
        // Sort all queries in increasing order of the limit of edge allowed.
        Arrays.sort(queriesWithIndex, (a,b)->a[2]-b[2]);
         
        int edgesIndex = 0;
        
        // Iterate on each query one by one.
        for (int queryIndex = 0; queryIndex < queriesCount; queryIndex++) {
            int p = queriesWithIndex[queryIndex][0];
            int q = queriesWithIndex[queryIndex][1];
            int limit = queriesWithIndex[queryIndex][2];
            int queryOriginalIndex = queriesWithIndex[queryIndex][3];
            
            // We can attach all edges which satisfy the limit given by the query.
            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < limit) {
                int node1 = edgeList[edgesIndex][0];
                int node2 = edgeList[edgesIndex][1];
                union(node1, node2, parent, size);
                edgesIndex += 1;
            }
            
            // If both nodes belong to the same component, it means we can reach them. 
            answer[queryOriginalIndex] = find(p, parent)==find(q, parent);
        }
        return answer;
    }
}

class distanceLimitedPathsExist{
    public static void main(String[] args) {
        int n=3;
        int[][] edgeList={{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] queries={{0,1,2},{0,2,5}};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.distanceLimitedPathsExist(n, edgeList, queries)));
    }
}
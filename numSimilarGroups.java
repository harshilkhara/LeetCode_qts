import java.util.*;
// Approach 1- DSU
class Solution { // TC O(n^2 . m) SC O(n)
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
    
    public boolean isSimilar(String a, String b){
        int diff=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff==0 || diff==2;
    }
    
    
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        int count=n;
        int[] parent=new int[n];
        int[] size=new int[n];
        
        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j]) && find(i, parent)!=find(j, parent)){
                    count--;
                    union(i , j, parent, size);
                }
            }
        }
        
        return count;
    }
}

// Approach 2- BFS
class Solution1{ // TC O(n^2 . m) SC O(n^2)
    public void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            node=queue.poll();

            if(!adj.containsKey(node)) continue;

            for(int neighbor: adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public boolean isSimilar(String a, String b){
        int diff=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff==0 || diff==2;
    }

    public int numSimilarGroups(String[] strs){
        int n=strs.length;
        Map<Integer, List<Integer>> adj=new HashMap<>();
        int count=0;
 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    adj.computeIfAbsent(i, v-> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, v-> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }
}

// Approach 3- DFS
class Solution2{ // TC O(n^2 . m) SC O(n^2)
    public void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited){
        visited[node]=true;
        if(!adj.containsKey(node)) return;
        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                visited[neighbor]=true;
                dfs(neighbor, adj, visited);
            }
        }
    }

    public boolean isSimilar(String a, String b){
        int diff=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff==0 || diff==2;
    }

    public int numSimilarGroups(String[] strs){
        int n=strs.length;
        Map<Integer, List<Integer>> adj=new HashMap<>();
        int count=0;
 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    adj.computeIfAbsent(i, v-> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, v-> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }
}

class numSimilarGroups{
    public static void main(String[] args) {
        String[] strs={"tars","rats","arts","star"};
        Solution s= new Solution();
        System.out.println(s.numSimilarGroups(strs));
        Solution1 s1= new Solution1();
        System.out.println(s1.numSimilarGroups(strs));
        Solution2 s2= new Solution2();
        System.out.println(s2.numSimilarGroups(strs));

    }
}


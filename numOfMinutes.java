import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(n) SC O(1)
    int maxTime=Integer.MIN_VALUE;
    
    public void dfs(Map<Integer, List<Integer>> adj, int node, int[] informTime, int time){
        this.maxTime=Math.max(maxTime, time);
        if (!adj.containsKey(node)) return;
        for(int currNode: adj.get(node)){
            dfs(adj, currNode, informTime, time+informTime[node]);
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(manager[i]!=-1){
                adj.computeIfAbsent(manager[i], v->new ArrayList<Integer>()).add(i);
            }
        }
        
        dfs(adj, headID, informTime, 0);
        return maxTime;
    }
}

class numOfMinutes{
    public static void main(String[] args) {
        int n=6;
        int headID=2;
        int[] manager={2,2,-1,2,2,2};
        int[] informTime={0,0,1,0,0,0};
        Solution s= new Solution();
        System.out.println(s.numOfMinutes(n, headID, manager, informTime));
    }
}
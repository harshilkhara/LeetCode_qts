import java.util.*;
// Approach 1- DFS 
class Solution{ // TC O(n^2) SC O(n)
    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}

// Approach 2- BFS 
class Solution1{ // TC O(n^2) SC O(n)
    public void bfs(int node, int[][] isConnected, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                bfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}

// Approach 3- Union-Find 
class Solution2{ // TC O(n^2) SC O(n)
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        UnionFind uf=new UnionFind(n);
        int answer=n;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && uf.find(i)!=uf.find(j)){
                    answer--;
                    uf.union(i,j);
                }
            }
        }
        return answer;
    }
}

class findCircleNum{
    public static void main(String[] args) {
        int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
        Solution s= new Solution();
        System.out.println(s.findCircleNum(isConnected));
        Solution1 s1= new Solution1();
        System.out.println(s1.findCircleNum(isConnected));
        Solution2 s2= new Solution2();
        System.out.println(s2.findCircleNum(isConnected));
    }
}


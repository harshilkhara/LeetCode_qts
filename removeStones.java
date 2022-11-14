import java.util.*;
// Very similar to countComponents.java and numIslands.java & .py 
// Approach 1- DFS 
class Solution { // TC O(N^2 + E) SC O(N+E)
    // Return true if stone a and b shares row or column
    boolean shareSameRowOrColumn(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }
    
    void dfs(int[][] stones, List<Integer>[] adj, int[] visited, int src) {
        // Mark the stone as visited
        visited[src] = 1;
        
        // Iterate over the adjacent, and iterate over it if not visited yet
        for (int adjacent : adj[src]) {
            if (visited[adjacent] == 0) {
                dfs(stones, adj, visited, adjacent);
            }
        }
    }
    
    int removeStones(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = new ArrayList[stones.length]; 
        for (int i = 0; i < stones.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        // Array to mark visited stones
        int[] visited = new int[stones.length];
        // Counter for connected components
        int componentCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (visited[i] == 0) {
                // If the stone is not visited yet,
                // Start the DFS and increment the counter
                componentCount++;
                dfs(stones, adj, visited, i);
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
}

// Approach 2- Disjoint sets union (DSU) [union-find]
class Solution1{ // TC O(N^2. alpha(N)) SC O(N)
    // Return true if stone a and b shares row or column
    boolean shareSameRowOrColumn(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }
    
    // Returns the representative of vertex x
    int find(int[] rep, int x) {
        if (x == rep[x]) {
            return x;
        }
        // Uses Path compression
        return rep[x] = find(rep, rep[x]);
    }
    
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] rep, int [] size, int x, int y) {
        x = find(rep, x);
        y = find(rep, y);
        
        if (x == y) {
            return 0;
        }
        
        if (size[x] > size[y]) {
            rep[y] = x;
            size[x] += size[y];
        } else {
            rep[x] = y;
            size[y] += size[x];
        }
        
        return 1;
    }
    
    public int removeStones(int[][] stones) {
        int[] rep = new int[stones.length];
        int[] size = new int[stones.length];
        // Initialize rep to itself and size as 1
        for (int i = 0; i < stones.length; i++) {
            rep[i] = i;
            size[i] = 1;
        }
        
        int componentCount = stones.length;
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    // Decrement the componenets if union invloved merging
                    componentCount -= performUnion(rep, size, i, j);
                }
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
}

// Approach 3- DFS (Optimized) 
class Solution2{ // TC O(K) SC O(K)
    // Constant to map y-coordinates of stones
    final int K = 10001;
    void dfs(int[][] stones, List<Integer>[] adj, int[] visited, int src) {
        // Mark the stone as visited
        visited[src] = 1;
        
        // Iterate over the adjacent, and iterate over it if not visited yet
        for (int adjacent : adj[src]) {
            if (visited[adjacent] == 0) {
                dfs(stones, adj, visited, adjacent);
            }
        }
    }
    
    int removeStones(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = new ArrayList[2 * K + 1]; 
        for (int i = 0; i < 2 * K + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1] + K;
            adj[x].add(y);
            adj[y].add(x);
        }
        
        // Array to mark visited stones
        int[] visited = new int[2 * K + 1];
        // Counter for connected components
        int componentCount = 0;
        for (int i = 0; i < 2 * K + 1; i++) {
            if (visited[i] == 0 && adj[i].size() > 0) {
                // If the stone is not visited yet,
                // Start the DFS and increment the counter
                componentCount++;
                dfs(stones, adj, visited, i);
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
}

// Approach 4- Optimized Disjoint Sets union [union-find]
class Solution3{ // TC O(N. alpha(K) + K) SC O(K)
    final int K = 10001;
    // Returns the representative of vertex x
    int find(int[] rep, int x) {
        if (x == rep[x]) {
            return x;
        }
        return rep[x] = find(rep, rep[x]);
    }
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] rep, int [] size, int x, int y) {
        x = find(rep, x);
        y = find(rep, y);
        
        if (x == y) {
            return 0;
        }
        
        if (size[x] > size[y]) {
            rep[y] = x;
            size[x] += size[y];
        } else {
            rep[x] = y;
            size[y] += size[x];
        }
        
        return 1;
    }
    
    public int removeStones(int[][] stones) {
        int[] rep = new int[2 * K + 1];
        int[] size = new int[2 * K + 1];
        // Initialize rep to itself and size as 1
        for (int i = 0; i < 2 * K + 1; i++) {
            rep[i] = i;
            size[i] = 1;
        }
        
        int componentCount = 0;
        HashMap <Integer, Integer> marked = new HashMap<>();
        for (int[] stone : stones) {
            if (!marked.containsKey(stone[0])) {
                componentCount++;
            }
            
            if (!marked.containsKey(stone[1] + K)) {
                componentCount++;
            }
            
            marked.put(stone[0], 1);
            marked.put(stone[1] + K, 1);
        }

        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1] + K;
            // Decrement the componenets if union invloved merging
            componentCount -= performUnion(rep, size, x, y);
        }
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
}

class removeStones {
    public static void main(String[] args) {
        int[][] stones={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        Solution s= new Solution();
        System.out.println(s.removeStones(stones));
        Solution1 s1= new Solution1();
        System.out.println(s1.removeStones(stones));
        Solution2 s2= new Solution2();
        System.out.println(s2.removeStones(stones));
        Solution3 s3= new Solution3();
        System.out.println(s3.removeStones(stones));
    }
}
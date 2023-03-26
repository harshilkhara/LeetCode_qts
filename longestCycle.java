import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(n) SC O(n)
    int answer = -1;

    public void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visit) {
        visit[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visit[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visit);
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        return answer;
    }
}

// Approach 2- Topological sort [using Kahn's algorithm]
class Solution1{ // TC O(n) SC O(n)
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        int[] indegree = new int[n];

        // Count indegree of each node.
        for (int edge : edges) {
            if (edge != -1) {
                indegree[edge]++;
            }
        }

        // Kahn's algorithm starts.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            visit[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        // Kahn's algorithm ends.

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int neighbor = edges[i];
                int count = 1;
                visit[i] = true;
                // Iterate in the cycle.
                while (neighbor != i) {
                    visit[neighbor] = true;
                    count++;
                    neighbor = edges[neighbor];
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}

class longestCycle{
    public static void main(String[] args) {
        int[] edges={3,3,4,2,3};
        Solution s= new Solution();
        System.out.println(s.longestCycle(edges));
        Solution1 s1= new Solution1();
        System.out.println(s1.longestCycle(edges));
    }
}
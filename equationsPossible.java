import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(max(N,size of alphabet set of variables))-> TC O(N)
                // SC  O(max(N,size of alphabet set of variables))-> SC O(N)
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            graph[i] = new ArrayList<>();

        for (String eqn : equations) {
            if (eqn.charAt(1) == '=') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }

        int[] color = new int[26];
        Arrays.fill(color, -1);

        for (int i = 0; i < 26; i++) {
            if (color[i] == -1) {
                dfs(i, i, color, graph);
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (color[x] == color[y])
                    return false;
            }
        }

        return true;
    }

    // mark the color of `node` as `c`
    private static void dfs(int node, int c, int[] color, List<Integer>[] graph) {
        if (color[node] == -1) {
            color[node] = c;
            for (int nei : graph[node])
                dfs(nei, c, color, graph);
        }
    }
}

// Approach 2- Union-Find 
class Solution1{ // TC O(n log (Size of alphabet)) SC O(1)
    public boolean equationsPossible(String[] equations) {
        int root[] = new int[26];
        for (int i = 0; i < 26; i++) {
            root[i] = i;
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '=') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                union(root, x, y);
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (find(root, x) == find(root, y))
                    return false;
            }
        }

        return true;
    }

    private static int find(int[] root, int x) {
        if (root[x] != x)
            root[x] = find(root, root[x]);
        return root[x];
    }

    private static void union(int[] root, int x, int y) {
        x = find(root, x);
        y = find(root, y);
        if (x != y)
            root[x] = y;
    }
}

class equationsPossible{
    public static void main(String[] args) {
        String[] equations= {"a==b","b!=a"};
        Solution s= new Solution();
        System.out.println(s.equationsPossible(equations));
        Solution1 s1= new Solution1();
        System.out.println(s1.equationsPossible(equations));
    }
}
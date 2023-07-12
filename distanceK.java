import java.util.*;
// Approach 1- DFS on equivalent graph
class Solution { // TC O(n) SC O(n)
    List<Integer> answer=new ArrayList<>();
    Set<Integer> visited=new HashSet<>();
    Map<Integer, List<Integer>> map=new HashMap<>();
        
    public List<Integer> distanceK(Node root, Node target, int k) {
        
        buildGraph(root, null);
        
        visited.add(target.val);
        
        dfs(target.val, 0, k);
        return answer;
    }
    
    public void buildGraph(Node currNode, Node parent){
        if(currNode!=null & parent!=null){
            map.computeIfAbsent(currNode.val, k-> new ArrayList<>()).add(parent.val);
            map.computeIfAbsent(parent.val, k-> new ArrayList<>()).add(currNode.val);
        }
        
        if (currNode.left!=null){
            buildGraph(currNode.left, currNode);
        }
        
        if (currNode.right!=null){
            buildGraph(currNode.right, currNode);
        }
        return;
    }
    
    public void dfs(int curr, int distance, int k){
        if (distance==k){
            answer.add(curr);
            return;
        }
        
        for(int neighbor: map.getOrDefault(curr, new ArrayList<>())){
            
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(neighbor, distance+1, k);
            }
        }
        return;
    }
}

// Approach 2- BFS on equivalent graph
class Solution1{ // TC O(n) SC O(n)
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfsBuild(root, null, graph);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        // Add the target node to the queue with a distance of 0
        queue.add(new int[]{target.val, 0});
        visited.add(target.val);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], distance = cur[1];
            
            // If the current node is at distance k from target,
            // add it to the answer list and continue to the next node.
            if (distance == k) {
                answer.add(node);
                continue;
            }
            
            // Add all unvisited neighbors of the current node to the queue.
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        
        return answer;
    }
    
    // Recursively build the undirected graph from the given binary tree.
    private void dfsBuild(Node cur, Node parent, Map<Integer, List<Integer>> graph) {
        if (cur != null && parent != null) {
            int curVal = cur.val, parentVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parentVal, new ArrayList<>());
            graph.get(curVal).add(parentVal);
            graph.get(parentVal).add(curVal);
        }
        
        if (cur != null && cur.left != null) {
            dfsBuild(cur.left, cur, graph);
        }
        
        if (cur != null && cur.right != null) {
            dfsBuild(cur.right, cur, graph);
        }
    }
}

class distanceK{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(3);
        bt.root.left=new Node(5);
        bt.root.right=new Node(1);
        bt.root.left.left=new Node(6);
        bt.root.left.right=new Node(2);
        bt.root.left.right.left=new Node(7);
        bt.root.left.right.right=new Node(4);
        bt.root.right.left=new Node(0);
        bt.root.right.right=new Node(8);
        Solution s= new Solution();
        int k=2;
        //Node target=bt.root.left;
        Node target=new Node(5);
        System.out.println(s.distanceK(bt.root, target, 2));
        Solution1 s1= new Solution1();
        System.out.println(s1.distanceK(bt.root, target, 2));

    }
}
import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Nary{
    Node root;
}

// Approach 1- BFS [using queue]
class Solution { // TC O(N) SC O(N)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer= new ArrayList<>();
        if(root==null) return answer;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level= new ArrayList<>();
            int size= queue.size();
            for(int i=0; i<size; i++){
                Node curr= queue.poll();
                level.add(curr.val);
                queue.addAll(curr.children);
            }
            answer.add(level);
        }
        return answer;
    }
}

// Approach 2- BFS [simplified]
// Code is rightSideView- style
class Solution1{ // TC O(N) SC O(N)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }
        return result;
    }
}

// Approach 3- Recursive (DFS) [using call-stack]
class Solution2{ // TC O(N) SC O(N)
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}

class levelOrderNary{
    public static void main(String[] args) {
        Nary nary= new Nary();
        nary.root= new Node(1);
        nary.root.children=new Node(null);

        
    }
}
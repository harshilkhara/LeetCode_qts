import java.util.*;

class Pair{
    int start, end;
    Pair(int start, int end){
        this.start=start;
        this.end=end;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(){
        this.val=0;
    }

    Node(int val){
        this.val=val;
    }

    Node(int val, Node left, Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

// Approach 1- Top down DP
class Solution {
    Map<Pair, List<Node>> memo=new HashMap<>();

    public List<Node> allPossibleBST(int start, int end){
        List<Node> res=new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }

        if(memo.containsKey(new Pair(start, end))) return memo.get(new Pair(start, end));

        for(int i=start; i<=end; i++){
            List<Node> left=allPossibleBST(start, i-1);
            List<Node> right=allPossibleBST(i+1, end);

            for(Node l: left){
                for(Node r: right){
                    Node root = new Node(i, l, r);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair(start, end), res);
        return res;
    }

    public List<Node> generateTrees(int n) {
        return allPossibleBST(1, n);
    }
}

// Approach 2- Bottom up DP 
class Solution1{
public List<Node> generateTrees(int n) {
        List<List<List<Node>>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            List<List<Node>> innerList = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j++) {
                innerList.add(new ArrayList<>());
            }
            dp.add(innerList);
        }

        for (int i = 1; i <= n; i++) {
            dp.get(i).get(i).add(new Node(i));
        }

        for (int numberOfNodes = 2; numberOfNodes <= n; numberOfNodes++) {
            for (int start = 1; start <= n - numberOfNodes + 1; start++) {
                int end = start + numberOfNodes - 1;
                for (int i = start; i <= end; i++) {
                    List<Node> leftSubtrees =
                        (i != start) ? dp.get(start).get(i - 1) : new ArrayList<>();
                    if (leftSubtrees.isEmpty()) {
                        leftSubtrees.add(null);
                    }
                    List<Node> rightSubtrees =
                        (i != end) ? dp.get(i + 1).get(end) : new ArrayList<>();
                    if (rightSubtrees.isEmpty()) {
                        rightSubtrees.add(null);
                    }

                    for (Node left : leftSubtrees) {
                        for (Node right : rightSubtrees) {
                            Node root = new Node(i, left, right);
                            dp.get(start).get(end).add(root);
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }
}

// Approach 3- Space optimized DP 
class Solution2{
    public List<Node> generateTrees(int n) {
        List<List<Node>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(null);

        for (int numberOfNodes = 1; numberOfNodes <= n; numberOfNodes++) {
            for (int i = 1; i <= numberOfNodes; i++) {
                int j = numberOfNodes - i;
                for (Node left : dp.get(i - 1)) {
                    for (Node right : dp.get(j)) {
                        Node root = new Node(i, left, clone(right, i));
                        dp.get(numberOfNodes).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }

    private Node clone(Node node, int offset) {
        if (node == null) {
            return null;
        }
        Node clonedNode = new Node(node.val + offset);
        clonedNode.left = clone(node.left, offset);
        clonedNode.right = clone(node.right, offset);
        return clonedNode;
    }
}

class allPossibleBST{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        int n=3;
        Solution s=new Solution();
        List<Node> res=s.generateTrees(n);
        for(Node r: res){
            bt.inorder(r);
        }

        System.out.println("");

        Solution1 s1=new Solution1();
        List<Node> res1=s.generateTrees(n);
        for(Node r: res1){
            bt.inorder(r);
        }

        System.out.println("");

        Solution2 s2=new Solution2();
        List<Node> res2=s.generateTrees(n);
        for(Node r: res2){
            bt.inorder(r);
        }
    }
}
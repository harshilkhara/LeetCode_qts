import java.util.*;

class Node{
    int val;
    Node left;
    Node right;

    Node(int x){
        val=x;
    }
}
class BinaryTree{
    Node root;
}

class Pair{
  Node node;
  Integer column;

  Pair(Node root, Integer column){
    node= root;
    this.column=column;
  }
}

// Approach 1- BFS [using queue]
class Solution { // TC O(n log n) SC O(n)
  public List<List<Integer>> verticalOrder(Node root) {
    List<List<Integer>> output = new ArrayList<>();
    if (root == null) {
      return output;
    }

    Map<Integer, ArrayList> columnTable = new HashMap<>();
    Queue<Pair> queue = new ArrayDeque<>();
    int column = 0;
    queue.offer(new Pair(root, column));

    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      root = p.node;
      column = p.column;

      if (root != null) {
        if (!columnTable.containsKey(column)) {
          columnTable.put(column, new ArrayList<Integer>());
        }
        columnTable.get(column).add(root.val);

        queue.offer(new Pair(root.left, column - 1));
        queue.offer(new Pair(root.right, column + 1));
      }
    }

    List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
    Collections.sort(sortedKeys);
    for(int k : sortedKeys) {
      output.add(columnTable.get(k));
    }

    return output;
  }
}

// Approach 2- BFS without sorting [using queue]
class Solution1{ // TC O(n) SC O(n)
  public List<List<Integer>> verticalOrder(Node root) {
    List<List<Integer>> output = new ArrayList<>();
    if (root == null) {
      return output;
    }

    Map<Integer, ArrayList> columnTable = new HashMap<>();
    // Pair of node and its column offset
    Queue<Pair> queue = new ArrayDeque<>();
    int column = 0;
    queue.offer(new Pair(root, column));

    int minColumn = 0, maxColumn = 0;

    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      root = p.node;
      column = p.column;

      if (root != null) {
        if (!columnTable.containsKey(column)) {
          columnTable.put(column, new ArrayList<Integer>());
        }
        columnTable.get(column).add(root.val);
        minColumn = Math.min(minColumn, column);
        maxColumn = Math.max(maxColumn, column);

        queue.offer(new Pair(root.left, column - 1));
        queue.offer(new Pair(root.right, column + 1));
      }
    }

    for(int i = minColumn; i < maxColumn + 1; ++i) {
      output.add(columnTable.get(i));
    }

    return output;
  }
}

class verticalOrder{
  public static void main(String[] args) {
    BinaryTree bt= new BinaryTree();
    bt.root=new Node(3);
    bt.root.left=new Node(9);
    bt.root.right=new Node(20);
    bt.root.right.left=new Node(15);
    bt.root.right.right=new Node(7);
    Solution s = new Solution();
    Solution1 s1= new Solution1();
    System.out.println(s.verticalOrder(bt.root));
    System.out.println(s1.verticalOrder(bt.root));
  }

}

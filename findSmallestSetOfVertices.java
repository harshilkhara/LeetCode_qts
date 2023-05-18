import java.util.*;
// Approach 1- Counting indegrees of a node
class Solution { // TC O(n) SC O(n)
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    // List to signify if the vertex has an incoming edge or not.
    boolean[] isIncomingEdgeExists = new boolean[n];
    for (List<Integer> edge : edges) {
      isIncomingEdgeExists[edge.get(1)] = true;
    }

    List<Integer> requiredNodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      // Store all the nodes that don't have an incoming edge.
      if (!isIncomingEdgeExists[i]) {
        requiredNodes.add(i);
      }
    }

    return requiredNodes;
  }
}

class findSmallestSetOfVertices{
  public static void main(String[] args) {
    List<List<Integer>> edges=new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(0,1)),
      new ArrayList<>(Arrays.asList(0,2)),
      new ArrayList<>(Arrays.asList(2,5)),
      new ArrayList<>(Arrays.asList(3,4)),
      new ArrayList<>(Arrays.asList(4,2))
    ));
    int n=6;
    Solution s= new Solution();
    System.out.println(edges);
    System.out.println(s.findSmallestSetOfVertices(n, edges));
  }
}
import java.util.*;
// Approach 1- Recursion
class Solution { // TC O(n log n)  SC O(log n)

  private ListNode findMiddleElement(ListNode head) {

    // The pointer used to disconnect the left half from the mid node.
    ListNode prevPtr = null;
    ListNode slowPtr = head;
    ListNode fastPtr = head;

    // Iterate until fastPr doesn't reach the end of the linked list.
    while (fastPtr != null && fastPtr.next != null) {
      prevPtr = slowPtr;
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    // Handling the case when slowPtr was equal to head.
    if (prevPtr != null) {
      prevPtr.next = null;
    }

    return slowPtr;
  }

  public Node sortedListToBST(ListNode head) {

    // If the head doesn't exist, then the linked list is empty
    if (head == null) {
      return null;
    }

    // Find the middle element for the list.
    ListNode mid = this.findMiddleElement(head);

    // The mid becomes the root of the BST.
    Node node = new Node(mid.val);

    // Base case when there is just one element in the linked list
    if (head == mid) {
      return node;
    }

    // Recursively form balanced BSTs using the left and right halves of the original list.
    node.left = this.sortedListToBST(head);
    node.right = this.sortedListToBST(mid.next);
    return node;
  }
}

// Approach 2- Recursion + Conversion Array
class Solution { // TC O(N)  SC O(N)

  private List<Integer> values;

  public Solution() {
    this.values = new ArrayList<Integer>();
  }

  private void mapListToValues(ListNode head) {
    while (head != null) {
      this.values.add(head.val);
      head = head.next;
    }
  }

  private TreeNode convertListToBST(int left, int right) {
    // Invalid case
    if (left > right) {
      return null;
    }

    // Middle element forms the root.
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(this.values.get(mid));

    // Base case for when there is only one element left in the array
    if (left == right) {
      return node;
    }

    // Recursively form BST on the two halves
    node.left = convertListToBST(left, mid - 1);
    node.right = convertListToBST(mid + 1, right);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head) {

    // Form an array out of the given linked list and then
    // use the array to form the BST.
    this.mapListToValues(head);

    // Convert the array to
    return convertListToBST(0, this.values.size() - 1);
  }
}

// Approach 3- Inorder Simulation
class Solution2{ // TC O(N)  SC O(log n)
  private ListNode head;
  private int findSize(ListNode head) {
    ListNode ptr = head;
    int c = 0;
    while (ptr != null) {
      ptr = ptr.next;  
      c += 1;
    }
    return c;
  }

  private TreeNode convertListToBST(int l, int r) {
    // Invalid case
    if (l > r) {
      return null;
    }

    int mid = (l + r) / 2;

    // First step of simulated inorder traversal. Recursively form
    // the left half
    TreeNode left = this.convertListToBST(l, mid - 1);

    // Once left half is traversed, process the current node
    TreeNode node = new TreeNode(this.head.val);
    node.left = left;

    // Maintain the invariance mentioned in the algorithm
    this.head = this.head.next;

    // Recurse on the right hand side and form BST out of them
    node.right = this.convertListToBST(mid + 1, r);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head) {
    // Get the size of the linked list first
    int size = this.findSize(head);

    this.head = head;

    // Form the BST now that we know the size
    return convertListToBST(0, size - 1);
  }
}

class sortedListToBST{
  public static void main(String[] args) {
    int[] keys= {1};

  }
}
// Approach 1- Two Pointers (Idea very similar to iterative merge two sorted lists)
class Solution {
    public Node partition(Node head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        Node before_head = new Node(0);
        Node before = before_head;
        Node after_head = new Node(0);
        Node after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.data < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
}

class partitionList{
    public static void main(String[] args) {
        int [] keys={1,4,3,2,5,2}; 
        int x=3; 
        LinkedList ll= new LinkedList();
        Solution s= new Solution(); 
        LinkedList list= ll.constructLinkedList(keys);
        ll.printListHead(list.head);
        Node result= s.partition(list.head,x);
        ll.printListHead(result);
    }
}
// Note- Here the Linked List is sorted 
class Solution { // TC O(n) SC O(1)
    public Node deleteDuplicatesLinkedListII(Node head) {
        // sentinel
        Node sentinel = new Node(0);
        sentinel.next=head;

        // predecessor = the last node 
        // before the sublist of duplicates
        Node pred = sentinel;
        
        while (head != null) {
            // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.data == head.next.data) {
                // move till the end of duplicates sublist
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;    
                }
                // skip all duplicates
                pred.next = head.next;     
            // otherwise, move predecessor
            } else {
                pred = pred.next;    
            }

            // move forward
            head = head.next;    
        }  
        return sentinel.next;
    }
}

class deleteDuplicatesLinkedListII{
    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        int[] keys={1,2,3,3,4,4,5};
        LinkedList list= ll.constructLinkedList(keys);
        Solution s= new Solution();
        Node result=s.deleteDuplicatesLinkedListII(list.head);
        ll.printListHead(result);
    }
}
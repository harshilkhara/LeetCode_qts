// Note- Here the Linked List is sorted 
class Solution { // TC O(n) SC O(1)
    public Node deleteDuplicatesLinkedList(Node head) {
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            } else {
                curr=curr.next;
            }
        }
        return head;
    }
}

class deleteDuplicatesLinkedList{
    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        int[] keys={1,2,3,3,4,4,5};
        LinkedList list= ll.constructLinkedList(keys);
        Solution s= new Solution();
        Node result=s.deleteDuplicatesLinkedList(list.head);
        ll.printListHead(result);
    }
}
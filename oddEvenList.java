import java.util.*;
// Approach 1- Intuitive 
class Solution{ // TC O(n) SC O(1)
	public Node oddEvenList(Node head){
		Node oddNode= head;
		Node evenNode= head.next;
		Node evenHead=evenNode;
		while(evenNode!=null && evenNode.next!=null){
			oddNode.next=oddNode.next.next;
			oddNode=oddNode.next;
			evenNode.next=evenNode.next.next;
			evenNode=evenNode.next;
		}
		oddNode.next=evenHead;
		return head;
	}
}
// Alternate code but same approach 
// Leetcode's code 
class Solution1{ // TC O(n) SC O(1)
    public Node oddEvenList(Node head) {
        if (head == null) return null;
        Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

class oddEvenList{
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		int[] keys={1,2,3,4,5};
		int[] keys1={1,2,3,4,5,6};
		LinkedList list= ll.constructLinkedList(keys);
		Solution s= new Solution();
		Node result=s.oddEvenList(list.head);
		ll.printListHead(result);

		LinkedList list1= ll.constructLinkedList(keys1);
		Solution1 s1= new Solution1();
		Node result1=s1.oddEvenList(list1.head);
		ll.printListHead(result1);
	}
}
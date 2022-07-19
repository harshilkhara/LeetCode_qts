// Approach 1- Iterative approach 
class Solution{ // TC O(n) SC O(1)
	public Node reverseList(Node head){
		Node prev=null;
		Node currNode=head;
		while(currNode!=null){
			Node nextNode= currNode.next;
			currNode.next=prev;
			prev= currNode;
			currNode=nextNode;
		}

		return prev; 
	}
}

// Approach 2- Recursive approach 

class Solution1{ // TC O(n) SC O(n)
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class reverseList{ 
	public static void main(String[] args) {
		int [] keys={1,2,3,4,5};
		int [] keys1={5,4,3,2,1};
		LinkedList ll = new LinkedList();
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        LinkedList list= ll.constructLinkedList(keys);
        LinkedList list1= ll.constructLinkedList(keys1);
        ll.printList(list);
        ll.printList(list1);
        Node result=s.reverseList(list.head);
        System.out.println("Reverse of list by Approach 1 is- ");
        ll.printListHead(result);
        Node result1=s1.reverseList(list1.head);
        System.out.println("Reverse of list by Approach 2 is- ");
        ll.printListHead(result1);

	}
}
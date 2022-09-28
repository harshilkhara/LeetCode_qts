class Solution{
	public Node removeNthFromEnd(Node head, int n){
		Node dummy= new Node(0);
		dummy.next=head; 
		Node first= head;
		int length=0; 
		while(first!=null){ // we find out the length by sending first to last 
			length++;
			first=first.next;
		}
		//now we know the length 
		// time to apply foruma - (L-n+1)
		length-=n;  // we achieve (L-n) from this 
		first=dummy; // we achieve the +1 from this 
		while(length>0){
			length--;
			first=first.next;
		}
		first.next=first.next.next;
		return dummy.next;
	}
}

class removeNthFromEnd{
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		int[] keys= {1,2,3,4,5};
		int n=2; 
		LinkedList list= ll.constructLinkedList(keys);
		Solution s= new Solution();
		Node result= s.removeNthFromEnd(list.head,n);
		ll.printListHead(result);
	}
}
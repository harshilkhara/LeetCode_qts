// Approach 1- Sentinel Node 
// Very similar to removeDuplicatesFromLinkedList.java
class Solution{
	public Node removeElements(Node head, int val){ // TC O(n) SC O(1)
		Node sentinel = new Node(0);
		sentinel.next=head;
		Node curr=head, prev=sentinel;
		while(curr!=null){
			if(curr.data==val){
				prev.next=curr.next;
			}
			prev=curr;
			curr=curr.next;
		}
		return sentinel.next;
	}
}

class removeElementsFromLinkedList{
	public static void main(String[] args) {
		LinkedList ll =new LinkedList();
		int[] keys={1,2,6,3,4,5,6};
		LinkedList list= ll.constructLinkedList(keys);
		ll.printList(list);
		Solution s= new Solution();
		int val=6;
		Node result= s.removeElements(list.head,val);
		ll.printListHead(result);
	}
}
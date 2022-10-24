class Node{

	Node next;
	int data;

	Node(int x){
		data=x;
	}
}

class Solution{
	public void deleteNode(Node node){
		node.data=node.next.data;
		node.next=node.next.next;
	}
}

class deleteNode{
	public static void main(String[] args) {
		LinkedList ll =new LinkedList();
		int[] keys={4,5,1,9}; 
		LinkedList list= ll.constructLinkedList(keys); 
		ll.printListHead(list.head);
		Node delete= new Node(5);
		Solution s= new Solution();
		s.deleteNode(delete);
		ll.printListHead(list.head);
	}
}
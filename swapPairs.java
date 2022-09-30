// Approach 1- Recursive 
class Solution{ // TC O(n) SC O(n)
	public Node swapPairs(Node head){

		// If the list has no node or has only one node left.
		if (head==null || head.next==null)
			return head;

		// Nodes to be swapped
		Node firstNode=head; 
		Node secondNode=head.next; 

		// Swapping
		firstNode.next=swapPairs(secondNode.next);
		secondNode.next=firstNode;

		// Now the head is the second node
		return secondNode;
	}
}

// Approach 2- Iterative
class Solution1{ // TC O(n) SC O(1)
    public Node swapPairs(Node head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        Node dummy = new Node(-1);
        dummy.next = head;

        Node prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            Node firstNode = head;
            Node secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
class swapPairs{
	public static void main(String[] args) {
		int[] keys={1,2,3,4};
		LinkedList ll =new LinkedList();
		LinkedList list= ll.constructLinkedList(keys);
		Solution s= new Solution();
		Node result= s.swapPairs(list.head);
		ll.printListHead(result);
		Solution1 s1= new Solution1();
		Node result1= s1.swapPairs(result);
		ll.printListHead(result1);
	}
}
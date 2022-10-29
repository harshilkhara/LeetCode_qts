import java.util.*;
// Asked in Goldman Sachs 
// Approach 1- Set to keep track of duplicates 
class Solution{
	public Node removeDuplicates(Node head){ // TC O(n) SC O(n)
		HashSet<Integer> set= new HashSet<>(); 
		Node curr=head, prev=null;
		while(curr!=null){
			int currval=curr.data;
			if(set.contains(currval)){
				prev.next=curr.next;
			} else {
				set.add(currval);
				prev=curr;
			}
			curr=curr.next; 
		}
		return head;
	}
}

class removeDuplicatesFromLinkedList{
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		int[] keys={2,4,3,6,4,8};
		LinkedList list= ll.constructLinkedList(keys);
		ll.printListHead(list.head);
		Solution s= new Solution();
		Node result=s.removeDuplicates(list.head);
		ll.printListHead(result);
	}
}
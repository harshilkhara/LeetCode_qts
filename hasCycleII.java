import java.util.*;
class Solution{ // TC O(n) SC O(n)
    public Node detectCycle(Node head) {
        Set<Node> visited = new HashSet<Node>();
        Node node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}

class Solution1{ // TC O(n) SC O(1)
    private Node getIntersect(Node head) {
        Node tortoise = head;
        Node hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
}

    public Node detectCycle(Node head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        Node intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        Node ptr1 = head;
        Node ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}

class hasCycleII{
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		int[] keys={3,2,0,-4};
		LinkedList list=ll.constructLinkedList(keys);
		ll.printListHead(list.head);
		// connectiong -4 to 2 
		Node node=list.head;
		while (node.next!=null){
			node=node.next;
		}
		node.next=list.head.next;
		Solution s=new Solution();
		System.out.println(s.detectCycle(list.head).data);
		Solution1 s1=new Solution1();
		System.out.println(s1.detectCycle(list.head).data);
		//Node result=s.detectCycle(list.head);
		//ll.printListHead(result);
	}
}
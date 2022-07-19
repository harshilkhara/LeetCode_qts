// Approach 1- Hash Set 
import java.util.*;
class Solution { // TC O(n) SC O(n)
    public boolean hasCycle(Node head) {
        Set<Node> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}

// Approach 2- Floyd's Tortoise and Hare cycle finding algorithm
class Solution1{
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

// Same approach but code similar to middleNode.java 

class Solution2{ // TC O(N) SC O(1)
    public boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }
}

class hasCycle{
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        Solution s= new Solution();
        int [] keys={3,2,0,-4};
        int pos=1;
        LinkedList list=ll.constructLinkedList(keys);
        ll.setPos(list.head,pos);
        //ll.printList(list);
        System.out.println(s.hasCycle(list.head));
    }
}
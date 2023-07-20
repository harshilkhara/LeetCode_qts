import java.util.*;
// Approach 1- Using stacks
class Solution { // TC O(m+n) SC O(m+n)
    public Node addTwoNumbersLinkedList(Node l1, Node l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }
        
        int totalSum = 0, carry = 0;
        Node ans = new Node(-1);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) totalSum += s1.pop();
            if (!s2.empty()) totalSum += s2.pop();
            
            ans.data = totalSum % 10;
            carry = totalSum / 10;
            Node head = new Node(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }

        return carry == 0 ? ans.next: ans;
    }
}

// Approach 2- Reverse the given linked list
class Solution1{ // TC O(m+n) SC O(m+n)
    public Node reverseList(Node head) {
        Node prev = null, temp;
        while (head != null) {
            // Keep the next node
            temp = head.next;
            // Reverse the link
            head.next = prev;
            // Update the previous node and the current node.
            prev = head;
            head = temp;    
        }    
        return prev;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node r1 = reverseList(l1);
        Node r2 = reverseList(l2);
        
        int totalSum = 0, carry = 0;
        Node ans = new Node(-1);
        while (r1 != null || r2 != null) {
            if (r1 != null) totalSum += r1.data;
            if (r2 != null) totalSum += r2.data;
            
            ans.data = totalSum % 10;
            carry = totalSum / 10;
            Node head = new Node(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        return carry == 0 ? ans.next: ans;
    }
}

class addTwoNumbersLinkedList{
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        int[] keys1={7,2,4,3};
        int[] keys2={5,6,4};
        LinkedList list1=ll.constructLinkedList(keys1);
        LinkedList list2=ll.constructLinkedList(keys2);
        ll.printListHead(list1.head);
        ll.printListHead(list2.head);
        Solution s= new Solution();
        Node result=s.addTwoNumbersLinkedList(list1.head, list2.head);
        ll.printListHead(result);
        Solution1 s1= new Solution1();
        Node result1=s.addTwoNumbersLinkedList(list1.head, list2.head);
        ll.printListHead(result1);
    }
}
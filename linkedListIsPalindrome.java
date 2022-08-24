// Approach 1- Copy into Array List and then Use Two Pointer Technique
import java.util.*;
class Solution { // TC O(n) SC O(n)
    public boolean isPalindrome(Node head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        Node currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.data);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}

// Approach 2- Recursive 

class Solution1{ // TC O(n) SC O(n)

    private Node frontPointer;

    private boolean recursivelyCheck(Node currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.data != frontPointer.data) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(Node head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}

// Approach 3- Reverse Second Half in-place 

class Solution2{ // TC O(n) SC O(1)

    public boolean isPalindrome(Node head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        Node firstHalfEnd = endOfFirstHalf(head);
        Node secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        Node p1 = head;
        Node p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.data != p2.data) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private Node endOfFirstHalf(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


class linkedListIsPalindrome{
    public static void main(String[] args) {
        int [] keys = {1,2,2,1};
        LinkedList ll =new LinkedList();
        LinkedList list= ll.constructLinkedList(keys);
        ll.printListHead(list.head);
        Solution s = new Solution();
        System.out.println(s.isPalindrome(list.head));
        Solution1 s1 = new Solution1();
        System.out.println(s1.isPalindrome(list.head));
        Solution2 s2 = new Solution2();
        System.out.println(s2.isPalindrome(list.head));

    }
}
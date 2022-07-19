/*
Approach 1- Output to Array

Intuition and Algorithm

Put every node into an array A in order. Then the middle node is just A[A.length // 2], 
since we can retrieve each node by index.

We can initialize the array to be of length 100, as we're told in the problem description that 
the input contains between 1 and 100 nodes.
*/
class Solution { // TC O(N) SC O(N)
    public Node middleNode(Node head) {
        Node[] A = new Node[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public void printList(Node head){
        Node currNode= head; 
        while(currNode!=null){
            System.out.print(currNode.data + " ");
            currNode=currNode.next;
        }
        System.out.println(" ");
    }
}

/*

Approach 2- Slow & Faster Pointer (Runner Technique from ctci)

Intuition and Algorithm

When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast. 
When fast reaches the end of the list, slow must be in the middle.
*/
class Solution1{ // TC O(N) SC O(1)
    public Node middleNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class middleNode{
    public static void main(String[] args) {
        int [] keys= {1,2,3,4,5};
        LinkedList ll = new LinkedList();
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        LinkedList list= ll.constructLinkedList(keys);
        ll.printList(list);
        Node result=s.middleNode(list.head);
        System.out.println("Middle of the node by Approach 1 is- ");
        s.printList(result);
        Node result1=s1.middleNode(list.head);
        System.out.println("Middle of the node by Approach 2 is- ");
        s.printList(result1);

    }
}
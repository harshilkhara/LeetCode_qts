// Recursive Approach 
class Solution { // TC O(m+n) SC O(m+n)
    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1== null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else if (list1.data < list2.data) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

     // Method to print the LinkedList. 
    public static void printList(Node head) 
    { 
        Node currNode = head; 
     
        System.out.print("LinkedList: "); 
     
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
     
            // Go to next node 
            currNode = currNode.next; 
        }
    } 
}

// Iterative Approach 
class Solution1{ // TC O(m+n) SC O(1)
    public Node mergeTwoLists(Node list1, Node list2) {
        // maintain an unchanging reference to node ahead of the return node.
        Node prehead = new Node(-1);

        Node prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        // At least one of list1 and list2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = list1 == null ? list2 : list1;

        return prehead.next;

    }

      // Method to print the LinkedList. 
    public static void printList(Node head) 
    { 
        Node currNode = head; 
     
        System.out.print("LinkedList: "); 
     
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
     
            // Go to next node 
            currNode = currNode.next; 
        }
    }
}


class mergeTwoLists{
    public static void main(String[] args) {
        int [] keys1={1,2,4};
        int [] keys2={1,3,4};
        LinkedList ll= new LinkedList();
        LinkedList list1=ll.constructLinkedList(keys1);
        LinkedList list2=ll.constructLinkedList(keys2);
        ll.printList(list1);
        ll.printList(list2);
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        //Node result=s.mergeTwoLists(list1.head,list2.head);
        //s.printList(result);
        System.out.println(" ");
        Node result1=s1.mergeTwoLists(list1.head,list2.head);
        System.out.println(" ");
        s1.printList(result1);

    }
}
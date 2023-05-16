import java.util.*;
// Approach 1- Building an array and swapping
class Solution{ // TC O(n) SC O(n)
    public Node swapNodes(Node head, int k) {
        Node currNode=head;
        List<Integer> nodeList=new ArrayList<>();
        // building the array
        while(currNode!=null){
            nodeList.add(currNode.data);
            currNode=currNode.next;
        }
    
        // swapping 
        //[1,2,3,4,5]
        int n=nodeList.size();
        int a=nodeList.get(k-1);
        int temp=a;
        int b=nodeList.get(n-k);
        nodeList.set(k-1, b);
        nodeList.set(n-k, temp);
        
      
        // rebuilding linkedList
        Node node=new Node(-1);
        currNode=node;
        for(int data: nodeList){
            currNode.next=new Node(data);
            currNode=currNode.next;
        }
        return node.next;
    }
}

// Approach 2- Three pass 
class Solution1{ // TC O(n) SC O(1)
    public Node swapNodes(Node head, int k) {
        int listLength = 0;
        Node currentNode = head;
        // find the length of linked list
        while (currentNode != null) {
            listLength++;
            currentNode = currentNode.next;
        }
        // set the front node at kth node
        Node frontNode = head;
        for (int i = 1; i < k; i++) {
            frontNode = frontNode.next;
        }
        //set the end node at (listLength - k)th node
        Node endNode = head;
        for (int i = 1; i <= listLength - k; i++) {
            endNode = endNode.next;
        }
        // swap the dataues of front node and end node
        int temp = frontNode.data;
        frontNode.data = endNode.data;
        endNode.data = temp;
        return head;
    }
}

// Approach 3- Two Pass
class Solution2{ // TC O(n) SC O(1)
    public Node swapNodes(Node head, int k) {
        int listLength = 0;
        Node frontNode = null;
        Node endNode = null;
        Node currentNode = head;
        // find the length of list and set the front node
        while (currentNode != null) {
            listLength++;
            if (listLength == k) {
                frontNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        // set the end node at (listLength - k)th node
        endNode = head;
        for (int i = 1; i <= listLength - k; i++) {
            endNode = endNode.next;
        }
        // swap front node and end node dataues
        int temp = frontNode.data;
        frontNode.data = endNode.data;
        endNode.data = temp;
        return head;
    }
}

// Appraoch 4- One pass 
class Solution3{ // TC O(n) SC O(1)
    public Node swapNodes(Node head, int k) {
        int listLength = 0;
        Node frontNode = null;
        Node endNode = null;
        Node currentNode = head;
        // set the front node and end node in single pass
        while (currentNode != null) {
            listLength++;
            if (endNode != null)
                endNode = endNode.next;
            // check if we have reached kth node
            if (listLength == k) {
                frontNode = currentNode;
                endNode = head;
            }
            currentNode = currentNode.next;
        }
        // swap the dataues of front node and end node
        int temp = frontNode.data;
        frontNode.data = endNode.data;
        endNode.data = temp;
        return head;
    }
}

class swapNodes{
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        int[] keys={1,2,3,4,5};
        LinkedList list=ll.constructLinkedList(keys);
        Solution s=new Solution();
        Node result=s.swapNodes(list.head, 2);
        ll.printListHead(result);
        Solution1 s1=new Solution1();
        Node result1=s1.swapNodes(list.head, 2);
        ll.printListHead(result1);
        Solution2 s2=new Solution2();
        Node result2=s2.swapNodes(list.head, 2);
        ll.printListHead(result2);
        Solution3 s3=new Solution3();
        Node result3=s3.swapNodes(list.head, 2);
        ll.printListHead(result3);
    }
}
import java.util.*;
// Approach 1- Converting to arraylist
class Solution { // TC O(n) SC O(n)
    public int pairSum(Node head) {
        List<Integer> nodeList=new ArrayList<>();
        Node currNode=head;
        while(currNode!=null){
            nodeList.add(currNode.data);
            currNode=currNode.next;
        }
        
        int i=0, j=nodeList.size()-1;
        int maxSum=0;
        while(i<j){
            maxSum=Math.max(maxSum, nodeList.get(i)+nodeList.get(j));
            i++;
            j--;
        }
        return maxSum;
    }
}

// Approach 2- Converting to Stack
class Solution1{ // TC O(n) SC O(n)
    public int pairSum(Node head) {
        Stack<Integer> nodeStack=new Stack<>();
        Node currNode=head;
        while(currNode!=null){
            nodeStack.push(currNode.data);
            currNode=currNode.next;
        }
        
        int count=1, size=nodeStack.size();
        int maxSum=0;
        Node current=head;
        while(count<=size/2){
            maxSum=Math.max(maxSum, current.data+ nodeStack.peek());
            current=current.next;
            nodeStack.pop();
            count++;
        }
        return maxSum;
    }
}

// Approach 3- Reversing second half in place 
class Solution2{ // TC O(n) SC O(1)
    public int pairSum(Node head) {
        Node slow = head;
        Node fast = head;

        // Get middle of the linked list.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half of the linked list.
        Node nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        Node start = head;
        int maximumSum = 0;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, start.data + prev.data);
            prev = prev.next;
            start = start.next;
        }

        return maximumSum;
    }
}

class pairSumLinkedList{
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        int[] keys={5,4,2,1};
        LinkedList list=ll.constructLinkedList(keys);
        Solution s= new Solution();
        System.out.println(s.pairSum(list.head));
        Solution1 s1= new Solution1();
        System.out.println(s1.pairSum(list.head));
        Solution2 s2= new Solution2();
        System.out.println(s2.pairSum(list.head));

    }
}


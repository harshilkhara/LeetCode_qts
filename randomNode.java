import java.util.*;
// Approach 1- Converting LinkedList to an array 
class Solution {
    private ArrayList<Integer> range = new ArrayList<>();

    public void listMaker(Node head){
        while(head!=null){
            range.add(head.data);
            head=head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom(Node head) {
        listMaker(head);
        int pick = (int)(Math.random() * this.range.size());
        return this.range.get(pick);
    }
}

// Approach 2- Reservoir Sampling 
// When the size of sample population is unknown you can still
// pick a random element with equal probability 
class Solution1{
    
    /** Returns a random node's value. */
    public int getRandom(Node head) {
        int scope = 1, chosenValue = 0;
        Node curr = head;
        while (curr != null) {
            // decide whether to include the element in reservoir
            if (Math.random() < 1.0 / scope)
                chosenValue = curr.data;
            // move on to the next node
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
}

class randomNode{
    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        int[] keys= {1,2,4,6,3};
        LinkedList list= ll.constructLinkedList(keys);
        Solution s= new Solution();
        System.out.println(s.getRandom(list.head));
        Solution1 s1= new Solution1();
        System.out.println(s1.getRandom(list.head));
    }
}

 

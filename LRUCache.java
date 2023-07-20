import java.util.*;
// Approach 1- Doubly Linked List
class ListNode{
    
    int key, val; 
    ListNode next;
    ListNode prev;
    
    ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class Solution {
    
    ListNode head, tail;
    Map<Integer, ListNode> map;
    int capacity;

    public Solution(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new ListNode(-1, -1);
        tail=new ListNode(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node=map.get(key);
        remove(node);
        add(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode oldNode=map.get(key);
            remove(oldNode);
        }
        
        ListNode node=new ListNode(key, value);
        map.put(key, node);
        add(node);
        
        if(map.size()>this.capacity){
            ListNode nodeToDelete=head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
        
    }
    
    public void add(ListNode node){
        ListNode previousEnd=tail.prev;
        previousEnd.next=node;
        node.prev=previousEnd;
        node.next=tail;
        tail.prev=node;
        
    }
    
    public void remove(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

// Approach 2- Ordered HashMap (Dictionary)
class Solution1 extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public Solution1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache{
    public static void main(String[] args) {
        Solution s= new Solution(2);
        s.put(1,1);
        s.put(2,2);
        System.out.println(s.get(1));
        s.put(3,3);
        System.out.println(s.get(1));
        s.put(4,4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));
    }
}
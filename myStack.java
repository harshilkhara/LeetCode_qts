import java.util.*;
// Approach 1- 1 Queue 
class Solution {

    Queue<Integer> q1;
    public Solution() { // TC Push- O(n), Pop- O(1)
        q1= new LinkedList<>();
    }
    
    public void push(int x) { // TC O(n)
        q1.add(x);
        int size= q1.size();
        while(size>1){
            q1.add(q1.remove());
            size--;
        }
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

class myStack{
    public static void main(String[] args) {
        Solution s=new Solution();
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }
}
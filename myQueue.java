// Queues- FIFO (First in First Out) 
/*

add(item)- adds item to the end of the list (rear)
remove()- removes from start of the list     (front)
peek()- gives the start element of the list  (front)

*/
import java.util.*;
class Solution{
    Stack<Integer> s1; 
    Stack <Integer> s2;
    private int front;

    public Solution() {
        s1= new Stack<>();
        s2= new Stack<>();
    }
    
    public void push(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());

    }
    
    public int pop() {
        int x= s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return x;
        
    }
    
    public int peek() {
        return front; 
    }
    
    public boolean empty() {
        return s1.isEmpty();
        
    }
}
// From ctci and best one // TC Push- O(1) Pop- Amortized O(1)

class Solution1{
    Stack<Integer> stackOldest; 
    Stack<Integer> stackNewest;
    private int front;

    public Solution1(){
        stackOldest= new Stack<>();
        stackNewest= new Stack<>();
    }

    public void push(int x){
        if(stackNewest.isEmpty()){
            front=x;
        }
        stackNewest.push(x);
    }

    public int pop(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
        return stackOldest.pop();
    }

    public int peek(){
        if(!stackOldest.isEmpty()){
            return stackOldest.peek();
        }
        return front;
    }
        
    public boolean empty(){
        return stackOldest.isEmpty() && stackNewest.isEmpty();
    }
    
}

class myQueue{
    public static void main(String [] args){
        Solution s= new Solution();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.empty());
        Solution1 s1= new Solution1();
        s1.push(1);
        s1.push(3);
        s1.push(2);
        System.out.println(s1.peek());
        System.out.println(s1.pop());
        System.out.println(s1.peek());
        System.out.println(s1.empty());
    }
}

class Solution{
    
    int[] stack;
    int top;

    public Solution(int maxSize) {
        stack= new int[maxSize];
        top=-1;
    }
    
    public void push(int x) {
        if (top>=stack.length-1){
            return;
        }
        stack[++top]=x;
    }
    
    public int pop(){
        if(top<0)
            return -1;
        return stack[top--];
        
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= top; i++) 
			stack[i] += val;
        
    }
}

class customStack{
    public static void main(String [] args){
        Solution s= new Solution(10);
        s.push(1);
        s.push(5);
        s.push(7);
        s.push(1);
        System.out.println(s.pop());
        s.increment(2,3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

import java.util.*;
class Solution { // TC O(n) SC O(n)
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.offer(i);
        }
        
        while(queue.size()!=1){
            for(int i=0; i<k-1; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        
        return queue.peek()+1;
    }
}

class findTheWinner{
    public static void main(String[] args) {
        int n=5;
        int k=2; 
        Solution s= new Solution();
        System.out.println(s.findTheWinner(n,k));
    }
}
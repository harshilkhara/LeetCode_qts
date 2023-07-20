import java.util.*;
// Approach 1- Stack
class Solution { // TC O(n) SC O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int asteroid: asteroids){
            boolean flag=true;
            while(!stack.isEmpty() && stack.peek()>0 && asteroid<0){
                if(Math.abs(stack.peek())<Math.abs(asteroid)){
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek())==Math.abs(asteroid)){
                    stack.pop();
                }
                flag=false;
                break;
            }
            if (flag) stack.push(asteroid);
        
        }
        
        int[] answer=new int[stack.size()];
        int i=0;
        for(int a: stack){
            answer[i++]=a;
        }
        return answer;
    }
}

class asteroidCollision{
    public static void main(String[] args) {
        int[] asteroids={5,10,-5};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.asteroidCollision(asteroids)));
    }
}
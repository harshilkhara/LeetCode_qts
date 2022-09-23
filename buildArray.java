import java.util.*;
class Solution{ // TC O(n) SC O(n)
    public List<String> buildArray(int[] target, int n) {
        List<String> answer= new ArrayList<>();
        int number=1; 
        int index=0;
        while(index!=target.length){
            if (target[index]==number){
                index++;
                number++;
                answer.add("Push");
            }
            else{
                number++;
                answer.add("Push");
                answer.add("Pop");
            }
        }
        return answer;
    }
}

class buildArray{
    public static void main(String[] args) {
        int n=3;
        int[] target={1,3};
        Solution s= new Solution();
        System.out.println(s.buildArray(target,n));
    }
}
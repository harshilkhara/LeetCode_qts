import java.util.*;
// Approach 1- Creating a dedicated method
class Solution { // TC O(n) SC O(1)
    public void fill(int[] answer, int[] nums, int i){
        int j=0;
        while(i<answer.length && j<nums.length){
            answer[i++]=nums[j++];
        }
    }
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n*2];
        fill(answer, nums, 0);
        fill(answer, nums, n);
        return answer;
        
    }
}

// Approach 2- One pass 
class Solution1{ // TC O(n) SC O(1)
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n*2];
        for(int i=0; i<answer.length; i++){
            if(i<n){
                answer[i]=nums[i];
            } else {
                answer[i]=nums[i-n];
            }
        }
        return answer;
        
    }
}

class getConcatenation{
    public static void main(String[] args) {
        int[] nums={1,2,1};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.getConcatenation(nums)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.toString(s1.getConcatenation(nums)));
    }
}
import java.util.*;
// Approach 1- Greedy Method
class Solution { // TC O(n) SC O(1)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer=new ArrayList<>();
        int currMax=Integer.MIN_VALUE;
        for(int candy: candies){
            currMax=Math.max(currMax, candy);
        }
        
        for(int candy: candies){
            answer.add(candy+extraCandies>=currMax);
        }
        return answer;
    }
}

class kidsWithCandies{
    public static void main(String[] args) {
        int[] candies={2,3,5,1,3};
        int extraCandies=3;
        Solution s=new Solution();
        System.out.println(s.kidsWithCandies(candies, extraCandies));
    }
}
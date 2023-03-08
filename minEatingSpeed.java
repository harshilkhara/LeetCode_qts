import java.util.*;
class Solution { // TC O(n log m) SC O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
        for(int pile : piles){
            maxPile=Math.max(maxPile, pile);
        }
        int left=1, right=maxPile;
        while (left<right){
            int mid=left+right>>>1;
            int hrs=0;
            for(int pile: piles){
                hrs+=Math.ceil((double) pile/mid);
            }
            if (hrs<=h){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}

class minEatingSpeed{
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h=8;
        Solution s= new Solution();
        System.out.println(s.minEatingSpeed(piles,h));
    }
}
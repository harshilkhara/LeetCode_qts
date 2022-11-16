/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */


// Approach 1- Binary Search       
// Similar to finding the closestValue 
import java.util.*;
class Solution{ // TC O(log n) SC O(1)
    public int guess(int num,int pick){
        if (num<pick){
            return -1;
        } else if (num>pick){
            return 1;
        } else {
            return 0;
        }
    }

    public int guessNumber(int n,int pick) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid,pick);
            if (res == 0)
                return mid;
            else if (res > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}

class guessNumber{
    public static void main(String[] args) {
        Random random_num= new Random();
        Solution s= new Solution();
        int n=18;
        int pick=random_num.nextInt(1,n);
        System.out.println("Number picked up is - " + pick);
        System.out.println(s.guessNumber(n,pick));

    }
}
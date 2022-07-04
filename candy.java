// Approach 1 - DP        TC O(2N) --> O(N) // SC O(N)
import java.util.*;
class Solution{
    public int candy(int[] ratings) {
        int [] candies=new int[ratings.length];
        Arrays.fill(candies,1);
        for (int i=1; i < ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        int sum = candies[ratings.length-1];
        for (int i=ratings.length-2; i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
            sum+=candies[i];
        }
        return sum;
    }
}

// Approach 2- Single Pass Approach with Constant Space

class Solution1{    // TC O(N)  SC O(1)
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1 
                : (ratings[i] < ratings[i - 1] ? -1 
                : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
class candy{
    public static void main(String[] args) {
        int [] ratings={1,0,2};
        Solution s= new Solution();
        System.out.println(s.candy(ratings));
        Solution1 s1= new Solution1();
        System.out.println(s1.candy(ratings));
    }
}
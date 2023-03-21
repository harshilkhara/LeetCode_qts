// Very similar to zeroFilledSubarray.java & .py
// Approach 1- Count the no. of consecutive numbers at each index
import java.util.*;
class Solution {
    int value;
    int k;
    int consecSubarray=0;
    
    public Solution(int value, int k) {
        this.value=value;
        this.k=k;
    }
    
    public boolean consec(int num) {
        if (num==value){
            consecSubarray++;
        } else {
            consecSubarray=0;
        }
        return consecSubarray>=k;
    }
}

class dataStream{
    public static void main(String[] args) {
        Solution s= new Solution(4,3);
        System.out.println(s.consec(4));
        System.out.println(s.consec(4));
        System.out.println(s.consec(4));
        System.out.println(s.consec(3));
    }
}
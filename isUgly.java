// Approach 1- Math 
class Solution { // TC O(log n) SC O(1)
    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }
        return n>0;
    }
}

class isUgly{
    public static void main(String[] args) {
        int n=6;
        Solution s= new Solution();
        System.out.println(s.isUgly(n));
    }
}
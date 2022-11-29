class Solution {
    public int numberOfCuts(int n) {
        if (n==1) return 0;
        
        return n%2!=0 ? n : n/2;
    }
}

class numberOfCuts{
    public static void main(String[] args) {
        int n=7; 
        Solution s= new Solution();
        System.out.println(s.numberOfCuts(n));
    }
}
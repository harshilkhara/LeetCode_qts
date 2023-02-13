// Approach 1- Maths
class Solution { // TC O(1) SC O(1)
    public int countOdds(int low, int high) {
        // if (low%2==0) low++;
        if((low & 1)==0){
            low++;
        }
        return low>high ? 0: (high-low)/2+1;
    }
}

class countOdds{
    public static void main(String[] args) {
        int low=3;
        int high=12;
        Solution s= new Solution();
        System.out.println(s.countOdds(low,high));
    }
}
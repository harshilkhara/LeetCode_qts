import java.util.*; 
// Approach 1- Greedy
class Solution { // TC O(n log n) SC O(log n)
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> a[1]-b[1]);
        int cur=Integer.MIN_VALUE, count=0;
        for(int[] pair: pairs){
            if (cur < pair[0]){
                cur=pair[1];
                count++;
            }
        }
        return count;
    }
}

class findLongestChain{
    public static void main(String[] args) {
        int[][] pairs={{1,2},{2,3},{3,4}};
        Solution s= new Solution();
        System.out.println(s.findLongestChain(pairs));
    }
}
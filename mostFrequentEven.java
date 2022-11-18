import java.util.*;
// Approach 1- HashMap 
class Solution { // TC O(n) SC O(n)
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums){
            if (n%2==0){
                map.put(n,map.getOrDefault(n,0)+1);
            }
        }
        int ans=-1;
        int max= Integer.MIN_VALUE;
        for(int key: map.keySet()){
            if (map.get(key)>max){
                max=map.get(key);
                ans=key;
            }
            if(map.get(key)==max)
                ans=Math.min(ans,key);
        }
        return ans;
    }
}

class mostFrequentEven{
    public static void main(String[] args) {
        int[] nums={0,1,2,2,4,4,1};
        Solution s= new Solution();
        System.out.println(s.mostFrequentEven(nums));

    }
}
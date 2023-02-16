import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int result=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int x=entry.getKey();
            int val=entry.getValue();
            if(k>0 && map.containsKey(x+k))
                result++;
            else if (k==0 && val>1){
                result++;
            }
        }
        return result;
    }
}

class kdiff{
    public static void main(String[] args) {
        int[] nums={3,1,4,1,5};
        int k=2;
        Solution s= new Solution();
        System.out.println(s.findPairs(nums,k));
    }
}
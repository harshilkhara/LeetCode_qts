import java.util.*;
// Approach 1- HashMap & HashSet
class Solution { // TC O(n) SC O(n)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set= new HashSet<>(map.values());
        
        return map.size()==set.size();
        
    }
}

class uniqueOccurrences{
    public static void main(String[] args) {
        int[] arr={1,1,2,1,3,3};
        Solution s= new Solution();
        System.out.println(s.uniqueOccurrences(arr));
    }
}
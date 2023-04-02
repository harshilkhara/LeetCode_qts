import java.util.*;
// Approach 1- Sorting + Binary Search
class Solution { // TC O(m+n(log m)) SC O(log m)
    public int binarySearch(int target, int[] potions){
        int l=0, r=potions.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if (target>potions[mid]){
                l=mid+1;
            } else {
                r=mid;
            }
        }
        return l;
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length, m=potions.length;
        int[] answer=new int[n];
        for(int i=0; i<n; i++){
            int target=(int) Math.ceil((1.0*success)/spells[i]);
            int p=binarySearch(target, potions);
            int pairs= (m-p>0) ? (m-p): 0;
            answer[i]=pairs;
        }
        return answer;
    }
}

class successfulPairs{
    public static void main(String[] args) {
        int[] spells={5,1,3};
        int[] potions={1,2,3,4,5};
        long success=7;
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.successfulPairs(spells, potions, success)));
    }
}
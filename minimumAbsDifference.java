import java.util.*;
// Approach 1- Sorting 
class Solution { // TC O(n log n) SC O( log n)
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        List<List<Integer>> answer=new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            int diff=arr[i]-arr[i-1];
            if(diff==minDiff){
                answer.add(Arrays.asList(arr[i-1],arr[i]));
            } else if (diff<minDiff){
                minDiff=diff;
                answer.clear();
                answer.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return answer;
    }
}

class minimumAbsDifference{
    public static void main(String[] args) {
        int[] arr={4,2,1,3};
        Solution s= new Solution();
        System.out.println(s.minimumAbsDifference(arr));
    }
}
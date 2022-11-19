import java.util.*;
class Solution {
    public void backtrack(int[] candidates,List<List<Integer>> answer, int target, List<Integer> combination, int start){
        if (target==0){
            answer.add(new ArrayList<Integer>(combination));
            return;
        } else if (target<0){
            return;
        }
        for (int i=start; i<candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(candidates,answer,target-candidates[i],combination,i);
            combination.remove(combination.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        backtrack(candidates,answer,target,combination,0);
        return answer;
    }
}

class combinationSum{
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        Solution s= new Solution();
        System.out.println(s.combinationSum(candidates,target));
    }
}
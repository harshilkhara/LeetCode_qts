import java.util.*;
// Approach 1- Backtrack
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int n, k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        backtrack(new ArrayList<Integer>(), 1);
        return ans;
    }

    public void backtrack(List<Integer> comb, int start){
        if(comb.size()==k){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int i=start; i<=n; i++){
            comb.add(i);
            backtrack(comb, i+1);
            comb.remove(comb.size()-1);
        }
    }
}

class combinations{
    public static void main(String[] args) {
        int n=3;
        int k=2; 
        Solution s= new Solution();
        System.out.println(s.combine(n, k));
    }
}
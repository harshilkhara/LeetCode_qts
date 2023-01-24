import java.util.*;
class Solution { // TC O(n 2^n) SC O(n)
    public boolean isValid(String s, int l, int r){
        while (l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public void backtrack(List<List<String>> ans, List<String> pali, String s, int idx){
        if (idx>=s.length()){
            ans.add(new ArrayList<>(pali));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if (isValid(s,idx,i)){
                pali.add(s.substring(idx,i+1));
                backtrack(ans,pali,s,i+1);
                pali.remove(pali.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> pali=new ArrayList<>();
        backtrack(ans,pali,s,0);
        return ans;
    }
}

class partition{
    public static void main(String[] args) {
        String x="aab";
        Solution s= new Solution();
        System.out.println(s.partition(x));
    }
}
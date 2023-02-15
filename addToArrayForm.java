import java.util.*;
// Approach 1- School book maths
class Solution { // TC O(n) SC O(n)
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        int n=num.length;
        int curr=k;
        int i=n;
        while(i-- >=1 || curr>0){
            if(i>=0){
                curr+=num[i];
            }
            ans.add(curr%10);
            curr/=10;
        }
        Collections.reverse(ans);
        return ans;
    }
}

class addToArrayForm{
    public static void main(String[] args) {
        int[] num={1,2,3,4};
        int k=98;
        Solution s= new Solution();
        System.out.println(s.addToArrayForm(num,k));
    }
}
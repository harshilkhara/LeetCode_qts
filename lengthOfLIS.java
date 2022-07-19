import java.util.*;
class Solution1{
    public int lengthOfLIS(int[] nums) { // TC O(N^2) // SC O(N)
        int dp[] = new int[nums.length]; 
        Arrays.fill(dp,1); 
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int longest=0;
        for (int i : dp){
            longest= Math.max(longest,i);
        }
        return longest;
    }
}

class Solution2{
    public int lengthOfLIS(int[] nums){
        ArrayList<Integer> sub= new ArrayList<>(); 
        sub.add(nums[0]);
        for (int i=1; i<nums.length;i++){
            if (nums[i]>sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }
            else{
                int j=0; 
                while (nums[i]>sub.get(j))
                    j++;
                sub.set(j,nums[i]);
            }
        }
        return sub.size();
    }
}

class Solution3{
    public int binarySearch(ArrayList<Integer> sub, int nums){
        int left=0; 
        int right=sub.size()-1;
        while (left<right){
            int mid= left+right/2;
            if (sub.get(mid)==nums){
                return mid;
            }
            else if(sub.get(mid)<nums) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public int lengthOfLIS(int [] nums){
        ArrayList<Integer> sub= new ArrayList<Integer>(); 
        sub.add(nums[0]);
        for (int i=1; i<nums.length;i++){
            if (nums[i]>sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }
            else{
                int j = binarySearch(sub,nums[i]);
                sub.set(j,nums[i]);
            }
        }
        return sub.size();
    }
}

class lengthOfLIS{
    public static void main(String[] args){
        int [] nums= {10,9,2,5,3,7,101,18};
        Solution1 s1= new Solution1();
        System.out.println(s1.lengthOfLIS(nums));
        Solution2 s2= new Solution2();
        System.out.println(s2.lengthOfLIS(nums));
        Solution3 s3= new Solution3();
        System.out.println(s3.lengthOfLIS(nums));
    }
}
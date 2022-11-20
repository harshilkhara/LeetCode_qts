import java.util.*;
// Using hashmap to track the duplicates 
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        List<Integer> comb = new ArrayList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            List<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.add(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.remove(comb.size()-1);
            counter.put(num, count);
        }
    }
}


// Approach 2- Very similar to permute.java & .py 
// Storing the results in set itself 
class Solution1{
    public void backtrack(int[] nums, List<Integer> permute, Set<List<Integer>> seen, boolean[] used){
        if (permute.size()==nums.length){
            seen.add(new ArrayList<Integer>(permute));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i]=true;
                permute.add(nums[i]);
                backtrack(nums,permute,seen,used);
                used[i]=false;
                permute.remove(permute.size()-1);
            }
        }


    }

    public List<List<Integer>> permuteUnique(int[] nums){
        boolean[] used= new boolean[nums.length];
        Set<List<Integer>> seen= new HashSet<>();
        List<Integer> permute= new ArrayList<>();
        backtrack(nums,permute,seen,used);
        return new ArrayList(seen);

    }
}


class permuteII{
    public static void main(String[] args) {
        int[] nums={1,1,2};
        Solution s= new Solution();
        System.out.println(s.permuteUnique(nums));
        Solution1 s1= new Solution1();
        System.out.println(s1.permuteUnique(nums));
    }
}
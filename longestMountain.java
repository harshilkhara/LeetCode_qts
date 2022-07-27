// Approach 1- Two Pointers (Very similar to validMountainArray)
class Solution { // TC O(N) SC O(1)
    public int longestMountain(int[] nums) {
        int N = nums.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && nums[end] < nums[end + 1]) {
                // set end to the peak of this potential mountain
                while (end + 1 < N && nums[end] < nums[end + 1]) end++;

                // if end is really a peak..
                if (end + 1 < N && nums[end] > nums[end + 1]) {
                    // set end to the right-boundary of mountain
                    while (end + 1 < N && nums[end] > nums[end + 1]) end++;
                    // record candidate answer
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }

        return ans;
    }
}

class longestMountain{
    public static void main(String[] args) {
        int [] nums={2,1,4,7,3,2,5};
        Solution s= new Solution(); 
        System.out.println(s.longestMountain(nums));
    }

}
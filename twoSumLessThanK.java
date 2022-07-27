// Approach 1- Two pointers (Very similar to two sum II where input is sorted )
import java.util.*;
class Solution { // TC O(n log n) SC O(n)
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}

// Approach 2- Counting Sort 

class Solution1{  // TC O(n+m)  SC O(m)
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int lo = 1;
        int hi = 1000;
        while (lo <= hi) {
            if (lo + hi >= k || count[hi] == 0) {
                hi--;
            } else {
                if (count[lo] > (lo < hi ? 0 : 1)) {
                    answer = Math.max(answer, lo + hi);
                }
                lo++;
            }
        }
        return answer;
    }
}

// Approach 3- Binary Search 

class Solution2{
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int idx = Arrays.binarySearch(nums, i + 1, nums.length, k - nums[i] - 1);
            int j = (idx >= 0 ? idx : ~idx);
            if (j == nums.length || nums[j] > k - nums[i] - 1) {
                j--;
            }
            if (j > i) {
                answer = Math.max(answer, nums[i] + nums[j]);
            }
        }
        return answer;
    }
}

class twoSumLessThanK{
    public static void main(String[] args) {
        int [] nums={34,23,1,24,75,33,54,8};
        int k=60;
        Solution s= new Solution();
        System.out.println(s.twoSumLessThanK(nums,k));
    }
}
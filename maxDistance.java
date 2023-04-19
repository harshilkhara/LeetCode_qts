import java.util.*;
// Approach 1- Binary Search on descending array
class Solution { // TC O(m log n) SC O(1)
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int ans = 0;

        // Iterate over nums1 and find insertion position to nums2.
        for (int i = 0; i < m; ++i) {
            int k = binarySearch(nums2, nums1[i]);
            if (k > i) {
                ans = Math.max(ans, k - i);
            }
        }
        return ans;
    }
    public int binarySearch(int[] nums, int a) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < a) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

// Approach 2- Two Pointers
class Solution1{ // TC O(m+n) SC O(1)
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0, p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            // If p1 is larger, we should move on to a smaller p1.
            if (nums1[p1] > nums2[p2]) {
                p1++;
            }
            
            // Otherwise, get their distance and move on to a smaller p2.
            else {
                ans = Math.max(ans, p2 - p1);
                p2++;
            }
        }
        return ans;
    }
}

class maxDistance{
    public static void main(String[] args) {
        int[] nums1={55,30,5,4,2};
        int[] nums2={100,20,10,10,5};
        Solution s=new Solution();
        System.out.println(s.maxDistance(nums1, nums2));
        Solution1 s1=new Solution1();
        System.out.println(s1.maxDistance(nums1, nums2));
    }
}
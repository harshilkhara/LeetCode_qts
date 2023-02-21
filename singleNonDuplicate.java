import java.util.*;
// Approach 1- Bit Manipulation- XOR 
class Solution{
    public int singleNonDuplicate(int[] nums){
        int ans=0;
        for(int num:nums){
            ans^=num;
        }
        return ans;
    }
}

// Approach 2- Linear Scan
class Solution1{ // TC O(n) SC O(1)
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

// Approach 3- Binary Search
class Solution2{ // TC O(log n) SC O(1)
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}

// Approach 4- Binary search only on even index and reducing the search space 
class Solution3{ // TC O(log n) SC O(1)
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}

class singleNonDuplicate{
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4,8,8};
        Solution s= new Solution();
        System.out.println(s.singleNonDuplicate(nums));
        Solution1 s1= new Solution1();
        System.out.println(s1.singleNonDuplicate(nums));
        Solution2 s2= new Solution2();
        System.out.println(s2.singleNonDuplicate(nums));
        Solution3 s3= new Solution3();
        System.out.println(s3.singleNonDuplicate(nums));
    }
}
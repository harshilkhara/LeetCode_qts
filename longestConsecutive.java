import java.util.*;
// Approach 1- Brute Force 
class Solution{                       // TC O(N^3)    SC O(1)
    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
// Approach 2- Sorting 

class Solution1{            // TC O(n log n) // SC O(1) or O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}

// Approach 3- HashSet & Intelligent Sequence Building 
// Very much inspired from approach 1 

class Solution2{      // TC O(n+n)= O(N) SC O(N)
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) { // This is the main idea here 
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

class longestConsecutive{
    public static void main(String[] args){
        int [] nums= {100,4,200,1,3,2};
        Solution s= new Solution();
        System.out.println(s.longestConsecutive(nums));
        Solution1 s1= new Solution1();
        System.out.println(s1.longestConsecutive(nums));
        Solution2 s2= new Solution2();
        System.out.println(s2.longestConsecutive(nums));
    }
}
// Approach 1- Linear Scan 
class Solution{    //  TC O(N) SC O(1)
    public int findPeakElement(int[] nums) {
        for(int i=0; i<nums.length-1;i++){
            if (nums[i]>nums[i+1])
                return i;
        }
        return nums.length-1;
    }
}

// Approach 2- Binary Search 

class Solution1{ // TC O(log n)  SC O(1)
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) // nums[mid+1] is target 
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

class findPeakElement{
    public static void main(String[] args){
        int [] nums={1,2,3,1}; 
        Solution s= new Solution();
        System.out.println(s.findPeakElement(nums));
        Solution1 s1= new Solution1();
        System.out.println(s1.findPeakElement(nums));
    }
}
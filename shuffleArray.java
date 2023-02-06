import java.util.*;
// Approach 1- Array Iteration
class Solution{ // TC O(n) SC O(n)
	public int[] shuffleArray(int[] nums, int n){
		int[] ans= new int[2*n];
		int l=0, r=n;
		int index=0;
		while(l<n){
			ans[index++]=nums[l++];
			ans[index++]=nums[r++];
		}
		return ans;
	}
}

// Approach 2- Alternate code same approach
class Solution1{ // TC O(n) SC O(n)
    public int[] shuffleArray(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }
}

// Approach 3- In-place filling 
class Solution2{ // TC O(n) SC O(1)
    public int[] shuffleArray(int[] nums, int n) {
        // Store each y(i) with respective x(i).
        for (int i = n; i < 2 * n; ++i) {
            int secondNum = nums[i] << 10;
            nums[i - n] |= secondNum;
        }

        // '0000000000 1111111111' in decimal.
        int allOnes = (int) Math.pow(2, 10) - 1;

        // We will start putting all numbers from the end, 
        // as they are empty places.
        for (int i = n - 1; i >= 0; --i) {
            // Fetch both the numbers from the current index.
            int secondNum = nums[i] >> 10;
            int firstNum = nums[i] & allOnes;
            nums[2 * i + 1] = secondNum;
            nums[2 * i] = firstNum;
        }
        return nums;
    }
}

class shuffleArray{
	public static void main(String[] args) {
		int[] nums={2,5,1,3,4,7};
		int n=3;
		Solution s= new Solution();
		System.out.println(Arrays.toString(s.shuffleArray(nums,n)));
		Solution1 s1= new Solution1();
		System.out.println(Arrays.toString(s1.shuffleArray(nums,n)));
		Solution2 s2= new Solution2();
		System.out.println(Arrays.toString(s2.shuffleArray(nums,n)));
	}
}
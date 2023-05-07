import java.util.*;
// Very similar to LIS.java & .py
// Approach 1- Greedy + Binary Search
class Solution { // TC O(n log n) SC O(n)
    // Find the rightmost insertion position. We use a fixed-length array and 
    // a changeable right boundary 
    // to represent an arraylist of dynamic size.
    private int bisectRight(int[] A, int target, int right) {
        if (right == 0)
            return 0;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    
    public int[] longestObstacle(int[] obstacles) {
        int n = obstacles.length, lisLength = 0;
        
        // lis[i] records the lowest increasing sequence of length i + 1.
        int[] answer = new int[n], lis = new int[n];

        for (int i = 0; i < n; ++i) {
            int height = obstacles[i];
            
            // Find the rightmost insertion position idx.
            int idx = bisectRight(lis, height, lisLength);
            if (idx == lisLength)
                lisLength++;

            lis[idx] = height;
            answer[i] = idx + 1;
        }
        return answer;
    }
}

class longestObstacle{
    public static void main(String[] args) {
        int[] obstacles={1,2,3,2};
        Solution s=new Solution();
        System.out.println(Arrays.toString(s.longestObstacle(obstacles)));
    }
}


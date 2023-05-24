import java.util.*;
// Approach 1- Priority Queue
class Solution { // TC O(n log n) SC O(n)
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            //pairs[i]=new int[]{nums1[i], nums2[i]};
            pairs[i][0]=nums1[i];
            pairs[i][1]=nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Use a min-heap to maintain the top k elements.
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        
        // The score of the first k pairs.
        long answer = topKSum * pairs[k - 1][1];
        
        // Iterate over every nums2[i] as minimum from nums2.
        for (int i = k; i < n; ++i) {
            // Remove the smallest integer from the previous top k elements
            // then ddd nums1[i] to the top k elements.
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            
            // Update answer as the maximum score.
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        
        return answer;
    }
}

class maxScore{
    public static void main(String[] args) {
        int[] nums1={1,3,3,2}; 
        int[] nums2={2,1,3,4}; 
        int k=3;
        Solution s=new Solution();
        System.out.println(s.maxScore(nums1, nums2, k));
    }
}
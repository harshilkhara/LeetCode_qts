import java.util.*;
class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
// Approach 1- Min-Heap
class Solution { // TC O(min(k log k, m n log m n)) SC O(min(m,n))
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            ans.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair(i + 1, j))) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair(i + 1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair(i, j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair(i, j + 1));
            }
        }

        return ans;
    }
}

class kSmallestPairs{
    public static void main(String[] args) {
        int[] nums1={1,7,11};
        int[] nums2={2,4,6};
        int k=3;
        Solution s= new Solution();
        System.out.println(s.kSmallestPairs(nums1, nums2, k));
    }
}
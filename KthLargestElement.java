import java.util.*;
// Approach 1- Priority Min-Heap
class KthLargest { // TC O(n log n) SC O(k)
    private static int k;
    private PriorityQueue<Integer> heap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        
        for (int num: nums) {
            heap.offer(num);
        }
        
        while (heap.size() > k) {
            heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
class KthLargestElement{
    public static void main(String[] args) {
        int[] nums={4,5,8,2};
        int k=3;
        KthLargest kth=new KthLargest(k, nums);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

    }
}
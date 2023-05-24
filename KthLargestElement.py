import heapq
class KthLargest:
# Approach 1- Priority Min-Heap
    def __init__(self, k, nums): # TC O(n log n) // SC O(k)
        self.k=k
        self.heap=nums
        
        heapq.heapify(self.heap)
        while len(self.heap)>self.k:
            heapq.heappop(self.heap)
            
    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        
        if len(self.heap)>self.k:
            heapq.heappop(self.heap)
        
        return self.heap[0]


# Your KthLargest object will be instantiated and called as such:
k=3
nums=[4,5,8,2]
kth = KthLargest(k, nums)
print(kth.add(3))
print(kth.add(5))
print(kth.add(10))
print(kth.add(9))
print(kth.add(4))
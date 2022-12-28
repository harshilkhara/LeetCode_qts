import heapq
# Approach 1- Greedy Solution - Max Heap
def minStoneSum(piles,k): # TC O((n+k)* log n) // SC O(n)
	heap = [-num for num in piles]
	heapq.heapify(heap)

	for _ in range(k):
	    curr = -heapq.heappop(heap)
	    remove = curr // 2
	    heapq.heappush(heap, -(curr - remove))

	return -sum(heap)

print(minStoneSum([5,4,9],2))
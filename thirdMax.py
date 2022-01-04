def thirdMax(nums):    # TC O(n) // SC O()
	list(set(nums))
	n=len(nums)
	if n <3:
		return(max(nums))
	else:
		nums.remove(max(nums))
		nums.remove(max(nums))
		return max(nums)

import heapq      
def thirdMax1(nums):
    heap = list()
    heapq.heapify(heap)    # using heapify to convert list into heap
    for num in nums:
        if num not in heap:
            heapq.heappush(heap, num)
            if len(heap) > 3:
                heapq.heappop(heap)
    if len(heap) == 2:
        heapq.heappop(heap)
    return heapq.heappop(heap)


print(thirdMax([3,2,5,6,12]))
print(thirdMax1([3,2,5,6,12]))

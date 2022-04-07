#Approach 1- Array based simulation 
def lastStoneWeight(stones): # TC O(n^2) // SC O(1)
	def remove_largest(): # TC O(n)
	    index_of_largest = stones.index(max(stones)) #TC O(n)
	    # Swap the stone to be removed with the end.
	    stones[index_of_largest], stones[-1] = stones[-1], stones[index_of_largest] # TC O(1)
	    return stones.pop() # TC O(1)

	while len(stones) > 1: # TC O(n)
	    stone_1 = remove_largest() # TC O(n)
	    stone_2 = remove_largest() # TC O(n)
	    if stone_1 != stone_2:
	        stones.append(stone_1 - stone_2)

	return stones[0] if stones else 0

import bisect
#Approach 2- Sorted Array based simulation
def lastStoneWeight1(stones): # TC O(n^2) // SC O(1)
	stones.sort() # TC O(n log n)
	while len(stones) > 1: # TC O(n)
	    stone_1 = stones.pop() # TC O(1)
	    stone_2 = stones.pop() # TC O(1)
	    if stone_1 != stone_2:
	        bisect.insort(stones, stone_1 - stone_2) # TC O(n)
	return stones[0] if stones else 0

'''
Approach 3- Heap based simulation (MaxHeap or Priority Queue)

 The idea in here is very similar to approach 2 but using better DS helps
 In python its by default min heap so convert each number into negative number

'''

import heapq
def lastStoneWeight2(stones): # TC O(n log n) // SC O(1)
	# Make all the stones negative. We want to do this *in place*, to keep the
	# space complexity of this algorithm at O(1). :-)
	for i in range(len(stones)):
	    stones[i] *= -1

	# Heapify all the stones.
	heapq.heapify(stones) # TC O(n)

	# While there is more than one stone left, remove the two
	# largest, smash them together, and insert the result
	# back into the heap if it is non-zero.
	while len(stones) > 1: # TC O(n)
	    stone_1 = heapq.heappop(stones) # TC O(log n)
	    stone_2 = heapq.heappop(stones) # TC O(log n)
	    if stone_1 != stone_2:
	        heapq.heappush(stones, stone_1 - stone_2) # TC O(log n)

	# Check if there is a stone left to return. Convert it back
	# to positive.
	return -heapq.heappop(stones) if stones else 0

#Approach 4- Bucket Sort
def lastStoneWeight3(stones):
	# Set up the bucket array.
	max_weight = max(stones)
	buckets = [0] * (max_weight + 1)

	# Bucket sort.
	for weight in stones:
	    buckets[weight] += 1

	# Scan through the weights.
	biggest_weight = 0 
	current_weight = max_weight
	while current_weight > 0:
	    if buckets[current_weight] == 0:
	        current_weight -= 1
	    elif biggest_weight == 0:
	        buckets[current_weight] %= 2
	        if buckets[current_weight] == 1:
	            biggest_weight = current_weight
	        current_weight -= 1
	    else:
	        buckets[current_weight] -= 1
	        if biggest_weight - current_weight <= current_weight:
	            buckets[biggest_weight - current_weight] += 1
	            biggest_weight = 0
	        else:
	            biggest_weight -= current_weight
	return biggest_weight


print(lastStoneWeight([2,7,4,1,8,1]))
print(lastStoneWeight1([2,7,4,1,8,1]))
print(lastStoneWeight2([2,7,4,1,8,1]))
print(lastStoneWeight3([2,7,4,1,8,1]))

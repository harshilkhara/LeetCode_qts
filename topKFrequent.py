'''
The below code is written up by me
ALSO, this problem is a mix of frequencySort.py and kthLargest.py 

'''

import collections
def topKFrequent(nums,k):   # TC O(n log n) // SC O(n)
	counter=collections.Counter(nums)         # TC O(n)   
	common=[]
	for nums,freq in counter.most_common():     # TC O(n log n)
		common.append(nums)
	stack=[]
	for i in range(k):
		stack.append(common[i])

	return stack

'''
Approach- Heap 

''' 
import heapq
def topKFrequent1(nums, k): # TC O(n log k) // SC (N+k)
    # O(1) time 
    if k == len(nums):
        return nums
    
    # 1. build hash map : character and how often it appears
    # O(N) time
    count = collections.Counter(nums)   
    # 2-3. build heap of top k frequent elements and
    # convert it into an output array
    # O(N log k) time
    return heapq.nlargest(k, count.keys(), key=count.get) 


def topKFrequent2(nums,k):                       # TC O(n) // SC O(n)  --> Bucket sort too
	bucket = [[] for _ in range(len(nums) + 1)]
	Count = collections.Counter(nums).items()  
	for num, freq in Count: 
		bucket[freq].append(num) 

	flat_list = [item for sublist in bucket for item in sublist]
	return flat_list[::-1][:k]


def topKFrequent3(nums,k):       # TC O(n) // SC O(n)
	count=collections.Counter(nums) 
	#count={}
	#for n in nums:
		#count[n]=1+count.get(n,0)

    # Bucket sort the characters by frequency.  # TC O(n) but only when it is uniformly distributed.
	freq=[[] for i in range(len(nums)+1)]       # For setting up the length of bucket sort array    
	for n,c in count.items():                   
		freq[c].append(n)

	res=[]
	for i in range(len(freq)-1,0,-1):
		for n in freq[i]:
			res.append(n)
			if len(res)==k:
				return res 

'''
Approach- Quick select from leetcode TC O(n) // SC O(n)

'''

from collections import Counter
import random
def topKFrequent4(nums, k):
    count = Counter(nums)
    unique = list(count.keys())
    
    def partition(left, right, pivot_index) -> int:
        pivot_frequency = count[unique[pivot_index]]
        # 1. move pivot to end
        unique[pivot_index], unique[right] = unique[right], unique[pivot_index]  
        
        # 2. move all less frequent elements to the left
        store_index = left
        for i in range(left, right):
            if count[unique[i]] < pivot_frequency:
                unique[store_index], unique[i] = unique[i], unique[store_index]
                store_index += 1

        # 3. move pivot to its final place
        unique[right], unique[store_index] = unique[store_index], unique[right]  
        
        return store_index
    
    def quickselect(left, right, k_smallest) -> None:
        """
        Sort a list within left..right till kth less frequent element
        takes its place. 
        """
        # base case: the list contains only one element
        if left == right: 
            return
        
        # select a random pivot_index
        pivot_index = random.randint(left, right)     
                        
        # find the pivot position in a sorted list   
        pivot_index = partition(left, right, pivot_index)
        
        # if the pivot is in its final sorted position
        if k_smallest == pivot_index:
             return 
        # go left
        elif k_smallest < pivot_index:
            quickselect(left, pivot_index - 1, k_smallest)
        # go right
        else:
            quickselect(pivot_index + 1, right, k_smallest)
     
    n = len(unique) 
    # kth top frequent element is (n - k)th less frequent.
    # Do a partial sort: from less frequent to the most frequent, till
    # (n - k)th less frequent element takes its place (n - k) in a sorted array. 
    # All element on the left are less frequent.
    # All the elements on the right are more frequent.  
    quickselect(0, n - 1, n - k)
    # Return top k frequent elements
    return unique[n - k:]




print(topKFrequent([1,1,1,2,2,3],2))
print(topKFrequent1([1,1,1,2,2,3],2))
print(topKFrequent2([1,1,1,2,2,3],2))
print(topKFrequent3([1,1,1,2,2,3],2))
print(topKFrequent4([1,1,1,2,2,3],2))








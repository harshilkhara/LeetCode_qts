def findKthLargest(nums,k): # Naive solution with TC O(n log n) // SC O(1)
	nums=sorted(nums)
	return nums[-k]
	#return sorted(nums) [-k]

'''
The idea is to init a heap "the smallest element first", and add all elements from the array 
into this heap one by one keeping the size of the heap always less or equal to k. That would 
results in a heap containing k largest elements of the array.
The head of this heap is the answer, i.e. the kth largest element of the array.

The time complexity of adding an element in a heap of size k is O(logk), 
and we do it N times that means O(Nlogk) time complexity for the algorithm.

In Python there is a method nlargest in heapq library which has the same
O(Nlogk) time complexity and reduces the code to one line.
This algorithm improves time complexity, but one pays with O(k) space complexity.
'''

import heapq
def findKthLargest1(nums,k): # TC O(n log k) // SC O(k)
	return heapq.nlargest(k,nums) [-1]


print(findKthLargest([3,2,3,1,2,4,5,5,6],4))
print(findKthLargest1([3,2,1,5,6,4],2))

#<-------------- Quickselect approach with TC O(n) in average case else O(n^2) // SC (1)-------->

'''
The approach is basically the same as for quicksort. For simplicity let's notice that kth largest 
element is the same as N - kth smallest element, hence one could implement kth smallest algorithm 
for this problem.

First one chooses a pivot, and defines its position in a sorted array in a linear time. 
This could be done with the help of partition algorithm.

To implement partition one moves along an array, compares each element with a pivot, and moves all 
elements smaller than pivot to the left of the pivot.

As an output we have an array where pivot is on its perfect position in the ascending sorted array, 
all elements on the left of the pivot are smaller than pivot, and all elements on the right of the 
pivot are larger or equal to pivot.

Hence the array is now split into two parts. If that would be a quicksort algorithm, one would 
proceed recursively to use quicksort for the both parts that would result in O(NlogN) time complexity.
Here there is no need to deal with both parts since now one knows in which part to search for N - kth 
smallest element, and that reduces average time complexity to O(N).

Finally the overall algorithm is quite straightforward :

Choose a random pivot.

Use a partition algorithm to place the pivot into its perfect position pos in the sorted array, 
move smaller elements to the left of pivot, and larger or equal ones - to the right.

Compare pos and N - k to choose the side of array to proceed recursively.

! Please notice that this algorithm works well even for arrays with duplicates.
'''

import random
import math
def findKthLargest2(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: int
    """
    def partition(left, right, pivot_index):
        pivot = nums[pivot_index]
        # 1. move pivot to end
        nums[pivot_index], nums[right] = nums[right], nums[pivot_index]  
        
        # 2. move all smaller elements to the left
        store_index = left
        for i in range(left, right):
            if nums[i] < pivot:
                nums[store_index], nums[i] = nums[i], nums[store_index]
                store_index += 1

        # 3. move pivot to its final place
        nums[right], nums[store_index] = nums[store_index], nums[right]  
        
        return store_index
    
    def select(left, right, k_smallest):
        """
        Returns the k-th smallest element of list within left..right
        """
        if left == right:       # If the list contains only one element,
            return nums[left]   # return that element
        
        # select a random pivot_index between 
        pivot_index = random.randint(left, right)     
                        
        # find the pivot position in a sorted list   
        pivot_index = partition(left, right, pivot_index)
        
        # the pivot is in its final sorted position
        if k_smallest == pivot_index:
             return nums[k_smallest]
        # go left
        elif k_smallest < pivot_index:
            return select(left, pivot_index - 1, k_smallest)
        # go right
        else:
            return select(pivot_index + 1, right, k_smallest)

    # kth largest is (n - k)th smallest 
    return select(0, len(nums) - 1, len(nums) - k)
print(findKthLargest2([2,1,3,5,6,4],4))
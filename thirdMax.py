def thirdMax(nums):    # TC O(n) // SC O(n)
	list(set(nums))    # converting into set removes the duplicate inputs
	n=len(nums)
	if n <3:
		return(max(nums))
	else:
		nums.remove(max(nums))  # 1st max TC O(n) to find the max 
		nums.remove(max(nums))  # 2nd max
		return max(nums)        # 3rd max

def thirdMax4(nums):   # Logically simplest one to understand but 
    nums=sorted(set(nums)) # TC O(n log n)
    if len(nums)<3:
        return nums[-1]
    return nums[-3]

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


'''
In the previous approach, we deleted the maximum and second maximum so that we could easily find the 
third maximum. We had to convert the input Array into a Set so that duplicates weren't super 
complicated to handle.
Instead of deleting items though, we could instead keep a Set of maximums we've already seen. 
Then when we are searching for a maximum, we can ignore any values that are already in the seen Set.
This will also handle duplicates elegantly—if for example we had the input set [12, 12, 4, 2, 12, 1], 
then the first value we'd put into the seen maximums Set would be 12. Then when we find the second 
maximum, the algorithm knows to ignore all the 12s.
'''
def thirdMax2(nums): # TC O(n) // SC O(1)
    
    def maximum_ignoring_seen_maximums(nums, seen_maximums):
        maximum = None
        for num in nums:
            if num in seen_maximums:
                continue
            if maximum == None or num > maximum:
                maximum = num
        return maximum

    seen_maximums = set()

    for _ in range(3):
        current_maximum = maximum_ignoring_seen_maximums(nums, seen_maximums)
        if current_maximum == None:
            return max(seen_maximums)
        seen_maximums.add(current_maximum)

    return min(seen_maximums)


'''
So far, our approaches have required multiple parses through the input array. While this is still O(n) 
in big-oh notation, it'd be good if we could solve it in a single parse. One way is to simply use a Set 
to keep track of the 3 maximum values we've seen so far. While you could achieve something similar 
using 3 variables (maximum, secondMaximum, and thirdMaximum), this is messy to work with and is poor 
programming practice.
For each number in the Array, we add it into the Set of maximums. If this causes there to be more 
than 3 numbers in the Set, then we evict the smallest number.
At the end, we check whether or not there are 3 numbers in the Set. If there are, this means the 
third maximum exists, and will be the minimum in the Set. If not, this means there was no third 
maximum, and so we should return the maximum of the Set, as per the problem requirements.
'''

def thirdMax3(nums): #The best approach with TC O(n) // SC O(1)
    maximums = set()
    for num in nums:
        maximums.add(num)
        if len(maximums) > 3:
            maximums.remove(min(maximums))
    if len(maximums) == 3:
        return min(maximums)
    return max(maximums)

print(thirdMax([3,2,5,6,12]))
print(thirdMax1([3,2,5,6,12]))
print(thirdMax2([12,12,4,2,12,1]))
print(thirdMax3([12,12,4,2,12,1]))
print(thirdMax4([3,2,5,6,3]))


#Approach 1- Hash map  (Coded up by me)
def findDuplicate(nums): # TC O(n) // SC O(n)
	hashmap={}
	for i in nums:
		if i in hashmap:
			hashmap[i]+=1
		else:
			hashmap[i]=1

	for j in nums:
		if hashmap[j]>=2:
			return j 

#Approach 2- Sort 

def findDuplicate1(nums): # TC O(n log n) // SC O(n) or O(log n) --> depending on sorting algo
	nums.sort()
	for i in range(1,len(nums)):
		if nums[i]==nums[i-1]:
			return nums[i]

#Approach 3- Set
def findDuplicate2(nums): # TC O(n) // SC O(n)
	seen=set()
	for i in nums:
		if i in seen:
			return i 
		seen.add(i)

'''
Approach 4- Negative Marking 

Intuition-  # basically using the given numbers as index and same indexes (numbers) will indicate -

For example, if the input array is [1, 3, 3, 2] then for 1, flip the number at index 1, 
making the array [1,-3,3,2]. Next, for -3 flip the number at index 3, making the array 
[1,-3,3,-2].Finally, when we reach the second 3, we'll notice that nums[3] is 
already negative, indicating that 3 has been seen before and hence is the duplicate number.

Algorithm

1) Iterate over the array, evaluating each element (let's call the current element cur).

2) Since we use negative marking, we must ensure that the current element (cur) is positive 
(i.e. if cur is negative, then use its absolute value).

3) Check if nums[cur] is negative.

	a) If it is, then we have already performed this operation for the same number, and hence 
	cur is the duplicate number. Store cur as the duplicate and exit the loop.

	b) Otherwise, flip the sign of nums[cur] (i.e. make it negative). Move to the next 
	element and repeat step 3.

4) Once we've identified the duplicate, we could just return the duplicate number. However, 
even though we were not able to meet the problem constraints, we can show that we are mindful 
of the constraints by restoring the array. This is done by changing all negative numbers to 
positive.


'''
def findDuplicate3(nums):
	for num in nums:
	    cur = abs(num)
	    if nums[cur] < 0: # If already negative, we have found our duplicate 
	        duplicate = cur
	        break
	    nums[cur] = -nums[cur] # Marking it negative 

	# Restore numbers
	for i in range(len(nums)):  # if not restored its fine too 
	    nums[i] = abs(nums[i])

	return duplicate

#Approach 5- Binary Search 

def findDuplicate4(nums): # TC O(n log n) // SC O(1)
	# 'low' and 'high' represent the range of values of the target
	low = 1
	high = len(nums) - 1

	while low <= high:
	    cur = (low + high) // 2
	    count = 0

	    # Count how many numbers are less than or equal to 'cur'
	    count = sum(num <= cur for num in nums)
	    if count > cur:
	        duplicate = cur
	        high = cur - 1
	    else:
	        low = cur + 1

	return duplicate

#Approach 6- Floyd's Tortoise and Hare (Cycle Detection)

def findDuplicate5(nums): # TC O(n) // SC O(1)
	# Find the intersection point of the two runners.
	tortoise = hare = nums[0]
	while True:
	    tortoise = nums[tortoise]
	    hare = nums[nums[hare]]
	    if tortoise == hare:
	        break

	# Find the "entrance" to the cycle.
	tortoise = nums[0]
	while tortoise != hare:
	    tortoise = nums[tortoise]
	    hare = nums[hare]

	return hare

'''
Approach 7- Array as Hashmap (iterative)

Intuition

The core intuition behind this approach is similar to that of Approach 4.1. Here as well, 
we start with index 0. Since all numbers are in the range [1,n], they will be mapped to 
indices 1 through n inclusive, and hence no number will be mapped to index 0.

The key idea is to always map the number at index 0 to its equivalent index. While in the 
recursive approach, we directly jump to the next index, in this approach, we will bring the 
number from the next index to index 0 and continue from there (effectively performing a swap).

'''

def findDuplicate6(nums): # TC O(n) // SC O(1)
	while nums[0]!=nums[nums[0]]:
		nums[nums[0]],nums[0]=nums[0],nums[nums[0]]
	return nums[0]


print(findDuplicate([1,2,2,3]))
print(findDuplicate1([1,3,4,3,2]))
print(findDuplicate2([1,3,4,3,2]))
print(findDuplicate3([1,3,4,2,2]))
print(findDuplicate4([2,2,2,2,2]))
print(findDuplicate5([2,5,9,6,9,3,8,9,7,1]))
print(findDuplicate6([2,5,9,6,9,3,8,9,7,1]))


#Approach 1- Top-Down Dynamic Programming 
from collections import defaultdict
from functools import lru_cache
def deleteAndEarn(nums):      # TC O(N+k) // SC O(N+k) k--> max elements in nums 
	points = defaultdict(int)
	max_number = 0
	# Precompute how many points we gain from taking an element
	for num in nums:
	    points[num] += num
	    max_number = max(max_number, num)

	@lru_cache(maxsize=None)
	def max_points(num):
	    # Check for base cases
	    if num == 0:
	        return 0
	    if num == 1:
	        return points[1]

	    # Apply recurrence relation
	    return max(max_points(num - 1), max_points(num - 2) + points[num])

	return max_points(max_number)

#Approach 2- Bottom-Up Dynamic Programming 

def deleteAndEarn1(nums):     # TC O(N+k) // SC O(N+k) k--> max elements in nums 
	points = defaultdict(int)
	max_number = 0
	# Precompute how many points we gain from taking an element
	for num in nums:
	    points[num] += num
	    max_number = max(max_number, num)

	# Declare our array along with base cases
	max_points = [0] * (max_number + 1)
	max_points[1] = points[1]

	for num in range(2, len(max_points)):
	    # Apply recurrence relation
	    max_points[num] = max(max_points[num - 1], max_points[num - 2] + points[num])

	return max_points[max_number] 

#Approach 3- Space Optimized Bottom-Up Dynamic programming 

def deleteAndEarn2(nums):   # TC O(N+k) // SC O(N) k--> max elements in nums 
	points = {}
	max_number = 0
	# Precompute how many points we gain from taking an element
	for num in nums:
	    points[num] = points.get(num, 0) + num
	    max_number = max(max_number, num)

	# Base cases
	two_back = 0
	one_back = points.get(1, 0)

	for num in range(2, max_number + 1):
	    two_back, one_back = one_back, max(one_back, two_back + points.get(num, 0))

	return one_back

#Approach 4- Iterate over elements

def deleteAndEarn3(nums): # TC O(N log N) // SC O(n)
	points = defaultdict(int)
	# Precompute how many points we gain from taking an element
	for num in nums:
	    points[num] += num

	elements = sorted(points.keys())
	two_back = 0
	one_back = points[elements[0]]

	for i in range(1, len(elements)):
	    current_element = elements[i]
	    if current_element == elements[i - 1] + 1:
	        # The 2 elements are adjacent, cannot take both - apply normal recurrence
	        two_back, one_back = one_back, max(one_back, two_back + points[current_element])
	    else:
	        # Otherwise, we don't need to worry about adjacent deletions
	        two_back, one_back = one_back, one_back + points[current_element]

	return one_back

#Approach 5- Best of both worlds (Approach 3 + Approach 4)

def deleteAndEarn4(nums): # TC O(n) + min(k, n log n) // SC O(n)
	points = defaultdict(int)
	max_number = 0
	for num in nums:
	    points[num] += num
	    max_number = max(max_number, num)

	two_back = one_back = 0
	n = len(points)
	if max_number < n + n * log(n, 2):    # if k < n + n log n then approach 3 
	    one_back = points[1]
	    for num in range(2, max_number + 1):
	        two_back, one_back = one_back, max(one_back, two_back + points[num])
	else: # Approach 4 
	    elements = sorted(points.keys())
	    one_back = points[elements[0]]     
	    for i in range(1, len(elements)):
	        current_element = elements[i]
	        if current_element == elements[i - 1] + 1:
	            two_back, one_back = one_back, max(one_back, two_back + points[current_element])
	        else:
	            two_back, one_back = one_back, one_back + points[current_element]

	return one_back

print(deleteAndEarn([2,2,3,3,3,4]))
print(deleteAndEarn1([2,2,3,3,3,4]))
print(deleteAndEarn2([2,2,3,3,3,4]))
print(deleteAndEarn3([2,20,20,20,21,9500]))
print(deleteAndEarn4([2,20,20,20,21,9500]))
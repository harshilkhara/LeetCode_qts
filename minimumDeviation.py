'''
The idea behind solving this question - Deviation = maximum - minimum
	1) even number can only be divided by 2 --> even number can only de decreased 
	2) odd number can only be multiplied by 2 --> odd number can only be increased 
We need to return minimum deviation

Therefore, in order to get minimum deviation we need to --
	1) Decrease the maximum (even numbers) as much as possible
	2) Increase the minimum (odd numbers) as much as possible

Approach- Simulation + Heap 

Algorithm

Step 1: Initialize a max-heap evens.

	For an even number in nums, put it directly into evens; for the odd number in nums, multiply by 
	2 and put it into evens.

Step 2: Maintain an integer minimum to keep tracking the smallest element in evens.

Step 3: Take out the maximum number in evens. Use the maximum and the maintained minimum to update 
the minimum deviation. If the maximum number is even, divide by 2 and push into evens.

Step 4: Repeat Step 3 until the maximum number in evens is odd.

Step 5: Return the minimum deviation.

Time complexity and Space complexity 

Let N be the length of nums, and M be the largest number in nums. In the worst case when M is the 
power of 2, there are log(M) possible values for M. Therefore, in the worst case, the total 
possible candidate number (denoted by K) is K = N log(M) = Nlog(M).

Time Complexity: 

O(K log(N)) = O (N log(M) log(N)). 
In worst case, we need to push every candidate number into evens, and the size of evens is 
O(N). Hence, the total time complexity is O(K .log(N)) = O(N log(M) log(N)).

Space Complexity: O(N), since there are at most NN elements in evens.

'''
import heapq
def minimumDeviation(nums): # TC O(K log n) where k= (n log m)  // SC O(n)
	# since heapq is a min-heap
	# we use negative of the numbers to mimic a max-heap
	evens = []
	minimum = float('inf')
	for num in nums:
	    if num % 2 == 0:
	        evens.append(-num) # A min-heap but - will help getting max number at evens[0]
	        minimum = min(minimum, num)
	    else:
	        evens.append(-num*2)             # Increasing odd numbers 
	        minimum = min(minimum, num*2)
	heapq.heapify(evens)
	min_deviation = float('inf')
	while evens:
	    maximum_value = -heapq.heappop(evens)     # Always pops evens[0] i.e. the first element
	    min_deviation = min(min_deviation, maximum_value-minimum)
	    if maximum_value % 2 == 0:
	        minimum = min(minimum, maximum_value//2)      # Decreasing even numbers
	        heapq.heappush(evens, -maximum_value//2)
	    else:
	        # if the maximum is odd, break and return
	        break
	return min_deviation

print(minimumDeviation([1,2,3,4]))
print(minimumDeviation([2,10,8]))
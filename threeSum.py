''' 
Very inspired from twosum.py

Approach - Two Pointers 

The implementation is straightforward - we just need to modify twoSumII to produce triplets and 
skip repeating values.

For the main function:
	Sort the input array nums.
	Iterate through the array:
		If the current value is greater than zero, break from the loop. Remaining values cannot 
		sum to zero.
		If the current value is the same as the one before, skip it.
		Otherwise, call twoSumII for the current position i.

For twoSumII function:
	Set the low pointer lo to i + 1, and high pointer hi to the last index.
	While low pointer is smaller than high:
		If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
		If sum is greater than zero, decrement hi.
		Otherwise, we found a triplet:
			Add it to the result res.
			Decrement hi and increment lo.
			Increment lo while the next value is the same as before to avoid duplicates in 
			the result.

Return the result res.

'''
def threeSum(nums):# TC O(n log n + n^2) --> O(n^2) // SC O(log n) to O(n) depending on sorting algo
	res = []
	nums.sort()
	for i in range(len(nums)):
	    if nums[i] > 0:
	        break
	    if i == 0 or nums[i - 1] != nums[i]:
	        twoSumII(nums, i, res)
	return res

def twoSumII(nums,i,res):
	lo, hi = i + 1, len(nums) - 1
	while (lo < hi):
	    sum = nums[i] + nums[lo] + nums[hi]
	    if sum < 0:
	        lo += 1
	    elif sum > 0:
	        hi -= 1
	    else:
	        res.append([nums[i], nums[lo], nums[hi]])
	        lo += 1
	        hi -= 1
	        while lo < hi and nums[lo] == nums[lo - 1]:
	            lo += 1

'''
Approach- Hashset

The main function is the same as in the Two Pointers approach above. Here, we use twoSum 
(instead of twoSumII), modified to produce triplets and skip repeating values.

For the main function:

	Sort the input array nums.
	Iterate through the array:
		If the current value is greater than zero, break from the loop. Remaining values cannot 
		sum to zero.
		If the current value is the same as the one before, skip it.
		Otherwise, call twoSum for the current position i.

For twoSum function:
	For each index j > i in A:
		Compute complement value as -nums[i] - nums[j].
		If complement exists in hashset seen:
			We found a triplet - add it to the result res.
			Increment j while the next value is the same as before to avoid duplicates in 
			the result.
		Add nums[j] to hashset seen

Return the result res.

'''

def threeSum1(nums):   # TC O(n log n + n^2) --> O(n^2) // SC O(n) due to hashset
	res = []
	nums.sort()
	for i in range(len(nums)):
	    if nums[i] > 0:
	        break
	    if i == 0 or nums[i - 1] != nums[i]:
	        twoSum(nums, i, res)
	return res

def twoSum(nums,i,res):
		seen = set()
		j = i + 1
		while j < len(nums):
		    complement = -nums[i] - nums[j]
		    if complement in seen:
		        res.append([nums[i], nums[j], complement])
		        while j + 1 < len(nums) and nums[j] == nums[j + 1]:
		            j += 1
		    seen.add(nums[j])
		    j += 1

'''
Approach- No sort 

The algorithm is similar to the hashset approach above. 
We just need to add few optimizations so that it works efficiently for repeated values:

1) Use another hashset dups to skip duplicates in the outer loop.
	Without this optimization, the submission will time out for the test case with 3,000 zeroes. 
	This case is handled naturally when the array is sorted.

2) Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate 
it once. Values in the hashmap will indicate whether we have encountered that element in the 
current iteration. When we process nums[j] in the inner loop, we set its hashmap value to i. 
This indicates that we can now use nums[j] as a complement for nums[i].
	This is more like a trick to compensate for container overheads. The effect varies by 
	language, e.g. for C++ it cuts the runtime in half. Without this trick the submission may 
	time out.
'''
def threeSum2(nums):   # TC O(n^2) // SC O(n) due to hashset
	res, dups = set(), set()
	seen = {}
	for i, val1 in enumerate(nums):
	    if val1 not in dups:
	        dups.add(val1)
	        for j, val2 in enumerate(nums[i+1:]):
	            complement = -val1 - val2
	            if complement in seen and seen[complement] == i:
	                res.add(tuple(sorted((val1, val2, complement))))
	            seen[val2] = i
	return res

print(threeSum([-1,0,1,2,-1,-4]))
print(threeSum1([-1,0,1,2,-1,-4]))
print(threeSum2([-1,0,1,2,-1,-4]))

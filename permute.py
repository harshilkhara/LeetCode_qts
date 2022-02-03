'''
Approach: Backtracking 

Backtracking is an algorithm for finding all solutions by exploring all potential candidates. 
If the solution candidate turns to be not a solution (or at least not the last one), backtracking 
algorithm discards it by making some changes on the previous step, i.e. backtracks and then try 
again.

Here is a backtrack function which takes the index of the first integer to consider as an argument 
backtrack(first).

	1) If the first integer to consider has index n that means that the current permutation is done.
	2) Iterate over the integers from index first to index n - 1.
		a) Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
		b) Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
		c) Now backtrack, i.e. swap(nums[first], nums[i]) back.

'''

def permute(nums):                           # TC O(n!) // SC O(n!)
	def backtrack(first=0):
		if first==n:                 # goal 
			# if all integers are used up    # step 1 --
			output.append(nums[:])

		for i in range(first,n):             # step 2 --
			# place i-th integer first 
            # in the current permutation
			nums[first],nums[i]=nums[i],nums[first]           # step a --
			# use next integers to complete the permutations  # step b -- 
			backtrack(first+1)                                # choose
			#backtrack                                        # step c -- 
			nums[first],nums[i]=nums[i],nums[first]

	n=len(nums)
	output=[]
	backtrack()
	return output

def permute1(nums):
	result=[]
	if len(nums)==1:
		return [nums[:]]    # Deep copy  ... read deep copy vs shallow copy 

	for i in range(len(nums)):
		n=nums.pop(0)
		perms=permute1(nums)

		for perm in perms:
			perm.append(n)
		result.extend(perms)
		nums.append(n)

	return result

print(permute([1,2,3]))
print(permute1([1,2,3]))

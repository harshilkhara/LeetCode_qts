# Approach 1- Brute Force 
def longestConsecutive(nums): # TC O(N^3) // SC O(1)
	longest_streak=1

	for i in range(len(nums)):
		current_num=nums[i]
		current_streak=1

		while current_num+1 in nums:
			current_num+=1
			current_streak+=1

		longest_streak=max(longest_streak,current_streak)

	return longest_streak 

# Approach 2- Sorting 

def longestConsecutive1(nums):
	if not nums:
	    return 0

	nums.sort()

	longest_streak = 1
	current_streak = 1

	for i in range(1, len(nums)):
	    if nums[i] != nums[i-1]:
	        if nums[i] == nums[i-1]+1:
	            current_streak += 1
	        else:
	            longest_streak = max(longest_streak, current_streak)
	            current_streak = 1

	return max(longest_streak, current_streak)


# Approach 3- Set & Intelligent Sequence Building 
# very much inspired from Approach 1 

def longestConsecutive2(nums): # TC O(n+n)= O(N) // SC O(N)
	longest_streak = 0
	num_set = set(nums)

	for num in num_set:
	    if num - 1 not in num_set: # this is the main idea 
	        current_num = num
	        current_streak = 1

	        while current_num + 1 in num_set:
	            current_num += 1
	            current_streak += 1

	        longest_streak = max(longest_streak, current_streak)

	return longest_streak

print(longestConsecutive([100,4,200,3,1,2]))
print(longestConsecutive1([100,4,200,3,1,2]))
print(longestConsecutive2([100,4,200,3,1,2]))



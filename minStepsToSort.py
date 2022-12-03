# https://ledarryl.medium.com/find-the-minimum-number-
# of-move-backs-required-to-sort-an-array-7bb2bb47ebf6
# Asked in TikTok interview 

def minStepsToSort(nums): # TC O(n log n) // SC O(n)
	expected=sorted(nums)
	sorted_idx=0
	for i in range(len(nums)):
		if nums[i]==expected[sorted_idx]:
			sorted_idx+=1

	min_moves=len(nums)-sorted_idx
	return min_moves

print(minStepsToSort([1,2,5,3,4]))
def canJumpII(nums): # TC O(n) // SC O(1)
	jumps = 0
	current_jump_end = 0
	farthest = 0
	for i in range(len(nums) - 1):
	    # we continuously find the how far we can reach in the current jump
	    farthest = max(farthest, i + nums[i])
	    # if we have come to the end of the current jump,
	    # we need to make another jump
	    if i == current_jump_end:
	        jumps += 1
	        current_jump_end = farthest
	return jumps

print(canJumpII([2,3,1,1,4]))
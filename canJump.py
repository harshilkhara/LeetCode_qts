# Approach- Greedy 
def canJump(nums): # TC O(n) // SC O(1)
	lastPos=len(nums)-1
    for i in range(len(nums)-1,-1,-1):
        if i + nums[i]>=lastPos:
            lastPos=i
    return lastPos==0

print(canJump([2,3,1,1,4]))

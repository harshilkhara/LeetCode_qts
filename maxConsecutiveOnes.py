def maxConsecutiveOnes(nums): # TC O(n) // SC O(1)
	count=max_count=0
	for i in nums:
		if i == 1:
			count+=1
		else:
			max_count=max(max_count,count)
			count=0
	return max(max_count,count)


def maxConsecutiveOnes1(nums):
	return max(map(len, ''.join(map(str, nums)).split('0')))


print(maxConsecutiveOnes([0,1,1,0,1,1,1]))
print(maxConsecutiveOnes1([1,0,1,1,0,1]))

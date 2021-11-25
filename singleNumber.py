def singleNumber(nums):  # TC O(n) // SC O(n)
	hash={}
	for i in nums:
		if i in hash:
			hash[i]+=1
		else:
			hash[i]=1

	for j in nums:
		if hash[j]==1:
			return j
	return -1

def singleNumber1(nums):     # TC O(n)   //SC O(1)
	x=0
	for i in nums:
		x=x ^ i
	return x


print(singleNumber([4,2,1,2,1]))
print(singleNumber1([4,2,1,2,1]))
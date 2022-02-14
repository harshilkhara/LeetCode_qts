def selfDescriptiveNumber(nums): #TC O(n) // SC O(n)
	nums=str(nums)
	hashmap={}
	for i,n in enumerate(nums):
		n=int(n)
		if n in hashmap:
			hashmap[n]+=1
		else:
			hashmap[n]=1
		if i not in hashmap:
			hashmap[i]=0

	for i,n in enumerate(nums):
		n=int(n)
		if n==hashmap[i]:
			continue 
		else:
			return False 
	return True 

print(selfDescriptiveNumber(2020))
print(selfDescriptiveNumber(2012))
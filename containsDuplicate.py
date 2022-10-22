def containsDuplicate(nums): # TC O(n) // SC O(n)
	return len(set(nums)) < len(nums)

def containsDuplicate1(nums): # TC O(n) // SC O(n)
	seen=set()
	for num in nums:
		if num in seen:
			return True 
		seen.add(num)
	return False 

print(containsDuplicate([1,2,3,1]))
print(containsDuplicate1([1,2,3,1]))



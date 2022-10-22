# Approach 1- HashMap (Very much inspired from twosum)
def containsNearbyDuplicate(nums,k): # TC O(n) // SC O(n)
	hmap={}
	for i,j in enumerate(nums):
		if j in hmap and i-hmap[j]<=k:
			return True 
		hmap[j]=i 
	return False 

# Approach 2- Sliding window 
def containsNearbyDuplicate1(nums,k): # TC O(n) // SC O(k)
	seen=set()
	for i in range(len(nums)):
		if nums[i] in seen:
			return True 
		seen.add(nums[i])
		if len(seen)>k: # window constraint
			seen.remove(nums[i-k])
	return False 

print(containsNearbyDuplicate([1,2,3,1],3))
print(containsNearbyDuplicate1([1,2,3,1],3))
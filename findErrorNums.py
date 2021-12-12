import collections
def findErrorNums(nums): # TC O(n) // SC O(n) 
	rep,mis=None, None
	n=len(nums)
	lookup=collections.Counter(nums)
	for i in range(1,n+1):
		if i not in lookup: 
			mis=i
		if lookup[i]>1:
			rep=i
	return [rep,mis]
 
def findErrorNums1(nums):  # Brute Force Method -- TC O(n^2) // SC O(1)
    dup=None
    mis=None
    for i in range(1,len(nums)+1):
        count=0
        for j in range (len(nums)):
            if nums[j]==i:
                count+=1
        if count==2:
            dup=i
        elif count==0:
            mis=i
    return [dup,mis]

print(findErrorNums([1,2,2,4]))
print(findErrorNums1([1,1]))
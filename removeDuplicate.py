def removeDuplicates(nums):
    if len(nums)<=1:
        return len(nums)
    i=1
    j=1
    while i<len(nums):
        if nums[i]!=nums[i-1]:
            nums[j]=nums[i]
            j=j+1
        i=i+1
    return j,nums

nums=[0,0,1,1,1,2,2,3,3,4]
ans=removeDuplicates(nums)
print(ans)

                

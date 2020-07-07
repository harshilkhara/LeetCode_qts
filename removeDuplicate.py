def removeDuplicates(nums):
    n=len(nums)
    if n<=1:
        return n
    i=j=1
    while i<n:
        if nums[i]!=nums[i-1]: #unique element found 
            nums[j]=nums[i]
            j=j+1
        i=i+1
    return j,nums

nums=[0,0,1,1,1,2,2,3,3,4,6]
ans=removeDuplicates(nums)
print(ans)

                

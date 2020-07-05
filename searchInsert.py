def searchInsert(nums,target):
    nums.append(target)
    nums.sort()
    for i,j in enumerate(nums):
        if target ==j:
            return i,nums[i] #i --> index; nums[i]--> actual number; also nums[i]=j
        
        
nums=[1,3,4,5,7,15]
target=int(input("Enter the target number: "))
ans=searchInsert(nums,target)
print(ans)

           

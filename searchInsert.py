#Approach 1- Brute Force
def searchInsert(nums,target): # TC O(n log n) // SC O(1)
    nums.append(target)
    nums.sort()
    for i,j in enumerate(nums):
        if target ==j:
            return i #i --> index; nums[i]--> actual number; also nums[i]=j

#Approach 2- Binary Search         
def searchInsert1(nums,target): # TC O(log n) // SC O(1)
    l,r=0,len(nums)-1
    while l<=r:
        mid=(l+r)//2
        if nums[mid]==target:
            return mid 
        elif nums[mid] < target:
            l=mid+1
        else:
            r=mid-1 
    return l

print(searchInsert([1,3,5,6],7))
print(searchInsert1([1,3,5,6],2))

           

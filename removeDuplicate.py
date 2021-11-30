def removeDuplicates(nums): # TC O(n) // SC O(1)
    n=len(nums)
    if n<=1:
        return n
    i=next_non_duplicate=1     #i will be used to iterate through the list 
    while i<n:
        if nums[i]!=nums[next_non_duplicate-1]: #unique element found 
            nums[next_non_duplicate]=nums[i]
            next_non_duplicate=next_non_duplicate+1
        i=i+1
    return next_non_duplicate

nums=[0,0,1,1,1,2,2,3,3,4,6]
ans=removeDuplicates(nums)
print(ans)

                
'''
In this problem, we need to remove the duplicates in-place such that the resultant length 
of the array remains sorted. As the input array is sorted, therefore, one way to do this is 
to shift the elements left whenever we encounter duplicates. In other words, we will keep 
one pointer for iterating the array and one pointer for placing the next non-duplicate number. 
So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move 
it next to the last non-duplicate number we’ve seen.
'''

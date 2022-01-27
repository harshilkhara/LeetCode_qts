'''
Approach- Two pointers 

The two pointers pattern requires the array to be sorted, so we do that first. As our BCR is O(n^2)
the sort operation would not change the overall time complexity.

In the sorted array, we process each value from left to right. For value v, we need to find a 
pair which sum, ideally, is equal to target - v. We will follow the same two pointers approach as 
for 3Sum, however, since this 'ideal' pair may not exist, we will track the smallest absolute 
difference between the sum and the target. The two pointers approach naturally enumerates pairs so 
that the sum moves toward the target.

'''
def threeSumClosest(nums,target): # TC O(n^2) // SC O(log n) or O(n) depending on sorting algo
    diff=float('inf') # Minimum difference should be high during initialization 
    nums.sort()
    for i in range(len(nums)):
        l,r=i+1,len(nums)-1
        while l<r:
            sum=nums[i]+nums[l]+nums[r]
            if abs(target-sum) < abs(diff):# Update the diff if it even more lower than the prev one
                diff=target-sum
            if sum < target:
                l+=1
            else:
                r-=1
        if diff==0:
            break #return target could also work 
    return target-diff       # The more the difference is low, sum would be even closer to target

print(threeSumClosest([-1,2,1,-4],1))
'''
Approach- Binary Search

In the two pointers approach, we fix one number and use two pointers to enumerate pairs. 
Here, we fix two numbers, and use a binary search to find the third complement number. This is less 
efficient than the two pointers approach, however, it could be more intuitive to come up with.

Note that we may not find the exact complement number, so we check the difference between the 
complement and two numbers: the next higher and the previous lower. For example, if the complement 
is 42, and our array is [-10, -4, 15, 30, 60], the next higher is 60 (so the difference is -18), and 
the previous lower is 30 (and the difference is 12).

import bisect_right
def threeSumClosest1(nums,target):  # TC O(n^2 log n) // SC O(log n) or O(n)
    diff = float('inf')
    nums.sort()
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            complement = target - nums[i] - nums[j]
            hi = bisect_right(nums, complement, j + 1)
            lo = hi - 1
            if hi < len(nums) and abs(complement - nums[hi]) < abs(diff):
                diff = complement - nums[hi]
            if lo > j and abs(complement - nums[lo]) < abs(diff):
                diff = complement - nums[lo]
        if diff == 0:
            break
    return target - diff


print(threeSumClosest1([-1,2,1,-4],1))
'''


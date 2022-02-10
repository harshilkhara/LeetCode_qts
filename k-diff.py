#Approach 1 -Brute Force 

def findPairs(nums,k): # TC O(n log n) + O(n^2) --> O(n^2) // SC O(n)+O(1) --> O(n)
    s_nums = sorted(nums) # TC O(n log n) // SC O(n) or O(log n)
    result = 0
    for i in range(len(s_nums)):
        if (i > 0 and s_nums[i] == s_nums[i - 1]):
            continue
        for j in range(i + 1, len(s_nums)):
            if (j > i + 1 and s_nums[j] == s_nums[j - 1]):
                continue
            if abs(s_nums[j] - s_nums[i] == k):
                result += 1
    return result

'''
Approach 2- Two Pointers 

Take the difference between the numbers which left and right pointers point.

If it is less than k, we increment the right pointer.
    If left and right pointers are pointing to the same number, we increment the right pointer too.
If it is greater than k, we increment the left pointer.
If it is exactly k, we have found our pair, we increment our placeholder result and increment left 
pointer.

The idea behind the behavior of incrementing left and right pointers in the manner above is similar 
to:

Extending the range between left and right pointers when the difference between left and right 
pointers is less than k (i.e. the range is too small).
    Therefore, we extend the range (by incrementing the right pointer) when left and right pointer 
    are pointing to the same number.
Contracting the range between left and right pointers when the difference between left and right 
pointers is more than k (i.e. the range is too large).

This is the core of the idea but there is another issue which we have to take care of to make 
everything work correctly. We have to make sure duplicate pairs are not counted repeatedly. 
In order to do so, whenever we have a pair whose difference matches with k, we keep incrementing the 
left pointer as long as the incremented left pointer points to the number which is equal to the 
previous number.

'''

def findPairs1(nums,k): # TC O(n log n) // SC O(n)+O(1) --> O(n)
    nums = sorted(nums) # TC O(n log n) // SC O(n) or O(log n)
    left = 0
    right = 1
    result = 0
    while (left < len(nums) and right < len(nums)):
        if (left == right or nums[right] - nums[left] < k): # nums[r]-nums[l] is target
            # List item 1 in the text
            right += 1
        elif nums[right] - nums[left] > k:
            # List item 2 in the text
            left += 1
        else:
            # List item 3 in the text
            left += 1
            result += 1
            while (left < len(nums) and nums[left] == nums[left - 1]):
                left += 1
    return result

#Approach 3- Hashmap 

from collections import Counter
def findPairs2(nums,k):  # TC O(n)   // SC O(n)
    result = 0
    counter = Counter(nums)
    for x in counter:
        if k > 0 and x + k in counter:
            result += 1
        elif k == 0 and counter[x] > 1:
            result += 1
    return result

#Approach- Hashmap but from YouTube

import collections
def findPairs3(nums,k):              # TC O(n)   // SC O(n)
    c=collections.Counter(nums)
    count=0
    if k==0:
        for key,v in c.items(): # c.items() returns dic as a tuple [("key","value")]
            if v > 1:
                count+=1
    else:
        for key,v in c.items():
            if key+k in c:
                count+=1
    return count
    
print(findPairs([-1,-2,-3],1))
print(findPairs1([3,1,4,1,5],2))
print(findPairs2([1,2,3,4,5],1))
print(findPairs3([1,3,1,5,4],0))

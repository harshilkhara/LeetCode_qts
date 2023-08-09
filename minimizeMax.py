class Solution:
# Approach 1- Greedy + Binary Search
    def validCountPairs(self, nums, threshold): # TC O(n log n) SC O(1)
        count, index=0,0 
        while index<len(nums)-1:
            if nums[index+1]-nums[index]<=threshold:
                index+=1
                count+=1
            index+=1
        return count 
        
    def minimizeMax(self, nums, p):
        nums.sort()
        left, right = 0, nums[-1]-nums[0]
        while left < right:
            mid=left+(right-left)//2 
            if self.validCountPairs(nums, mid)>=p:
                right=mid 
            else:
                left=mid+1 
        
        return left 

s=Solution()
print(s.minimizeMax([10,1,2,7,1,3], 2))

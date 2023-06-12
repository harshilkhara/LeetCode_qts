class Solution:
# Approach 1- Fixed left bound
    def summaryRanges(self, nums): # TC O(n) // SC O(1)
        ranges = []     
        i = 0 
        
        while i < len(nums): 
            start = nums[i]  
            while i + 1 < len(nums) and nums[i] + 1 == nums[i + 1]: 
                i += 1 
            
            if start != nums[i]: 
                ranges.append(str(start) + "->" + str(nums[i]))
            else: 
                ranges.append(str(nums[i]))
            
            i += 1

        return ranges

s=Solution()
print(s.summaryRanges([0,1,2,4,5,7]))
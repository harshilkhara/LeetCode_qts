class Solution:
# Approach 1- Sliding window
    def longestSubarray(self, nums): # TC O(n) // SC O(1)
        left, right=0,0
        ans, zeroCount=0,0
        while right<len(nums):
            zeroCount+=1 if nums[right]==0 else 0
            
            while zeroCount>1:
                zeroCount-=1 if nums[left]==0 else 0
                left+=1
            
            ans=max(ans, right-left)
            right+=1
        
        return ans

s=Solution()
print(s.longestSubarray([1,1,0,1]))

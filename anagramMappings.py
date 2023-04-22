class Solution:
# Approach 1- Brute Force
    def anagramMappings(self, nums1, nums2): # TC O(n^2) // SC O(1)
        ans=[]
        for num1 in nums1:
            for i, num2 in enumerate(nums2):
                if num1==num2:
                    ans.append(i)
                    break 
        
        return ans

# Approach 2- Hashmap 
    def anagramMappings(self, nums1, nums2): # TC O(n) // SC O(n)
        ans=[]
        hmap={}
        for i, num2 in enumerate(nums2):
            hmap[num2]=i
            
        for num1 in nums1:
            ans.append(hmap[num1])
        
        return ans
            
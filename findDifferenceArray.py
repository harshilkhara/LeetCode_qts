class Solution:
# Approach 1- HashSet
    def findDifference(self, nums1, nums2): # TC O(n+m) // SC O(max(n, m))
        seen=set(nums2)
        answer=[set() for _ in range(2)]
        for num1 in nums1:
            if num1 not in seen:
                answer[0].add(num1)
        
        seen.clear()
        seen=set(nums1)
        for num2 in nums2:
            if num2 not in seen:
                answer[1].add(num2)
        
        return answer

s=Solution()
print(s.findDifference([1,2,3],[2,4,6]))
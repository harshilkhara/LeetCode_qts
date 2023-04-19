class Solution:
# Approach 1- Binary Search on descending array
    def maxDistance(self, nums1, nums2): # TC O(m log n) // SC O(1)
        m, n = len(nums1), len(nums2)
        ans = 0

        # Iterate over nums1 and find insertion position to nums2.
        nums2.reverse()
        for i in range(m):
            k = bisect.bisect_left(nums2, nums1[i])
            ans = max(ans, n - k - 1 - i)
        return ans

# Approach 2- Two Pointers 
    def maxDistance1(self, nums1, nums2): # TC O(m+n) // SC O(1)
        ans = 0
        p1, p2 = 0, 0
        
        while p1 < len(nums1) and p2 < len(nums2):
            # If p1 is larger, we should move on to a smaller p1.
            if nums1[p1] > nums2[p2]:
                p1 += 1
                
            # Otherwise, get their distance and move on to a smaller p2.
            else: 
                ans = max(ans, p2 - p1)
                p2 += 1
        
        return ans

s=Solution()
print(s.maxDistance([55,30,5,4,2],[100,20,10,10,5]))
print(s.maxDistance1([55,30,5,4,2],[100,20,10,10,5]))

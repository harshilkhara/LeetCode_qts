class Solution:
# Approach 1- Prefix Sum
    def getAverages(self, nums, k): # TC O(n) // SC O(n)
        # When a single element is considered then its averafge will be the number itself only.
        if k == 0:
            return nums

        n = len(nums)
        averages = [-1] * n

        # Any index will not have 'k' elements in it's left and right.
        if 2 * k + 1 > n:
            return averages

        # Generate 'prefix' array for 'nums'.
        # 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        # We iterate only on those indices which have atleast 'k' elements in their left and right.
        # i.e. indices from 'k' to 'n - k'
        for i in range(k, n - k):
            leftBound, rightBound = i - k, i + k
            subArraySum = prefix[rightBound + 1] - prefix[leftBound]
            average = subArraySum // (2 * k + 1)
            averages[i] = average

        return averages

# Approach 2- Sliding Window
    def getAverages1(self, nums, k): # TC O(n) // SC O(1)
        averages = [-1] * len(nums)
        # When a single element is considered then its average will be the number itself only.
        if k == 0:
            return nums

        n = len(nums)

        # Any index will not have 'k' elements in it's left and right.
        if 2 * k + 1 > n:
            return averages

        # First get the sum of first window of the 'nums' arrray.
        window_sum = sum(nums[:2 * k + 1])
        averages[k] = window_sum // (2 * k + 1)

        # Iterate on rest indices which have at least 'k' elements 
        # on its left and right sides.
        for i in range(2 * k + 1, n):
            # We remove the discarded element and add the new element to get current window sum.
            # 'i' is the index of new inserted element, and
            # 'i - (window size)' is the index of the last removed element.
            window_sum = window_sum - nums[i - (2 * k + 1)] + nums[i]
            averages[i - k] = window_sum // (2 * k + 1)

        return averages

s=Solution()
print(s.getAverages([7,4,3,9,1,8,5,2,6],3))
print(s.getAverages1([7,4,3,9,1,8,5,2,6],3))
class Solution:
# Approach 1- Binary Search
    def minimumTime(self, time, totalTrips): # TC O(n log(m.k)) // SC O(1)
        # Initialize the left and right boundaries.
        left, right = 1, max(time) * totalTrips

        # Can these buses finish 'totalTrips' of trips in 'given_time'?
        def timeEnough(given_time):
            actual_trips = 0
            for t in time:
                actual_trips += given_time // t
            return actual_trips >= totalTrips
        
        # Binary search to find the minimum time to finish the task.
        while left < right:
            mid = (left + right) // 2
            if timeEnough(mid):
                right = mid
            else:
                left = mid + 1
        return left

s=Solution()
print(s.minimumTime([1,2,3],5))
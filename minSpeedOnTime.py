import math
class Solution:
# Approach 1- Binary Search
# Very similar to minEatingSpeed.java & .py
	def minSpeedOnTime(self, dist, hour): # TC O(n log k) SC O(1)
		left,right=1, 10_000_000+1
		minSpeed=-1

		def timeRequired(dist, speed):
			time=0.0 
			for i in range(len(dist)):
				t= dist[i]/speed 
				time+= math.ceil(t) if i!=len(dist)-1 else t 

			return time  

		while left < right:
			mid=left+(right-left)/2
			if timeRequired(dist, mid)<=hour:
				right=mid
				minSpeed=mid 
			else:
				left=mid+1 

		return int(minSpeed)

s=Solution()
print(s.minSpeedOnTime([1,3,2], 2.7))

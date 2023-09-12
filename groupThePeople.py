from collections import defaultdict
# Approach 1- Greedy
class Solution: # TC O(n) SC O(n)
	def groupThePeople(self, groupSizes):
		groups=defaultdict(list)
		ans=[]

		for i, size in enumerate(groupSizes):
			groups[size].append(i)

			if len(groups[size])==size:
				ans.append(groups.pop(size))

		return ans

s=Solution()
print(s.groupThePeople([3,3,3,3,3,1,3]))
# Approach 1- Greedy
def findMinArrowShots(points): # TC O(n log n) // SC O(n) --> timsort algo
	if not points: return 0
	points.sort(key= lambda x:x[1])
	firstEnd=points[0][1]
	arrows=1
	for start,end in points:
		# if the current balloon starts after the end of another one,
        # one needs one more arrow
		if firstEnd<start:
			arrows+=1
			firstEnd=end 

	return arrows 

print(findMinArrowShots([[10,16],[2,8],[1,6],[7,12]]))
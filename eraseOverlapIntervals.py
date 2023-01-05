# Approach 1- Greedy method
def eraseOverlapIntervals(intervals): # TC O(n log n) // SC O(n)
	intervals.sort(key= lambda x:x[1])
	firstEnd=intervals[0][1]
	remove=0
	for start,end in intervals[1:]:
		# If overlapping
	    if start<firstEnd:
	        remove+=1
	    else:
	    	firstEnd=end

	return remove

print(eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))


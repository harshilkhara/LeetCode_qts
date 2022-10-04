# Approach 1- Two Pointers 
def minCost(colors,neededTime): # TC O(n) // SC O(n)
	# Initalize two pointers i, j.
	total_time = 0
	i, j = 0, 0

	while i < len(neededTime) and j < len(neededTime):
	    curr_total = 0
	    curr_max = 0
	    
	    # Find all the balloons having the same color as the 
	    # balloon indexed at i, record the total removal time 
	    # and the maximum removal time.
	    while j < len(neededTime) and colors[i] == colors[j]:
	        curr_total += neededTime[j]
	        curr_max = max(curr_max, neededTime[j])
	        j += 1
	    
	    # Once we reach the end of the current group, add the cost of 
	    # this group to total_time, and reset two pointers.
	    total_time += curr_total - curr_max
	    i = j

	return total_time

# Approach 2- Advanced 1- Pass 
def minCost1(colors,neededTime): # TC O(n) // SC O(1)
	# totalTime: total time needed to make rope colorful;
	# currMaxTime: maximum time of a balloon needed in this group.
    total_time = 0
    curr_max_time = 0
    
    # For each balloon in the array:
    for i in range(len(colors)):
        # If this balloon is the first balloon of a new group
        # set the curr_max_time as 0.
        if i > 0 and colors[i] != colors[i - 1]:
            curr_max_time = 0
        
        # Increment total_time by the smaller one.
        # Update curr_max_time as the larger one.
        total_time += min(curr_max_time, neededTime[i])
        curr_max_time = max(curr_max_time, neededTime[i])
            
    # Return total_time as the minimum removal time.
    return total_time

print(minCost("abaac",[1,2,3,4,5]))
print(minCost1("abaac",[1,2,3,4,5]))
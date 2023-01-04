import collections
# Approach 1- HashMap & Counting
def minimumRounds(tasks): # TC O(n) // SC O(n)
	taskmap=collections.Counter(tasks)
	rounds=0
	for count in taskmap.values():
		if count==1:
			return -1

		if count%3==0:
			rounds+=count/3 
		else:
			rounds+=count//3+1 

	return int(rounds) 

print(minimumRounds([2,2,3,3,2,4,4,4,4,4]))

#Approach 1- DFS [using call-stack]
def numsSameConsecDiff(n,k): # TC O(2^n) // SC O(2^n)
	if n == 1:
	    return [i for i in range(10)]

	ans = []
	def DFS(n, num):
	    # base case
	    if n == 0:
	        return ans.append(num)

	    tail_digit = num % 10
	    # using set() to avoid duplicates when K == 0
	    next_digits = set([tail_digit + k, tail_digit - k])

	    for next_digit in next_digits:
	        if 0 <= next_digit < 10:
	            new_num = num * 10 + next_digit
	            DFS(n-1, new_num)

	for num in range(1, 10):
	    DFS(n-1, num)

	return list(ans)

#Approach 2- BFS [using queue]
def numsSameConsecDiff1(n,k): # TC O(2^n) // SC O(2^n)
	if n == 1:
		return [i for i in range(10)]

	# initialize the queue with candidates for the first level
	queue = [digit for digit in range(1, 10)]

	for level in range(n-1):
	    next_queue = []
	    for num in queue:
	        tail_digit = num % 10
	        # using set() to avoid duplicates when K == 0
	        next_digits = set([tail_digit + k, tail_digit - k])

	        for next_digit in next_digits:
	            if 0 <= next_digit < 10:
	                new_num = num * 10 + next_digit
	                next_queue.append(new_num)
	    # start the next level
	    queue = next_queue

	return queue

print(numsSameConsecDiff(3,7))
print(numsSameConsecDiff1(3,7))

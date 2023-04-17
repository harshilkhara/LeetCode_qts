from collections import deque
# Approach 1- Brute Force 
def dailyTemperatures(temperatures): # TC O(n^2) // SC O(1)
	ans=[0]*len(temperatures)
	for i in range(len(temperatures)):
		for j in range(i+1,len(temperatures)):
			if temperatures[j]>temperatures[i]:
				ans[i]=j-i 
				break 

	return ans 

# Approach 2- Decreasing Monotonic Stack
def dailyTemperatures1(temperatures): # TC O(n) // SC O(n)
	deq=deque()
	ans=[0]*len(temperatures)
	for i in range(len(temperatures)):
		currTemp=temperatures[i]
		while deq and temperatures[deq[-1]]<currTemp:
			prevDay=deq.pop()
			ans[prevDay]=i-prevDay 
		deq.append(i)

	return ans

# Approach 3- Array, Optimizied space
def dailyTemperatures2(temperatures): # TC O(n) // SC O(1)
	n = len(temperatures)
	hottest = 0
	answer = [0] * n

	for curr_day in range(n - 1, -1, -1):
	    current_temp = temperatures[curr_day]
	    if current_temp >= hottest:
	        hottest = current_temp
	        continue
	    
	    days = 1
	    while temperatures[curr_day + days] <= current_temp:
	        # Use information from answer to search for the next warmer day
	        days += answer[curr_day + days]
	    answer[curr_day] = days

	return answer 

print(dailyTemperatures([73,74,75,71,69,72,76,73]))
print(dailyTemperatures1([73,74,75,71,69,72,76,73]))
print(dailyTemperatures2([73,74,75,71,69,72,76,73]))
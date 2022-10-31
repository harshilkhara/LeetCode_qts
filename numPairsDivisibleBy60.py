import collections
# Very similar to twoSUm.java and .py if you think about it 
# Approach 1- Brute Force 
def numPairsDivisibleBy60(time):
	ret, n = 0, len(time)
	for i in range(n):
	    # j starts with i+1 so that i is always to the left of j
	    # to avoid repetitive counting
	    for j in range(i + 1, n):
	        ret += (time[i] + time[j]) % 60==0
	return ret

# Approach 2- HashMap
def numPairsDivisibleBy601(time):
	remainders = collections.defaultdict(int)
	ret = 0
	for t in time:
	    if t % 60 == 0: # check if a%60==0 && b%60==0
	        ret += remainders[0]
	    else: # check if a%60+b%60==60
	        ret += remainders[60-t%60]
	    remainders[t % 60] += 1 # remember to update the remainders
	return ret


print(numPairsDivisibleBy60([40,20,60]))
print(numPairsDivisibleBy601([60,30,60]))
print(numPairsDivisibleBy601([30,20,150,100,40]))
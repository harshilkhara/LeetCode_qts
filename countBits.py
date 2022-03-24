'''
Approach 1- Pop Count

Used hammingWeight.py as a part function to count bits in a binary bit 

'''
def countBits(n):
	def pop_count(x): # TC O(n log n) // SC O(1)
		count = 0
		while x != 0:
		    x &= x - 1 # zeroing out the least significant nonzero bit
		    count += 1
		return count

	ans = [0] * (n + 1)
	for x in range(n + 1):
		ans[x] = pop_count(x)

	return ans          

'''
Approach 2- DP + Most Significant Bit 

Use previous count results to generate the count for a new integer.
P(x + b) = P(x) + 1 --> this is the main idea 

'''
def countBits1(n): # TC O(n) // SC O(1)
	ans = [0] * (n + 1)
	x = 0
	b = 1

	# [0, b) is calculated
	while b <= n:
	    # generate [b, 2b) or [b, n) from [0, b)
	    while x < b and x + b <= n:
	        ans[x + b] = ans[x] + 1
	        x += 1
	    x = 0 # reset x
	    b <<= 1 # b = 2b

	return ans    

'''
Approach 3- DP + Least significant bit 

We can have different transition functions, as long as x' is smaller than x and 
their pop counts have a function.

P(x)=P(x/2) + x mod 2 --> this is the main idea 

'''
def countBits2(n): # TC O(n) // SC O(1)
	ans = [0] * (n + 1)
	for x in range(1, n + 1):
	    # x // 2 is x >> 1 and x % 2 is x & 1
	    ans[x] = ans[x >> 1] + (x & 1) 
	return ans

'''
Approach 4- DP + Last bit set 

With the same logic as previous approaches, we can also manipulate the last set bit.

Last set bit is the rightmost set bit. Setting that bit to zero with the bit trick, x &= x - 1, 
leads to the following transition function:

P(x)=P(x & (x-1)) + 1

'''
def countBits3(n): # TC O(n) // SC O(1)
	ans = [0] * (n + 1)
	for x in range(1, n + 1):
	    ans[x] = ans[x & (x - 1)] + 1
	return ans 

print(countBits(2))
print(countBits1(4))  
print(countBits2(5)) 
print(countBits3(7))
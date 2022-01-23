'''
Approach- Sliding window 

1) Initialize sample string "123456789". This string contains all integers that have sequential 
   digits as substrings. Let's implement sliding window algorithm to generate them.

2) Iterate over all possible string lengths: from the length of low to the length of high.

	a) For each length iterate over all possible start indexes: from 0 to 10 - length.

	b) Construct the number from digits inside the sliding window of current length.

	c) Add this number in the output list nums, if it's greater than low and less than high.

3) Return nums.

TC O(1) because- Length of sample string is 9, and lengths of low and high are between 2 and 9. 
Hence the nested loops are executed no more than 8 X 8 = 648×8=64 times.
SC O(1) because- O(1) to keep not more than 36 integers with sequential digits.

'''
def sequentialDigits(low,high): # TC O(1) // SC O(1) i.e. runs in constant time and space 
	sample="123456789"
	n=10
	nums=[]
	for length in range(len(str(low)),len(str(high))+1):
		for start in range(n-length):
			num=int(sample[start:start+length])
			if num >=low and num<=high:
				nums.append(num)
	return nums
'''
Approach- Precomputation

Actually, there are 36 integers with the sequential digits. 
Here is how we calculate it.
Starting from 9 digits in the sample string, one could construct 9 - 2 + 1 = 8 integers 
of length 2, 9 - 3 + 1 = 7 integers of length 3, and so on and so forth. In total, 
it would make 8 + 7 + ... + 1 = 36 integers.
As one can see, we could precompute the results all at once and then select the integers 
that are less than high and greater than low.
'''

def sequentialDigits1(low,high): # TC O(1) // SC O(1) i.e. runs in constant time and space 
	sample="123456789"
	def precomputation():
		sample = "123456789"
		n = 10
		nums = []

		for length in range(2, n):
		    for start in range(n - length):
		        nums.append(int(sample[start: start + length]))
		return nums
	result=precomputation()
	return [x for x in result if x >= low and x <= high]

print(sequentialDigits(100,300))
print(sequentialDigits1(100,300))


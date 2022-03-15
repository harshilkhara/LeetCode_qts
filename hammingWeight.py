'''
Find number of 1 bits in n

Approach 1- loop and flip 

The solution is straight-forward. We check each of the 32 bits of the number. 
If the bit is 1, we add one to the number of 1-bits.

We can check the ith bit of a number using a bit mask. We start with a mask m=1, 
because the binary representation of 1 is,

00000000000000000000000000000001 Clearly, a logical AND between any number and the mask 1 
gives us the least significant bit of this number. To check the next bit, we shift the mask to the 
left by one.

00000000000000000000000000000000010

And so on.
'''
def hammingWeight(n):
	bits,mask=0,1
	for i in range(32):
		if (n & mask)!=0:
			bits+=1
		mask<<=1
	return bits

'''
Approach 2- Bit Manipulation trick

We can make the previous algorithm simpler and a little faster. Instead of checking every bit 
of the number, we repeatedly flip the least-significant 1-bit of the number to 0, and add 1 
to the sum. As soon as the number becomes 0, we know that it does not have any more 1-bits, 
and we return the sum.

The key idea here is to realize that for any number n, doing a bit-wise AND of n and n−1 
flips the least-significant 1-bit in n to 0. Why? Consider the binary representations of n 
and n−1.

'''
def hammingWeight1(n): # TC O(1) --> n always a 32-bit integer // SC O(1)
	sum=0
	while n!=0:
		sum+=1
		n&=(n-1)
	return sum 

print(hammingWeight(0100000001))
print(hammingWeight1(0000000001))

'''

Why SC is O(n)?
Although we perform the operation in-place (i.e. on the input list itself), in the worst scenario, 
we would need to allocate an intermediate space to hold the result, which contains the N+1 
elements. Hence the overall space complexity of the algorithm is O(N). 

'''
def plusOne(digits): # TC O(n) // SC O(n)  
	n = len(digits)
	# move along the input array starting from the end
	for i in range(n):
	    idx = n - 1 - i
	    # set all the nines at the end of array to zeros
	    if digits[idx] == 9:
	        digits[idx] = 0
	    # here we have the rightmost not-nine
	    else:
	        # increase this rightmost not-nine by 1
	        digits[idx] += 1
	        # and the job is done
	        return digits

	# we're here because all the digits are nines
	return [1] + digits

print(plusOne([1,2,3]))
print(plusOne([9,9]))
print(plusOne([1,2,9]))
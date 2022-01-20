# Approach- Brute force 
def minEatingSpeed(piles, h): # TC O(n m) // SC O(1)  n=len(piles), m=upper bound of piles
	speed = 1                 # NOTE- Works but times outs 
	while True:
	    hour_spent=0
	    for i in piles:
	        hour_spent+=math.ceil(i/speed)
	    if hour_spent<=h:
	        return speed
	    else:
	        speed+=1

# Approach- Binary search 

import math
def minEatingSpeed1(piles,h):   # TC O(n log m) // SC O(1)
	left,right=1,max(piles)

	while left<right:
		hour_spent=0
		middle=(left+right)//2
		for i in piles:
			hour_spent+=math.ceil(i/middle)

		if hour_spent<=h:
			right=middle
		else:
			left=middle+1

	return right

print(minEatingSpeed([3,6,7,11],8))
print(minEatingSpeed1([30,11,23,4,20],6))





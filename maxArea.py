#Approach - Two Pointers
def maxArea(height): # TC O(n) // SC O(1)
	maxArea=0
	l=0
	r=len(height)-1
	while l < r:
	    maxArea=max(maxArea,min(height[l],height[r])*(r-l)) # we know width:(r-l) is always going to
	    if height[l]<height[r]:                             # decrease 
	        l+=1
	    else:
	        r-=1
	return maxArea

#Approach- Brute Force 

def maxArea1(height):
	maxArea=0
	for i in range(len(height)):
		for j in range(i+1,len(height)):
			maxArea=max(maxArea,min(height[i],height[j])*(j-i))
	return maxArea

print(maxArea([1,8,6,2,5,4,8,3,7]))
print(maxArea1([10,10,6,2,5,4,8,3,10]))

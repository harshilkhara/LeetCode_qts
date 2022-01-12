def maximumUnits(boxTypes, truckSize): # TC O(n log n) // SC O(1)
	boxTypes.sort(key=lambda x:x[1], reverse=True)
	#Another way of writing above line of code, 
	#boxTypes.sort(key=lambda x:-x[1])
	print(boxTypes)
	cur_size=0
	max_units=0
	for numBox, unit in boxTypes:
	    max_units+=unit * min(truckSize-cur_size,numBox)
	    cur_size+=min(truckSize-cur_size,numBox)
	return max_units


def maximumUnits1(boxTypes, truckSize): # TC O(n log n) // SC O(1)
	boxTypes.sort(key=lambda x:x[1], reverse=True)      # TC O(n log n)
	print(boxTypes)
	ans=0
	for box, units in boxTypes:  # TC O(n), Therefore total TC,  O(n logn) + O(n)= O(n log n)
	        if truckSize > box:
	            truckSize -= box
	            ans += box * units
	        else:
	            ans += truckSize * units
	            return ans
	return ans 
    
print(maximumUnits([[5,10],[2,5],[4,7],[3,9]],10))
print(maximumUnits1([[1,3],[2,2],[3,1]],4))


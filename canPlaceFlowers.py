def canPlaceFlowers(flowerbed,n): # TC O(n) // SC O(1)
	flowerbed = [0] + flowerbed + [0]
	for i in range(1,len(flowerbed)-1):
	    if flowerbed[i] ==0 and flowerbed[i-1] == 0 and flowerbed[i+1] == 0:
	        n -= 1
	        flowerbed[i] =1        
	return  n <= 0

def canPlaceFlowers1(flowerbed,n):
	count=0
	i=0
	while i < len(flowerbed):
	    if flowerbed[i]==0 and (i==0 or flowerbed[i-1]==0) and (i==len(flowerbed)-1 or flowerbed[i+1]==0):
	        flowerbed[i]=1
	        count+=1
	    i+=1
	return count>=n

print(canPlaceFlowers([1,0,0,0,1],1))
print(canPlaceFlowers([1,0,0,1,0,0,1],2))
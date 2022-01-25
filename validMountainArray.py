def validMountainArray(arr): # TC O(n) // SC O(1)
    n=len(arr)
    if n < 3:
        return False 
    i=0
    #walk up
    while i+1<n and arr[i] < arr[i+1]:
        i+=1
    #peak can't be first or last
    if i==0 or i == n-1:
        return False 
    #walk down
    while i+1 < n and arr[i] > arr[i+1]:
        i+=1
    #end of the array means we have climbed up and down the mountain
    return i==n-1

print(validMountainArray([0,2,3,4,5,2,1,0]))
print(validMountainArray([2,1]))
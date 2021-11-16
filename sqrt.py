def mySqrt(x):          #Time complexity- O(log x) (Binary search tree)
    if x==0 or x==1:
        return x
    start=1
    end=x//2
    while start<=end:
        mid=start+(end-start)//2 #To avoid overflow we use start+(end-start)//2 instead of simple (start+end)//2
        if mid > x/mid:      # which is same as mid*mid>x:                          
            end=mid-1
        else:
            start=mid+1
            
    return start-1

x=int(input("Enter the number: "))
print(mySqrt(x))

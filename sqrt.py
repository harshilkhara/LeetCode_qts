#Approach 1- Binary Search
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

#Approach 2- Recursion + Bit shifts 
def mySqrt1(x):
    if x < 2:
        return x

    left=mySqrt(x>>2)<<1
    right=left+1

    return left if right*right > x else right 

#Approach 3-  Newton's method (It is the fastest method)
def mySqrt2(x): # TC O(log n)
    if x < 2:
        return x 

    x0 = x
    x1 = (x0 + x / x0) / 2
    while abs(x0 - x1) >= 1:
        x0 = x1
        x1 = (x0 + x / x0) / 2        

    return int(x1)

print(mySqrt(16))
print(mySqrt1(49))
print(mySqrt2(729))

def reverse(n):
        rev=0
        min=-2**31
        max=2**31-1
        if n<0:
                n*=-1
        while(n!=0):
                r=n%10
                rev=rev*10+r
                n=n//10
        if temp<0:
                return("-"+str(rev))
        elif min<=rev>=max: 
                return 0
        else:
                return (rev)
        
       

n=int(input("Enter a number: "))
temp=n
result=reverse(n)
print(result)



def isPalindrome(n):
    rev=0
    temp=n
    if n<0:
        return bool(0)
    while(n!=0):
        r=n%10
        rev=rev*10+r
        n=n//10
    if rev==temp:
        return bool(1)
    else:
        return bool(0)

n=int(input("Enter a number: "))
result=isPalindrome(n)
print(result)

def addBinary(a,b):
    max_len = max(len(a), len(b)) 
  
    a = a.zfill(max_len) 
    b = b.zfill(max_len) 
          
    # initialize the result 
    result = '' 
          
    # initialize the carry 
    carry = 0
  
    # Traverse the string 
    for i in range(max_len - 1, -1, -1): 
        r = carry 
        r += 1 if a[i] == '1' else 0
        r += 1 if b[i] == '1' else 0
        result = ('1' if r % 2 == 1 else '0') + result 
        carry = 0 if r < 2 else 1     # Compute the carry. 
          
        if carry !=0 :
            result = '1' + result 
  
        return result.zfill(max_len) 
    


#def checkInputa(x):
    if x!=0 and x!=1:
        a=int(input("Enter a valid string: "))
        checkInputa(x)     
    else:
        return

#def checkInputb(y):
    if y!=0 and y!=1:
        b=int(input("Enter a valid string: "))
        checkInputb(y)
    else:
        return


a=(input("Enter first string: "))
#checkInputa(a)
b=(input("Enter second string: "))
#checkInputb(b)
result=addBinary(a,b)
print(result)

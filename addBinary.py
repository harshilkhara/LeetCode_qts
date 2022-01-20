def addBinary(a,b):                     # TC O(max(n,m)) // SC O(max(n,m))
    a,b = a[::-1], b[::-1]
    result=""
    carry=0

    for i in range(max(len(a),len(b))):
        digitA=int(a[i]) if i < len(a) else 0
        digitB=int(b[i]) if i < len(b) else 0

        total= digitA + digitB + carry
        char = str(total % 2)     #because we want binary that is base 2 
        result = char + result    #we are adding strings here, so order of addition(appending)matters

        carry=total // 2          # taking care of carry

    if carry:
        result= "1"+ result
    return result


#Approach- Built in functions 

def addBinary1(a,b):          # TC O(n+m)
    c = bin(int(a,2) + int(b,2))
    return c[2:]


#Approach- Bit manipulation 

def addBinary2(a,b):               # TC O(n+m) // SC O(max(n,m))
     x, y = int(a, 2), int(b, 2)
     while y:
         answer = x ^ y            # XOR ( ^ )returns 1 when bits are different else 0
         carry = (x & y) << 1      # AND ( & )returns 1 when both bits are 1 else 0
         x, y = answer, carry      # << 1 --> leftshift bit by 1
         #x,y= x ^ y, (x & y) <<1
     return bin(x)[2:]

a=input("Enter first binary string: ")
b=input("Enter second binary string: ")
print(addBinary(a,b))
print(addBinary1(a,b))
print(addBinary2(a,b))
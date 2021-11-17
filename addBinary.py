def addBinary(a,b): 
    a,b = a[::-1], b[::-1]
    result=""
    carry=0

    for i in range(max(len(a),len(b))):
        digitA=int(a[i]) if i < len(a) else 0
        digitB=int(b[i]) if i < len(b) else 0

        total= digitA + digitB + carry
        char = str(total % 2)
        result = char + result
        carry=total // 2

    if carry:
        result= "1"+ result
    return result


        '''
        c = bin(int(a,2) + int(b,2))
        return c[2:]
        '''
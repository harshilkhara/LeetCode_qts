def roman(s):
    
    RomanDic = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
    result = 0
    for i in range(len(s)-1):
        if RomanDic[s[i]]<RomanDic[s[i+1]]:
            result -= RomanDic[s[i]]
        else:
            result += RomanDic[s[i]]
    result += RomanDic[s[-1]]
    return result

s=input("Enter a Roman Numeral: ")
r=roman(s)
print(r)
#XXIV
#10
#20
#20-1=19
#19+5
#24

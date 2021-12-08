def countPrimes(n): # TC O(n) // SC O(1)
    if n in [0, 1]:
        return 0
    d = [1] * (n)
    d[0] = d[1] = 0
    for i in range(2, int((n**0.5) + 1)):
        if d[i] == 1:
            for i in range(i*i, n, i):
                d[i] = 0

    return (sum(d))

def countPrimes1(n):
    if n==0:
        return 0 
    primes=[True for i in range(n+1)]
    count=0
    p=2
    while p*p <= n:
        if primes[p]:
            for i in range(p*2,n+1,p):
                primes[i]= False
        p+=1
    primes[0],primes[1]= False,False
    for p in range(n):
        if primes[p]:
            count+=1
    return count

def countPrimes2(n): #Fastest one  TC O(n) // SC O(n)
    if n < 3:
        return 0
    primes = [True]*(n//2)
    for i in range(3, int((n**0.5))+1, 2):
        if primes[i//2]:
            primes[i*i//2::i] = [False]*((n - i*i - 1) // (2*i) + 1)
    return sum(primes)


print(countPrimes(10))
print(countPrimes1(10))
print(countPrimes2(13))
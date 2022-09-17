# Approach 1- Sorting + HashMap
def findOriginalArray(changed): # TC O(n log n) // SC O(n)
    if len(changed)%2==1:
        return []

    changed.sort()
    hashmap={}
    for i in changed:
        if i in hashmap:
            hashmap[i]+=1
        else:
            hashmap[i]=1

    original=[]
    for n in changed:
        if hashmap[n]>0:
            hashmap[n]-=1
            twiceNum=2*n
            if twiceNum in hashmap and hashmap[twiceNum]>0:
                hashmap[twiceNum]-=1
                original.append(n)
            else:
                return []

    return original

# Approach 2- Counting Sort 
def findOriginalArray1(changed): # TC O(n+k) // SC O(k)
    if len(changed)%2==1:
        return []

    maxNum=max(changed)
    freq=[0]*(2*maxNum+1)
    for num in changed:
        freq[num]+=1
    original=[0]*(len(changed)//2)
    index=0 
    for i in range(maxNum+1):
        if freq[i]>0:
            freq[i]-=1
            twiceNum=2*i 
            if freq[twiceNum]>0:
                freq[twiceNum]-=1
                original[index]=i 
                index+=1
                i-=1
            else:
                return []

    return original

print(findOriginalArray([1,3,4,2,6,8]))
print(findOriginalArray1([1,3,4,2,6,8]))


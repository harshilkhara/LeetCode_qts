import collections
def findPairs(nums,k):              # TC O(n)   // SC O(n)
    c=collections.Counter(nums)
    count=0
    if k==0:
        for key,v in c.items(): # c.items() returns dic as a tuple [("key","value")]
            if v > 1:
                count+=1
    else:
        for key,v in c.items():
            if key+k in c:
                count+=1
    return count
    
print(findPairs([-1,-2,-3],1))
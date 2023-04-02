import math
class Solution:
    def binarySearch(self, target, potions):
        l,r=0,len(potions)
        while l<r:
            mid=l+(r-l)//2
            if target>potions[mid]:
                l=mid+1
            else:
                r=mid 
        return l
        
    def successfulPairs(self, spells, potions, success): # TC O(m+n(log m)) // SC O(m)
        n,m=len(spells), len(potions)
        potions.sort()
        ans=[0]*n
        for i in range(n):
            target=math.ceil(success/spells[i])
            idx=self.binarySearch(target, potions)
            #idx=bisect.bisect_left(potions, target)
            p=m-idx if m-idx>0 else 0
            ans[i]=p
        
        return ans

s=Solution()
print(s.successfulPairs([5,1,3],[1,2,3,4,5],7))
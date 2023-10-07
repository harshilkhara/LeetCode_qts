from collections import Counter
class Solution: 
# Approach 1 - HashMap
    def majorityElementII(self, nums): # TC O(n) SC O(n)
        counter=Counter(nums)
        minFreq=len(nums)//3
        ans=[]
        for k,v in counter.items():
            if v>minFreq: ans.append(k)
        
        return ans

s=Solution()
print(s.majorityElementII([1,2,3,3]))
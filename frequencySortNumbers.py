from collections import Counter
# Approach 1- With intermediate list
class Solution:
    def frequencySort(self, nums): # TC O(n log n) // SC O(n)
        counter=Counter(nums).most_common()
        counter.sort(key= lambda x:x[0], reverse=True)
        counter.sort(key= lambda x:x[1])
        
        ans=[]
        for i in counter:
            k,v=i
            ans.extend([k]*v)
        
        return ans
        
# Approach 2- Without any intermediate list
    def frequencySort1(self, nums): # TC O(n log n) // SC O(1)
        r = Counter(nums)
        return sorted(nums, key=lambda x: (r[x], -x))

s=Solution()
print(s.frequencySort([1,1,2,2,2,3]))
print(s.frequencySort1([1,1,2,2,2,3]))
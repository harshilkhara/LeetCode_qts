from random import randint
# Approach 1- HashMap
class Solution: # TC O(n) // SC O(n)
    def __init__(self, nums):
        self.hmap={}
        for i,n in enumerate(nums):
            self.hmap.setdefault(n, []).append(i)
        
    def pick(self, target):
        size=len(self.hmap[target])
        return self.hmap[target][randint(0, size-1)]

s=Solution([1,3,9,4,9,4,4])
print(s.pick(4))
print(s.pick(1))
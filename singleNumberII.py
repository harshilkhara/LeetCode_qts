from collections import Counter
class Solution:
# Approach 1- HashMap
    def singleNumber(self, nums): # TC O(n) // SC O(n)
        ans=0
        counter=Counter(nums)
        
        for k,v in counter.items():
            if v==1:
                return k
        
        return -1

# Approach 2- Bit manipulation
    def singleNumber1(self, nums): # TC O(n) // SC O(1)
        
        # Loner. 
        loner = 0
        
        # Iterate over all bits
        for shift in range(32):
            bit_sum = 0
            
            # For this bit, iterate over all integers
            for num in nums:
                
                # Compute the bit of num, and add it to bit_sum
                bit_sum += (num >> shift) & 1
            
            # Compute the bit of loner and place it
            loner_bit = bit_sum % 3
            loner = loner | (loner_bit << shift)

        # Do not mistaken sign bit for MSB.
        if loner >= (1 << 31):
            loner = loner - (1 << 32)
        
        return loner

s=Solution()
print(s.singleNumber([2,2,3,2]))
print(s.singleNumber1([2,2,3,2]))

class Solution:
# Approach 1- Greedy Method
    def kidsWithCandies(self, candies, extraCandies): # TC O(n) SC O(1)
        maxCandies=max(candies)
        result=[]
        for candy in candies:
            result.append(candy+extraCandies>=maxCandies)
        
        return result
                
s=Solution()
print(s.kidsWithCandies([2,3,5,1,3],3))
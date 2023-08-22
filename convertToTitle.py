class Solution:
# Approach 1- Math 
    def convertToTitle(self, columnNumber): # TC O(log n) SC O(1)
        ans=""
        while columnNumber>0:
            columnNumber-=1
            ans+=  chr((columnNumber%26 + ord('A')))
            columnNumber//=26
        
        return ans[::-1]

s=Solution()
print(s.convertToTitle(902))
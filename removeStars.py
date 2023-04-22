class Solution:
# Approach 2- Stack
    def removeStars(self, s): # TC O(n) // SC O(n)
        stack=[]
        for c in s:
            if c=='*':
                stack.pop()
            else:
                stack.append(c)
        
        return "".join(stack)

s=Solution()
print(s.removeStars("leet**cod*e"))
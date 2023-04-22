class Solution:
# Approach 1- Stack    
    def backspaceCompare(self, S, T): # TC O(n) // SC O(n)
        def build(S):
            ans = []
            for c in S:
                if c != '#':
                    ans.append(c)
                elif ans:
                    ans.pop()
            return "".join(ans)
        return build(S) == build(T)

s=Solution()
print(s.backspaceCompare("y#fo##f","y#f#o##f"))
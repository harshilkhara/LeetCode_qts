class Solution:

# Approach 1- Greedy method
    def partitionString(self, s): # TC O(n) // SC O(1)
        n=len(s)
        lastSeen=[-1]*26
        count=1
        subStringStart=0
        for i in range(n):
            if lastSeen[ord(s[i])-ord('a')]>=subStringStart:
                count+=1
                subStringStart=i
            
            lastSeen[ord(s[i])-ord('a')]=i 
        
        return count

    def partitionString1(self, s):
        seen=set()
        count=1
        for c in s:
            if c in seen:
                seen=set()
                count+=1
            seen.add(c)
        return count

s=Solution()
print(s.partitionString("abacaba"))
print(s.partitionString1("abacaba"))
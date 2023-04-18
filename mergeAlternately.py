class Solution:
# Approach 1- Without substring
    def mergeAlternately(self, word1, word2): # TC O(max(m,n)) // SC O(1)
        answer=""
        m,n=len(word1), len(word2)
        for i in range(max(m,n)):
            if i<m:
                answer+=word1[i]
            if i<n:
                answer+=word2[i]
        
        return answer

# Approach 2- With substring
    def mergeAlternately1(self, word1, word2): # TC O(min(m,n)) // SC O(1)
        answer=""
        m,n=len(word1), len(word2)
        for i in range(min(m,n)):
            answer+=word1[i]
            answer+=word2[i]

        if m<n:
            answer+=word2[m:]
        else:
            answer+=word1[n:]

        return answer 

s=Solution()
print(s.mergeAlternately("abcde","pqr"))
print(s.mergeAlternately1("abcde","pqr"))
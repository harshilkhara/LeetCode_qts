# By using concept of sliding window 
'''
Concept of sliding window is used whenever a contiguous subarray or sublist needs to be calculated.

By using HashSet as a sliding window, checking if a character in the current can be done in O(1).

A sliding window is an abstract concept commonly used in array/string problems. A window is a range 
of elements in the array/string which usually defined by the start and end indices, i.e. [i,j) 
(left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain 
direction. For example, if we slide [i,j) to the right by 1 element, then it becomes [i+1, j+1)
(left-closed, right-open).

Back to our problem. We use HashSet to store the characters in current window [i, j) (j = i
initially). Then we slide the index j to the right. If it is not in the HashSet, we slide j further. 
Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings
without duplicate characters start with index i. If we do this for all i, we get our answer.

'''
def lengthOfLongestSubstring(s): #TC O(2n)--> O(n) // SC O(min(m,n)) NOTE- DOES NOT WORK FOR SPACES.
	l=r=0
	hash={}
	res=0
	if len(s)==0:
		return 1
	while r < len(s):
		if s[r] in hash:       
			hash[s[r]]+=1
		else:
			hash[s[r]]=1

		while hash[s[r]] >1:    # Condition when window should be slided 
			hash[s[l]]-=1       # removing the element that goes outside of the window 
			l+=1                # sliding the window ahead by 1
			res=max(res, r-l+1) #Calculating size without duplicate characters at that point
		r+=1
	return res

def lengthOfLongestSubstring1(s): #TC O(2n)--> O(n) // SC O(min(m,n))
    chars = [0] * 128

    left = right = 0

    res = 0
    while right < len(s):
        r = s[right]
        chars[ord(r)] += 1

        while chars[ord(r)] > 1:
            l = s[left]
            chars[ord(l)] -= 1
            left += 1

        res = max(res, right - left + 1)

        right += 1
    return res

'''
Approach 3: Optimized Sliding window 

The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. 
Instead of using a set to tell if a character exists or not, we could define a mapping of the 
characters to its index. Then we can skip the characters immediately when we found a repeated 
character.
The reason is that if s[j] have a duplicate in the range [i, j) with index j',
we don't need to increase i little by little. We can skip all the elements in the range 
[i, j'] and let i to be j' + 1 directly.

'''

def lengthOfLongestSubstring2(s): # TC O(n) // SC O(min(m,n))
	n = len(s)
	ans = 0
	# mp stores the current index of a character
	mp = {}

	i = 0
	# try to extend the range [i, j]
	for j in range(n):
	    if s[j] in mp:
	        i = max(mp[s[j]], i)

	    ans = max(ans, j - i + 1)
	    mp[s[j]] = j + 1

	return ans

print(lengthOfLongestSubstring("abcabcbb"))
print(lengthOfLongestSubstring1("bbbb"))
print(lengthOfLongestSubstring2("pwwkew"))





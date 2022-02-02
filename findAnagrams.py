#Approach- Sliding window with Hashmap 

from collections import Counter
def findAnagrams(s,p):             # TC O(Ns+Np) // SC O(26) --> O(1)
	ns, np = len(s), len(p)
	if ns < np:
	    return []

	p_count = Counter(p)
	s_count = Counter()

	output = []
	# sliding window on the string s NOTE- but is actually on hashmap so need of sliding window by 1
	for i in range(ns):
	    # add one more letter 
	    # on the right side of the window
	    s_count[s[i]] += 1
	    # remove one letter 
	    # from the left side of the window
	    if i >= np:
	        if s_count[s[i - np]] == 1:
	            del s_count[s[i - np]]
	        else:
	            s_count[s[i - np]] -= 1
	    # compare array in the sliding window
	    # with the reference array
	    if p_count == s_count:
	        output.append(i - np + 1)

	return output


#Approach- Sliding window with Array

def findAnagrams1(s,p):             # TC O(Ns+Np) // SC O(26) --> O(1)
	ns, np = len(s), len(p)
	if ns < np:
	    return []

	p_count, s_count = [0] * 26, [0] * 26
	# build reference array using string p
	for ch in p:
	    p_count[ord(ch) - ord('a')] += 1

	output = []
	# sliding window on the string s
	for i in range(ns):
	    # add one more letter 
	    # on the right side of the window
	    s_count[ord(s[i]) - ord('a')] += 1
	    # remove one letter 
	    # from the left side of the window
	    if i >= np:
	        s_count[ord(s[i - np]) - ord('a')] -= 1
	    # compare array in the sliding window
	    # with the reference array
	    if p_count == s_count:
	        output.append(i - np + 1)

	return output

print(findAnagrams("cbaebabacd","abc"))
print(findAnagrams1("abab","ab"))

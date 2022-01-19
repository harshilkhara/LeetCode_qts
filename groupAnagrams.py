'''
   The approach is similar to isAnagram.py
'''

# Approach- Categorized by sorted strings 
import collections   
def groupAnagrams(strs):  # TC O(N k log k) // SC O(N k)  N = length of strs
	                                                    # k = max length of a string in strs
	ans=collections.defaultdict(list)  # values as list in the dictionary 
	for s in strs:                         # TC O(N)
		ans[tuple(sorted(s))].append(s)    # TC O(k log k)

	return ans.values()

# Approach- Categorize by Count 

def groupAnagrams1(strs):                # TC O(N k) // SC O(N k)
	ans = collections.defaultdict(list)
	for s in strs:
		count = [0] * 26
		for c in s:
			count[ord(c) - ord('a')] += 1
		ans[tuple(count)].append(s)
	return ans.values()

print(groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
print(groupAnagrams1(["eat","tea","tan","ate","nat","bat"]))


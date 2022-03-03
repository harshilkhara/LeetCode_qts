#Approach 1- Divide and conquer with greedy 

def isSubsequence(s,t): # TC O(T) // SC O(T) where T is length of the target string 
	LEFT_BOUND, RIGHT_BOUND = len(s), len(t)

	def rec_isSubsequence(left_index, right_index):
	    # base cases
	    if left_index == LEFT_BOUND:
	        return True
	    if right_index == RIGHT_BOUND:
	        return False
	    # consume both strings or just the target string
	    if s[left_index] == t[right_index]:
	        left_index += 1
	    right_index += 1

	    return rec_isSubsequence(left_index, right_index)

	return rec_isSubsequence(0, 0)

#Approach 2- Two Pointers
def isSubsequence1(s,t): # TC O(T) // SC O(1)
	LEFT_BOUND, RIGHT_BOUND = len(s), len(t)

	p_left = p_right = 0
	while p_left < LEFT_BOUND and p_right < RIGHT_BOUND:
	    # move both pointers or just the right pointer
	    if s[p_left] == t[p_right]:
	        p_left += 1
	    p_right += 1

	return p_left == LEFT_BOUND

#Approach 3- Greedy match with character indices hashmap 

from collections import defaultdict
def isSubsequence2(s,t):  # TC O(T + S log T) // SC O(T)
	letter_indices_table = defaultdict(list)
	for index, letter in enumerate(t):
	    letter_indices_table[letter].append(index)

	curr_match_index = -1
	for letter in s:
	    if letter not in letter_indices_table:
	        return False  # no match at all, early exit

	    # greedy match with binary search
	    indices_list = letter_indices_table[letter]
	    match_index = bisect.bisect_right(indices_list, curr_match_index)
	    if match_index != len(indices_list):
	        curr_match_index = indices_list[match_index]
	    else:
	        return False # no suitable match found, early exist

	return True

#Approach 4- Dynamic Programming 
import bisect 
def isSubsequence3(s,t): # TC O(S.T) // SC O(S.T)
	source_len, target_len = len(s), len(t)

	# the source string is empty
	if source_len == 0:
	    return True

	# matrix to store the history of matches/deletions
	dp = [ [0] * (target_len + 1) for _ in range(source_len + 1)]

	# DP compute, we fill the matrix column by column, bottom up
	for col in range(1, target_len + 1):
	    for row in range(1, source_len + 1):
	        if s[row - 1] == t[col - 1]:
	            # find another match
	            dp[row][col] = dp[row - 1][col - 1] + 1
	        else:
	            # retrieve the maximal result from previous prefixes
	            dp[row][col] = max(dp[row][col - 1], dp[row - 1][col])

	    # check if we can consume the entire source string,
	    #   with the current prefix of the target string.
	    if dp[source_len][col] == source_len:
	        return True

	return False

print(isSubsequence("abc","hgaibxc"))
print(isSubsequence1("axc", "ahbgdc"))
print(isSubsequence2("kgb","rukgib"))
print(isSubsequence3("leo","melpepo"))





'''
Approach- Very similar to permute.py

'''
def letterCombinations(digits):    # TC O(4^n N) // SC O(n)
	if len(digits) == 0:
	    return []

	# Map all the digits to their corresponding letters
	letters = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", 
	           "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}

	def backtrack(index, path):
	    # If the path is the same length as digits, we have a complete combination
	    if len(path) == len(digits):
	        combinations.append("".join(path))
	        return # Backtrack
	    
	    # Get the letters that the current digit maps to, and loop through them
	    possible_letters = letters[digits[index]]
	    for letter in possible_letters:
	        # Add the letter to our current path
	        path.append(letter)
	        # Move on to the next digit
	        backtrack(index + 1, path)
	        # Backtrack by removing the letter before moving onto the next
	        path.pop()

	# Initiate backtracking with an empty path and starting index of 0
	combinations = []
	backtrack(0, [])
	return combinations

def letterCombinations1(digits):
	mapp={
	    "2":['a','b','c'],
	    "3":['d','e','f'],
	    "4":['g','h','i'],
	    "5":['j','k','l'],
	    "6":['m','n','o'],
	    "7":['p','q','r','s'],
	    "8":['t','u','v'],
	    "9":['w','x','y','z'],
	}
	s1 = []
	if digits== "":
	    return s1
	elif len(digits)==1:
	    return mapp[digits]
	for d in digits:
	    if s1==[]:
	        s1 = mapp[d]
	    else:
	        ans =[]
	        for i in s1:
	            for j in mapp[d]:
	                ans.append(i+j)
	        s1 = ans
	return s1

def letterCombinations2(digits):
	phn_dict = {"2": ["a", "b", "c"], "3": ["d", "e", "f"], "4": ["g", "h", "i"], "5": ["j", "k", "l"], "6": ["m", "n", "o"], "7": ["p", "q", "r", "s"], "8": ["t", "u", "v"], "9": ["w", "x", "y", "z"]}
        
	ans = []
	if len(digits) == 0:
	    return []
	def dfs(digits, res, start):
	    if start >= len(digits):
	        ans.append(''.join(res))
	        return
	    for char in phn_dict[digits[start]]:
	        res.append(char)
	        dfs(digits, res, start + 1)
	        res.pop()
	    return

	dfs(digits, [], 0)
	return ans   

print(letterCombinations("23"))
print(letterCombinations1("23"))
print(letterCombinations2("23"))

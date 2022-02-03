#Approach- Using a stack & string builder 
def minRemoveToMakeValid(s): # TC O(n) // SC O(n)
	indexes_to_remove = set()
	stack = []
	for i, c in enumerate(s):
	    if c not in "()":
	        continue
	    if c == "(":
	        stack.append(i)
	    elif not stack:
	        indexes_to_remove.add(i)
	    else:
	        stack.pop()
	indexes_to_remove = indexes_to_remove.union(set(stack))
	string_builder = []
	for i, c in enumerate(s):
	    if i not in indexes_to_remove: # TC O(1)
	        string_builder.append(c)   # TC O(1)
	return "".join(string_builder)     # TC O(n)

#Approach- Two Pass String Builder
def minRemoveToMakeValid1(s):   # TC O(n) // SC O(n)
	def delete_invalid_closing(string, open_symbol, close_symbol):
		sb = []
		balance = 0
		for c in string:
		    if c == open_symbol:
		        balance += 1
		    if c == close_symbol:
		        if balance == 0:
		            continue
		        balance -= 1
		    sb.append(c)
		return "".join(sb)

	# Note that s[::-1] gets the reverse of s.
	s = delete_invalid_closing(s, "(", ")")
	s = delete_invalid_closing(s[::-1], ")", "(")
	return s[::-1] # TC O(n)

#Approach- Shortened Two Pass String Builder 
def minRemoveToMakeValid2(s):               # TC O(n) // SC O(n)
	# Pass 1: Remove all invalid ")"
	first_pass_chars = []
	balance = 0
	open_seen = 0
	for c in s:
	    if c == "(":
	        balance += 1
	        open_seen += 1
	    if c == ")":
	        if balance == 0:
	            continue
	        balance -= 1
	    first_pass_chars.append(c)

	# Pass 2: Remove the rightmost "("
	result = []
	open_to_keep = open_seen - balance
	for c in first_pass_chars:
	    if c == "(":
	        open_to_keep -= 1
	        if open_to_keep < 0:
	            continue
	    result.append(c)
	return "".join(result)

print(minRemoveToMakeValid("L(e)))et((co)d(e"))
print(minRemoveToMakeValid1("L(e)))et((co)d(e"))
print(minRemoveToMakeValid2("lee(t(c)o)de)"))


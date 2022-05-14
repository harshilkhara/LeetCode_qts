# Approach 1- Brute Force
def removeDuplicateString(s,k): # TC O(n^2/k) // SC O(1) Note- It times out 
	result=list(s)
	length=-1
	while length!=len(result):
	    length=len(result)
	    for i in range(len(result)):
	        if i==0 or result[i]!=result[i-1]:
	            count=1
	        else: 
	            count+=1
	            if count==k:
	                del result[i-k+1:i+1]
	                break

	return "".join(result)

# Approach 2- Memoize count 
def removeDuplicateString1(s,k): # TC O(n) // SC O(n) 
	result=list(s)
	count=[0]*len(s)
	i=0
	while i < len(result):
		if i==0 or result[i]!=result[i-1]:
			count[i]=1
		else:
			count[i]=count[i-1]+1
			if count[i]==k:
				del result[i-k+1:i+1]
				i=i-k
		i+=1

	return "".join(result)

# Approach 3- Stack 
def removeDuplicateString2(s,k): # TC O(n) // SC O(n)
	result=list(s)
	stack=[]
	i=0
	#for i in range(len(result)):
	while i < len(result):
	    if i==0 or result[i]!=result[i-1]:
	        stack.append(1)
	    else:
	        incremented=stack.pop()+1
	        if incremented==k:
	            del result[i-k+1:i+1]
	            i=i-k
	        else:
	            stack.append(incremented)
	    i+=1

	return "".join(result)

# Approach 4- Stack with reconstruction 
# Approach 5- From neetcode              #Both are essentialy the same 
def removeDuplicateString3(s,k):     # TC O(n) // SC O(n)
	stack=[] # [char,count]
	for c in s:
		if stack and stack[-1][0]==c:
			stack[-1][1]+=1
		else:
			stack.append([c,1])
		if stack[-1][1]==k:
			stack.pop()
	res=""
	for char,count in stack:
		res+=(char*count)

	return res

print(removeDuplicateString("abcd",2))
print(removeDuplicateString1("deeedbbcccbdaa",3))
print(removeDuplicateString2("pbbcggttciiippooaais",2))
print(removeDuplicateString3("caabbbacc",3))


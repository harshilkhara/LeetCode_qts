#Approach 1- Build number from left to right 
def getSmallestString(n,k): # TC O(n) // SC O(1)
	'''
	hmap={1:'a',2:'b',3:'c',4:'d',5:'e',6:'f',7:'g',8:'h',9:'i', 10:'j',11:'k',12:'l',13:'m',
         14:'n', 15:'o', 16:'p',  17:'q', 18:'r', 19:'s', 20:'t',  21:'u', 22:'v', 23:'w',24:'x',
         25:'y', 26:'z'}
    '''
	result = [n for i in range(n)] 
	for position in range(n):
	    positionsLeft=n-position-1 
	    if (k > positionsLeft*26):
	        add=int(k-positionsLeft*26)
	        result[position]= chr(ord("a")+add-1)  #result[position]=hmap[add]
	        k-=add 
	    else:
	        result[position]='a'
	        k-=1
	return "".join(result)

#Approach 2- Build number from right 

def getSmallestString1(n,k): # TC O(n) // SC O(1)
	result=['a']*n
	k-=n
	for position in range(n-1,-1,-1):
	    add=min(k,25)
	    result[position]=chr(ord("a")+add)  
	    k-=add
	return "".join(result)

#Approach 3- Build number from right- optimized

def getSmallestString2(n,k): # TC O(n) // SC O(1)
	result=['a']*n 
	for position in range(n-1,-1,-1):
		add=min(k-position,26)
		result[position]=chr(ord('a')+add-1)
		k-=add
	return "".join(result)

print(getSmallestString(3,27))
print(getSmallestString1(4,100))
print(getSmallestString2(4,100))
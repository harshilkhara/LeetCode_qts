# The idea is very similar to addBinary.py 
#Approach 1- Split + Parse, Two Pass
def compareVersion(version1,version2): # TC O(M+N+max(M,N)) // SC O(M+N) M=len(v1), N=len(v2)
	nums1 = version1.split('.')
	nums2 = version2.split('.')
	n1, n2 = len(nums1), len(nums2)

	# compare versions
	for i in range(max(n1, n2)):
	    i1 = int(nums1[i]) if i < n1 else 0
	    i2 = int(nums2[i]) if i < n2 else 0
	    if i1 != i2:
	        return 1 if i1 > i2 else -1

	# the versions are equal
	return 0 

#Approach 2- Two Pointers, One pass 
def get_next_chunk(version,n,p): # TC O(max(M,N)) // SC O(max(M,N))
	# if pointer is set to the end of string
	# return 0
	if p > n - 1:
	    return 0, p

	# find the end of chunk
	p_end = p
	while p_end < n and version[p_end] != '.':
	    p_end += 1
	# retrieve the chunk
	i = int(version[p:p_end]) if p_end != n - 1 else int(version[p:n])
	# find the beginning of next chunk
	p = p_end + 1

	return i, p

def compareVersion1(version1,version2):
	p1 = p2 = 0
	n1, n2 = len(version1), len(version2)

	# compare versions
	while p1 < n1 or p2 < n2:
	    i1, p1 = get_next_chunk(version1, n1, p1)
	    i2, p2 = get_next_chunk(version2, n2, p2)            
	    if i1 != i2:
	        return 1 if i1 > i2 else -1

	# the versions are equal
	return 0    

print(compareVersion("1.01","1.001")) 
print(compareVersion1("0.1","1.001")) 

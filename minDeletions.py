#Approach 1- Decrementing till the frequencies are unique
def minDeletions(s): # TC O(N+K^2) // SC O(K)

	# Store the frequency of each character
	frequencies=[0]*26
	for c in s:
		frequencies[ord(c)-ord('a')]+=1

	deleteCount=0
	# Use a set to store the frequencies we have already seen
	seenFrequencies=set()
	for i in range(26):
		# Keep decrementing the frequency until it is unique

		while frequencies[i] and frequencies[i] in seenFrequencies:
			frequencies[i]-=1
			deleteCount+=1

		# Add the newly occupied frequency to the set
		seenFrequencies.add(frequencies[i])

	return deleteCount 

#Approach 2- Priority Queue (Max Heap)
import heapq
def minDeletions1(s): # TC O(N + K^2 log K) // SC O(K)
	# Store the frequency of each character
	frequency = [0] * 26
	for char in s:
	    frequency[ord(char) - ord('a')] += 1

	# Add all non-zero frequencies to max priority queue
	# Create a max priority queue by flipping the sign of each element
	pq = [-freq for freq in frequency if freq != 0]
	heapq.heapify(pq)

	delete_count = 0
	while len(pq) > 1:
	    # Flip the sign back to positive when removing from the max priority queue
	    top_element = -heapq.heappop(pq)

	    # If the top two elements in the priority queue are the same
	    if top_element == -pq[0]:
	        # Decrement the popped value and push it back into the queue
	        if top_element - 1 > 0: 
	            top_element -= 1
	            heapq.heappush(pq, -top_element)

	        delete_count += 1

	return delete_count

#Approach 3- Sorting
def minDeletions2(s): # TC O(N + K log K) // SC O(K)
	frequency=[0]*26 
	for char in s:
		frequency[ord(char)-ord('a')]+=1

	frequency.sort()

	deleteCount = 0
	maxFreqAllowed=len(s)

	for i in range(25,-1,-1):
		if frequency[i]>maxFreqAllowed:
			deleteCount+=frequency[i]-maxFreqAllowed
			frequency[i]=maxFreqAllowed

		maxFreqAllowed=max(0,frequency[i]-1)

	return deleteCount

print(minDeletions("aab"))
print(minDeletions1("aaabbcc"))
print(minDeletions2("aaabbbcc"))
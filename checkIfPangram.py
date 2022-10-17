# Approach 1- Array as counter (using count)
def checkIfPangram(sentence): # TC O(n) // SC O(1)
	freq=[0]*26

	for char in sentence:
	    #print(ord(char)-ord('a'))
	    freq[ord(char)-ord('a')]+=1

	for count in freq:
	    if count<1:
	        return False 

	return True

# Approach 2- Finding each letter
def checkIfPangram1(sentence): # TC O(n) // SC O(1)
	# We iterate over 'sentence' for 26 times, one for each letter 'curr_char'.
	for i in range(26):
	    curr_char = chr(ord('a') + i)

	    # If 'sentence' doesn't contain 'curr_char', it is not a pangram.
	    if sentence.find(curr_char) == -1:
	        return False

	# If we manage to find all 26 letters, it is a pangram.
	return True

# Approach 3- Using set 
def checkIfPangram2(sentence): # TC O(n) // SC O(1)
	# Add every letter of 'sentence' to hash set 'seen'.
    seen = set(sentence)
    
    # If the size of 'seen' is 26, then 'sentence' is a pangram.
    return len(seen) == 26

# Approach 4- Array as counter (using boolean)
def checkIfPangram3(sentence): # TC O(n) // SC O(1)
    # Array 'seen' of size 26.
    seen = [False] * 26

    # For every letter 'currChar', we find its ASCII code, 
    # and update value at the mapped index as true.
    for curr_char in sentence:
        seen[ord(curr_char) - ord('a')] = True
    
    # Once we finish iterating, check if 'seen' contains false.
    for status in seen:
        if not status:
            return False
    return True

# Approach 5- Bit Manipulation
def checkIfPangram4(sentence): # TC O(n) // SC O(1)
    # Initialize seen = 0 since we start with no letter.
    seen = 0
    
    # Iterate over 'sentence'.
    for curr_char in sentence:
        # Map each 'curr_char' to its index using its ASCII code.
        mapped_index = ord(curr_char) - ord('a')

        # 'curr_bit' represents the bit for 'curr_char'.
        curr_bit = 1 << mapped_index 

        # Use 'OR' operation since we only add its bit for once.
        seen |= curr_bit
    
    # Once we finish iterating, check if 'seen' contains 26 bits of 1.
    return seen == (1 << 26) - 1

print(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
print(checkIfPangram1("thequickbrownfoxjumpsoverthelazydog"))
print(checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"))
print(checkIfPangram3("thequickbrownfoxjumpsoverthelazydog"))
print(checkIfPangram4("thequickbrownfoxjumpsoverthelazydog"))
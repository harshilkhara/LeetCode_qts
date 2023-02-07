# Approach 1- Brutiest Brute Force
def totalFruit(fruits): # TC O(n^3) // SC O(n)
	# Maximum number of fruits we can pick
	max_picked = 0

	# Iterate over all subarrays: left index left, right index right.
	for left in range(len(fruits)):
	    for right in range(left, len(fruits)):
	        # Use a set to count the type of fruits.
	        basket = set()
	        
	        # Iterate over the current subarray (left, right).
	        for current_index in range(left, right + 1):
	            basket.add(fruits[current_index])
	            
	        # If the number of types of fruits in this subarray (types of fruits) 
	        # is no larger than 2, this is a valid subarray, update 'max_picked'.
	        if len(basket) <= 2:
	            max_picked = max(max_picked, right - left + 1)

	# Return 'max_picked' as the maximum length (maximum number of fruits we can pick).
	return max_picked

# Approach 2- Optimized Brute Force
def totalFruit1(fruits): # TC O(n^2) // SC O(1)
	# Maximum number of fruits we can pick
	max_picked = 0

	# Iterate over the left index left of subarrays.
	for left in range(len(fruits)):
	    # Empty set to count the type of fruits.
	    basket = set()
	    right = left
	    
	    # Iterate over the right index right of subarrays.
	    while right < len(fruits):
	        # Early stop. If adding this fruit makes 3 types of fruit,
	        # we should stop the inner loop.
	        if fruits[right] not in basket and len(basket) == 2:
	            break
	        
	        # Otherwise, update the number of this fruit.
	        basket.add(fruits[right])
	        right += 1
	    
	    # Update max_picked
	    max_picked = max(max_picked, right - left)

	# Return maxPicked as the maximum length of valid subarray.
	# (maximum number of fruits we can pick).
	return max_picked

# Approach 3- Sliding window
def totalFruit2(fruits): # TC O(n) // SC O(n)
	# Hash map 'basket' to store the types of fruits.
	basket = {}
	left = 0

	# Add fruit from the right index (right) of the window.
	for right, fruit in enumerate(fruits):
	    basket[fruit] = basket.get(fruit, 0) + 1

	    # If the current window has more than 2 types of fruit,
	    # we remove one fruit from the left index (left) of the window.
	    if len(basket) > 2:
	        basket[fruits[left]] -= 1

	        # If the number of fruits[left] is 0, remove it from the basket.
	        if basket[fruits[left]] == 0:
	            del basket[fruits[left]]
	        left += 1

	# Once we finish the iteration, the indexes left and right 
	# stands for the longest valid subarray we encountered.
	return right - left + 1

# Approach 4- Optimized sliding window
def totalFruit3(fruits): # TC O(n) // SC O(1)
	# We use a hash map 'basket' to store the number of each type of fruit.
	basket = {}
	max_picked = 0
	left = 0

	# Add fruit from the right index (right) of the window.
	for right in range(len(fruits)):
		basket[fruits[right]] = basket.get(fruits[right], 0) + 1

		# If the current window has more than 2 types of fruit,
		# we remove fruit from the left index (left) of the window,
		# until the window has only 2 types of fruit.
		while len(basket) > 2:
		    basket[fruits[left]] -= 1
		    if basket[fruits[left]] == 0:
		        del basket[fruits[left]]
		    left += 1

		# Update max_picked.
		max_picked = max(max_picked, right - left + 1)

	# Return max_picked as the maximum number of fruits we can collect.
	return max_picked

print(totalFruit([1,2,1]))
print(totalFruit1([1,2,1]))
print(totalFruit2([1,2,1]))
print(totalFruit3([1,2,1]))
# Approach 1- Greedy
def maxIceCream(costs,coins): # TC O(n log n) // SC O(n)
	costs.sort()
	icecream=0
	for cost in costs:
	    if coins>0 and cost<=coins:
	        coins-=cost
	        icecream+=1

	return icecream

def maxIceCream1(costs,coins):
	n, icecreams = len(costs), 0
	m = max(costs)

	costsFrequency = [0] * (m + 1)
	for cost in costs:
	    costsFrequency[cost] += 1

	for cost in range(1, m + 1):
	    # No ice cream is present costing 'cost'.
	    if not costsFrequency[cost]:
	        continue
	    # We don't have enough 'coins' to even pick one ice cream.
	    if coins < cost:
	        break
	    # Count how many icecreams of 'cost' we can pick with our 'coins'.
	    # Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coins'.
	    count = min(costsFrequency[cost], coins // cost)
	    # We reduce price of picked ice creams from our coins.
	    coins -= cost * count
	    icecreams += count
	    
	return icecreams

print(maxIceCream([7,3,3,6,6,6,10,5,9,2],56))
print(maxIceCream1([7,3,3,6,6,6,10,5,9,2],56))
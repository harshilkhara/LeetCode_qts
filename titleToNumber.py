'''
Approach 1- Right to left scan 

'''
def titleToNumber(s):  #TC O(n) // SC O(1)
	result = 0

	# Decimal 65 in ASCII corresponds to char 'A'
	alpha_map = {chr(i + 65): i + 1 for i in range(26)}

	n = len(s)
	for i in range(n):
	    cur_char = s[n - 1 - i]
	    result += (alpha_map[cur_char] * (26 ** i))
	return result

print(titleToNumber("AA"))
'''
Approach 2- Left to right scan 

Rather than scanning from right to left as described in Approach 1, we can also scan the title from 
left to right.

For example, if we want to get the decimal value of string "1337", we can iteratively find the result 
by scanning the string from left to right as follows:

'1' = 1
'13' = (1 x 10) + 3 = 13
'133' = (13 x 10) + 3 = 133
'1337' = (133 x 10) + 7 = 1337
Instead of base-10, we are dealing with base-26 number system. Based on the same idea, we can just 
replace 10s with 26s and convert alphabets to numbers.

For a title "LEET":

L = 12
E = (12 x 26) + 5 = 317
E = (317 x 26) + 5 = 8247
T = (8247 x 26) + 20 = 214442
In Approach 1, we have built a mapping of alphabets to numbers. There is another way to get the 
number value of a character without building an alphabet mapping. You can do this by converting a 
character to its ASCII value and subtracting ASCII value of character 'A' from that value. By doing 
so, you will get results from 0 (for A) to 25 (for Z). Since we are indexing from 1, we can just add 
1 up to the result. This eliminates a loop where you create an alphabet to number mapping which was 
done in Approach 1.

'''
def titleToNumber1(s):  # TC O(n) // SC O(1)
	result=0
	n=len(s)
	for i in range (n):
		result=result*26
		result+=ord(s[i])-ord('A')+1 
	return result

print(titleToNumber1("AB"))
def reverseWords(s):
	return " ".join([word[::-1] for word in s.split(" ")])

def reverseWords1(s):
	s1=s[::-1]
	ans=s1.split(" ")
	ans1=ans[::-1]
	return " ".join(ans1)

print(reverseWords("Lets take leetcode test"))
print(reverseWords1("Lets take leetcode test"))


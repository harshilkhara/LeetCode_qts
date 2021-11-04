class Solution(object):
    def isValid(s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for ch in s:
            if ch == '(' or ch == '[' or ch == '{':
                stack.append(ch)
            else:
                if len(stack) == 0:
                    return False
                tmp = stack.pop()
                if ch == ')' and tmp != '(':
                    return False
                if ch == ']' and tmp != '[':
                    return False
                if ch == '}' and tmp != '{':
                    return False
        return len(stack)==0


    s=input("Enter the string of parentheses: ")
    result=isValid(s)
    print(result)
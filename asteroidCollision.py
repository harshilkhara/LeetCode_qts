class Solution:
# Approach 1- Stack
    def asteroidCollision(self, asteroids): # TC O(n) SC O(n)
        stack=[]
        for asteroid in asteroids:
            stack.append(asteroid)
        
            while len(stack)>1 and stack[-2]>0 and stack[-1]<0:
                a,b=stack.pop(), stack.pop()
                if abs(a)!=abs(b):
                    if abs(a)>abs(b):
                        stack.append(a)
                    else:
                        stack.append(b)
        
        return stack
            
s=Solution()
print(s.asteroidCollision([5,10,-5]))

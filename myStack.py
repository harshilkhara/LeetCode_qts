from collections import deque
class MyStack: 
# Approach 1- 1 Queue 
    def __init__(self): # TC Push- O(n), Pop- O(1)
        self.q=deque()
        
    def push(self, x: int) -> None:
        self.q.append(x)
        size=len(self.q)
        while size>1:
            self.q.append(self.q.popleft())
            size-=1

    def pop(self) -> int:
        return self.q.popleft()

    def top(self) -> int:
        return self.q[0]

    def empty(self) -> bool:
        return len(self.q)==0



obj = MyStack()
obj.push(2)
obj.push(3)
print(obj.pop())
obj.push(4)
print(obj.top())
print(obj.pop())
print(obj.pop())
print(obj.empty())


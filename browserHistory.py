# Approach 1- Two Stacks
class BrowserHistory: # TC O(1), O(min(m,n)) // SC O(l*n)
    def __init__(self, homepage: str):
        self._history, self._future = [], []
        # 'homepage' is the first visited URL.
        self._current = homepage

    def visit(self, url: str) -> None:
        # Push 'current' in 'history' stack and mark 'url' as 'current'.
        self._history.append(self._current)
        self._current = url
        # We need to delete all entries from 'future' stack.
        self._future = []

    def back(self, steps: int) -> str:
        # Pop elements from 'history' stack, and push elements in 'future' stack.
        while steps > 0 and self._history:
            self._future.append(self._current)
            self._current = self._history.pop()
            steps -= 1
        return self._current

    def forward(self, steps: int) -> str:
        # Pop elements from 'future' stack, and push elements in 'history' stack.
        while steps > 0 and self._future:
            self._history.append(self._current)
            self._current = self._future.pop()
            steps -= 1
        return self._current

# Approach 2- Doubly linkedList
class DLLNode:
    def __init__(self, url: str):
        self.data = url
        self.prev, self.next = None, None

class BrowserHistory1: # TC O(1), O(min(m,n)) // SC O(l*n)
    def __init__(self, homepage: str):
        # 'homepage' is the first visited URL.
        self.linked_list_head = DLLNode(homepage)
        self.current = self.linked_list_head

    def visit(self, url: str) -> None:
        # Insert new node 'url' in the right of current node.
        new_node = DLLNode(url)
        self.current.next = new_node
        new_node.prev = self.current
        # Make this new node as current node now.
        self.current = new_node

    def back(self, steps: int) -> str:
        # Move 'current' pointer in left direction.
        while steps and self.current.prev:
            self.current = self.current.prev
            steps -= 1
        return self.current.data

    def forward(self, steps: int) -> str:
        # Move 'current' pointer in right direction.
        while steps and self.current.next:
            self.current = self.current.next
            steps -= 1
        return self.current.data

# Approach 3- Dynamic List or array
class BrowserHistory2: # TC O(1), O(1) // SC O(l*n)
    def __init__(self, homepage: str):
        # 'homepage' is the first visited URL.
        self.visited_URLs = [homepage]
        self.curr_URL, self.last_URL = 0, 0

    def visit(self, url: str) -> None:
        self.curr_URL += 1
        if len(self.visited_URLs) > self.curr_URL:
            # We have enough space in our array to overwrite an old 'url' entry with new one.
            self.visited_URLs[self.curr_URL] = url
        else:
            # We have to insert a new 'url' entry at the end.
            self.visited_URLs.append(url)
        # This 'url' will be last URL if we try to go forward.
        self.last_URL = self.curr_URL

    def back(self, steps: int) -> str:
        # Move 'curr_URL' pointer in left direction.
        self.curr_URL = max(0, self.curr_URL - steps)
        return self.visited_URLs[self.curr_URL]

    def forward(self, steps: int) -> str:
        # Move 'curr_URL' pointer in right direction.
        self.curr_URL = min(self.last_URL, self.curr_URL + steps)
        return self.visited_URLs[self.curr_URL]


bh=BrowserHistory1("leetcode.com")
bh.visit("google.com")
bh.visit("facebook.com")
bh.visit("youtube.com")
print(bh.back(1))
print(bh.back(1))
print(bh.forward(1))
bh.visit("linekdin.com")
print(bh.forward(2))
print(bh.back(2))
print(bh.back(7))




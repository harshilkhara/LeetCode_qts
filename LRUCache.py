class ListNode:
    
    def __init__(self,key=-1, val=-1):
        self.key=key 
        self.val=val 
        self.next=None 
        self.prev=None
        
        
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity=capacity
        self.dic={}
        self.head=ListNode()
        self.tail=ListNode()
        self.head.next=self.tail
        self.tail.prev=self.head 

    def get(self, key: int) -> int:
        if key not in self.dic:
            return -1
        node=self.dic[key]
        self.remove(node)
        self.add(node)
        return node.val 

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            node=self.dic[key]
            self.remove(node)
        
        node=ListNode(key, value)
        self.dic[key]=node
        self.add(node)
        
        if len(self.dic) > self.capacity:
            node=self.head.next 
            self.remove(node)
            del self.dic[node.key]
    
    def add(self, node):
        previousEnd=self.tail.prev 
        previousEnd.next=node 
        node.prev=previousEnd
        node.next=self.tail 
        self.tail.prev=node 
        
    
    def remove(self, node):
        node.prev.next=node.next
        node.next.prev=node.prev 
        

# Approach 2- Built- in
import collections

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dic = collections.OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.dic:
            return -1
        
        self.dic.move_to_end(key)
        return self.dic[key]
        
    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            self.dic.move_to_end(key)
        
        self.dic[key] = value
        if len(self.dic) > self.capacity:
            self.dic.popitem(False)

        
lru=LRUCache(2)
lru.put(1,1)
lru.put(2,2)
print(lru.get(1))
lru.put(3,3)
print(lru.get(2))
lru.put(4,4)
print(lru.get(1))
print(lru.get(3))
print(lru.get(4))

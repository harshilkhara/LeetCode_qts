class Node:
    def __init__(self, val=-1, next=None):
        self.val=val 
        self.next=next


class LinkedList:

    def __init__(self):
        self.head=Node()

    def insert(self, list, val):
        newNode=Node(val)
        newNode.next=None 

        if not self.head:
            self.head.next=newNode 
        else:
            last=self.list.head
            while last.next:
                last=last.next

        last.next=newNode 

        return self.list


    def constructLinkedList(self, keys):
        self.list=LinkedList()
        for key in keys:
            self.list=self.insert(self.list, key)

        return self.list 

    def printListHead(self, head):
        currNode=head
        while currNode:
            print(currNode.val, end=" ")
            currNode=currNode.next 

        return

class Solution:
# Approach 3- One pass 
    def swapNodes(self, head, k): # TC O(n) // SC O(1)
        n=0
        frontNode, endNode=Node(), Node() 
        currNode=head
        while currNode:
            n+=1
            if endNode:
                endNode=endNode.next
            
            if n==k:
                frontNode=currNode 
                endNode=head
            
            currNode=currNode.next;


        frontNode.val, endNode.val=endNode.val, frontNode.val 

        return head

ll=LinkedList()
keys=[1,2,3,4,5]
list=ll.constructLinkedList(keys)
ll.printListHead(list.head.next)
s=Solution()
result=s.swapNodes(list.head.next, 2)
print("")
ll.printListHead(result)
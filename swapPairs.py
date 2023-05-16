class Node:
	def __init__(self, val=None, next=None):
		self.val=val
		self.next=next


class LinkedList:
	def __init__(self):
		self.head=Node()

	def insert(self, list, val):
		newNode=Node(val)
		newNode.next=None 

		if not self.head:
			self.head=newNode 
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
# Approach 1- Recursive
	def swapPairs(self, head): # TC O(n) // SC O(1)

		if not head or not head.next:
			return head 

		firstNode=head 
		secondNode=head.next

		firstNode.next=self.swapPairs(secondNode.next)
		secondNode.next=firstNode 

		return secondNode

# Approach 2- Iterative
	def swapPairs1(self, head): # TC O(n) // SC O(1)
		dummy=Node(-1)
		dummy.next=head 

		prevNode=head 

		while head and head.next:
			firstNode=head 
			secondNode=head.next 

			prevNode.next=secondNode 
			firstNode.next=secondNode.next 
			secondNode.next=firstNode 

			prevNode=firstNode 
			head=firstNode.next

		return dummy.next

ll=LinkedList()
keys=[1,2,3,4,5]
list=ll.constructLinkedList(keys)
s=Solution()
result=s.swapPairs(list.head.next)
ll.printListHead(result)
print("")
result1=s.swapPairs1(list.head.next)
ll.printListHead(result1)

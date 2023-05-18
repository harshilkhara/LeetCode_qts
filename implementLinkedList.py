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

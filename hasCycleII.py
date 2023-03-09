class ListNode:
	def __init__(self, x=None):
		self.val=x 
		self.next=None

	def constructLinkedList(self, keys):
		for k in keys:
			ListNode(k)

class Solution:
	def detectCycle(self, head): # TC O(n) // SC O(n)
		seen=set()
		node=head 
		while node:
			if node in seen:
				return node 
			seen.add(node)
			node=node.next 
		return None 

	def detectCycle1(self, head): # TC O(n) // SC O(1)
		if not head: return None
		def getIntersect():
			tortoise,hare=head,head 
			while hare and hare.next:
				tortoise=tortoise.next 
				hare=hare.next.next 
				if tortoise==hare:
					return tortoise 
			return None
		intersect=getIntersect()
		if not intersect: return None 
		ptr1=head 
		ptr2=intersect 
		while ptr1!=ptr2:
			ptr1=ptr1.next 
			ptr2=ptr2.next 
		return ptr1 

head=ListNode(3)
head.next=ListNode(2)
head.next.next=ListNode(0)
head.next.next.next=ListNode(-4)
head.next.next.next=head.next 
#ll=ListNode()
#LinkedList=ll.constructLinkedList([3,2,0,-4])
s=Solution()
print(s.detectCycle(head).val)
print(s.detectCycle1(head).val)


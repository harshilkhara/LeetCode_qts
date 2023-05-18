from implementLinkedList import *
class Solution:
# Approach 1- Converting to arraylist
	def pairSumLinkedList(self, head): # TC O(n) // SC O(n)
		current = head
		values = []

		while current:
		    values.append(current.val)
		    current = current.next

		i = 0
		j = len(values) - 1
		maximumSum = 0
		while(i < j):
		    maximumSum = max(maximumSum, values[i] + values[j])
		    i = i + 1
		    j = j - 1

		return maximumSum

# Approach 2- Converting to stack
	def pairSumLinkedList1(self, head): # TC O(n) // SC O(n)
		current = head
		st = []
		maximumSum = 0

		while current:
		    st.append(current.val)
		    current = current.next

		current = head
		size = len(st)
		count = 1
		maximumSum = 0
		while count <= size/2:
		    maximumSum = max(maximumSum, current.val + st.pop())
		    current = current.next
		    count = count + 1

		return maximumSum

# Approach 3- Reversing second half in place 
	def pairSumLinkedList2(self, head): # TC O(n) // SC O(1)
		slow, fast = head, head
		maximumSum = 0

		# Get middle of the linked list.
		while fast and fast.next:
		    fast = fast.next.next
		    slow = slow.next

		# Reverse second half of the linked list.
		curr, prev = slow, None
		while curr:       
		    curr.next, prev, curr = prev, curr, curr.next

		start = head
		while prev:
		    maximumSum = max(maximumSum, start.val + prev.val)
		    prev = prev.next
		    start = start.next

		return maximumSum


ll=LinkedList()
keys=[5,4,2,1]
list=ll.constructLinkedList(keys)
s=Solution()
print(s.pairSumLinkedList(list.head.next))
print(s.pairSumLinkedList1(list.head.next))
print(s.pairSumLinkedList2(list.head.next))


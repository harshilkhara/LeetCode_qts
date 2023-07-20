from implementLinkedList import *
class Solution:
# Approach 1- Using stacks
    def addTwoNumbersLinkedList(self, l1, l2): # TC O(m+n) SC O(m+n)
        s1, s2=[],[]

        while l1 or l2:
            if l1:
                s1.append(l1.val)
                l1=l1.next 
            if l2:
                s2.append(l2.val)
                l2=l2.next 
        
        totalSum=0
        ans=Node()
        while s1 or s2:
            if s1: totalSum+=s1.pop()
            if s2: totalSum+=s2.pop()
        
            ans.val=totalSum%10
            carry=totalSum//10
            head=Node(carry)
            head.next=ans 
            ans=head 
            totalSum=carry
        
        return ans.next if carry==0 else ans

# Approach 2- Reverse the linked list
    def reverseList(self, head): # TC O(m+n) SC O(m+n)
        prev = None
        temp = None
        while head:
            # Keep the next node
            temp = head.next
            # Reverse the link
            head.next = prev
            # Update the previous node and the current node.
            prev = head
            head = temp
        return prev

    def addTwoNumbers(self, l1, l2):
        r1 = self.reverseList(l1)
        r2 = self.reverseList(l2)

        total_sum = 0
        carry = 0
        ans = ListNode()
        while r1 or r2:
            if r1:
                total_sum += r1.val
                r1 = r1.next
            if r2:
                total_sum += r2.val
                r2 = r2.next

            ans.val = total_sum % 10
            carry = total_sum // 10
            head = ListNode(carry)
            head.next = ans
            ans = head
            total_sum = carry

        return ans.next if carry == 0 else ans

ll=LinkedList()
keys1=[7,2,4,3]
keys2=[5,6,4]
list1=ll.constructLinkedList(keys1)
list2=ll.constructLinkedList(keys2)
ll.printListHead(list1.head.next)
ll.printListHead(list2.head.next)
s=Solution()
result=s.addTwoNumbersLinkedList(list1.head, list2.head)
ll.printListHead(result)
        
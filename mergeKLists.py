class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Approach 1- Brute Force
class Solution: 
    def mergeKLists(self, lists): # TC O(n log n) // SC O(n)
        lst=[]
        for node in lists:
            while node:
                lst.append(node.val)
                node=node.next 
        lst.sort()
        head=ListNode()
        node=head
        for val in lst:
            node.next=ListNode(val)
            node=node.next 
        node.next=None
        return head.next
            
list1=ListNode(1)
list1=ListNode(4)
list1=ListNode(5)
list2=ListNode(1)
list2=ListNode(1)
list2=ListNode(4)
list3=ListNode(2)
list3=ListNode(6)
s=Solution()
print(s.mergeKLists([list1.head,list2.head,list3.head]))
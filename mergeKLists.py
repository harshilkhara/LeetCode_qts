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

# Approach 2- Merge with divide and conquer
    def mergeKLists(self, lists): # TC O(n log k) // SC O(1)
        amount = len(lists)
        interval = 1
        while interval < amount:
            for i in range(0, amount - interval, interval * 2):
                lists[i] = self.merge2Lists(lists[i], lists[i + interval])
            interval *= 2

        return lists[0] if amount > 0 else None

    def merge2Lists(self, l1, l2):
        head = point = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                point.next = l1
                l1 = l1.next
            else:
                point.next = l2
                l2 = l1
                l1 = point.next.next
            point = point.next

        point.next=l1 if l1 else l2

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
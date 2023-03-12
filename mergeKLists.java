import java.util.*;
//Approach 1- Brute Force - get all the nodes in list and make a list out of it 
class Solution{ // TC O(n log n) SC O(n)
	public Node mergeKLists(Node[] lists){
		List<Integer> nodes=new ArrayList<>();
		//for(Node l: lists)
		for(int i=0; i<lists.length; i++){
			// while(l!=null)
			while(lists[i]!=null){
				nodes.add(lists[i].data);
				lists[i]=lists[i].next;
			}
		}
		Collections.sort(nodes);
		Node head= new Node(0);
		Node point=head;
		// for(int i: nodes)
		for(int i=0; i<nodes.size(); i++){
			//point.next= new Node(i);
			Node temp=new Node(nodes.get(i));
			point.next=temp;
			point=point.next;
		}
		return head.next;
	}
}

// Approach 2- Compare one by one using priority queue
class Solution1{ // TC O(n log k) SC O(n)
    public Node mergeKLists(Node[] lists) {
        Comparator<Node> cmp;
        cmp = new Comparator<Node>() {  
        @Override
        public int compare(Node o1, Node o2) {
            // TODO Auto-generated method stub
            return o1.data-o2.data;
        }
        };
        Queue<Node> q = new PriorityQueue<Node>(cmp);
        for(Node l : lists){
            if(l!=null){
            	System.out.println(l.data);
                q.add(l);
            }        
        }
        Node head = new Node(0);
        Node point = head;
        while(!q.isEmpty()){ 
            point.next = q.poll();
            point = point.next; 
            Node next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }
}

// Approach 3- Merge with divide and conquer
class Solution2{ // TC O(n log k) SC O(1)
    public Node mergeTwoLists(Node l1, Node l2) {
        Node h = new Node(0);
        Node ans=h;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        } 
        return ans.next;
    }

    public Node mergeKLists(Node[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);            
            }
            interval*=2;
        }

        return lists[0];
    }
}

class mergeKLists{
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		int[] list1= {1,4,5};
		int[] list2= {1,3,4};
		int[] list3= {2,6};
		LinkedList list11= ll.constructLinkedList(list1);
		LinkedList list12= ll.constructLinkedList(list2);
		LinkedList list13= ll.constructLinkedList(list3);
		Node[] lists={list11.head,list12.head,list13.head};
		Solution s= new Solution();
		Node result= s.mergeKLists(lists);
		ll.printListHead(result);
		Solution1 s1= new Solution1();
		Node result1= s1.mergeKLists(lists);
		ll.printListHead(result1);
		Solution2 s2= new Solution2();
		Node result2= s2.mergeKLists(lists);
		ll.printListHead(result2);
		
	}
}
class Node{
	int val;
	Node next; 

	Node(int x){
		val=x;
	}
}

class LinkedList{
	Node head; 

	public LinkedList insert(LinkedList list,int key){
		Node newNode= new Node(key); 
		newNode.next= null;

		if(list.head==null){
			list.head=newNode;
		}

		else{
			Node last= list.head;
			while(last.next!=null)
				last=last.next;
			last.next=newNode;
		}
		return list;
	}

	public LinkedList constructLinkedList(int [] keys){
		LinkedList list= new LinkedList();
		for(int key: keys)
			list=insert(list,key);
		return list;
	}

	public void printList(Node head){
		Node currNode= head;
		while(currNode!=null){
			System.out.print(currNode.val + " ");
			currNode=currNode.next;
		}
		System.out.println(" ");
	}

	public Node mergeLists(Node list1,Node list2){
		Node head = new Node(-1);
		Node tail=head;

		while(list1!=null && list2!=null){
			if(list1.val<list2.val){
				tail.next=list1;
				list1=list1.next;
			} else {
				tail.next=list2;
				list2=list2.next;
			}

			tail=tail.next;
		}
		tail.next= list1==null ? list2:list1;

		return head.next;
	}

	public Node mergeLists1(Node list1,Node list2){
		if (list1==null) return list2;
		if (list2==null) return list1;

		Node head;
		if(list1.val<list2.val){
			head=list1;
			list1=list1.next;
		}else {
			head=list2;
			list2=list2.next;
		}

		head.next=mergeLists(list1,list2);
		return head;
	}
}

class checking{
	public static void main(String[] args) {
		int [] keys1={1,2,4};
		int [] keys2={1,3,4};

		LinkedList ll= new LinkedList();
		LinkedList list1=ll.constructLinkedList(keys1);
		LinkedList list2=ll.constructLinkedList(keys2);
		System.out.println("List 1- " );
		ll.printList(list1.head);
		System.out.println("List 2- " );
		ll.printList(list2.head);
		Node result=ll.mergeLists1(list1.head,list2.head);
		System.out.println("Merged List is- " );
		ll.printList(result);
	}
}

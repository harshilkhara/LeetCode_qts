class Node {
	int data;
	Node next; 

	Node(int x){
		data=x;
	}
}
class LinkedList{

	Node head;

	// Method to insert a new node 
    public static LinkedList insertLinkedList(LinkedList list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
    
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
    
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
    
        // Return the list by head 
        return list; 
    }

    public static LinkedList constructLinkedList(int [] keys){
    	LinkedList list= new LinkedList();
    	for(int key: keys)
			list=insertLinkedList(list,key);
		return list;
    }


    // Method to print the LinkedList. 
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
     
        System.out.print("LinkedList: "); 
     
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
     
            // Go to next node 
            currNode = currNode.next; 
        }
        System.out.println(" ");
    }

    // Method to print the LinkedList with head 
     public void printListHead(Node head){
        Node currNode= head; 
        while(currNode!=null){
            System.out.print(currNode.data + " ");
            currNode=currNode.next;
        }
        System.out.println(" ");
    }

    public void setPos(Node head,int pos){
        Node currNode=head; 
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=head;

    }
}

class implementLinkedList{
	public static void main(String[] args) {
		int [] keys1={1,2,4};
		int [] keys2={1,3,4};
		LinkedList ll= new LinkedList();
		LinkedList list1=ll.constructLinkedList(keys1);
		LinkedList list2=ll.constructLinkedList(keys2);
		ll.printList(list1);
		ll.printList(list2);
	

	}
}
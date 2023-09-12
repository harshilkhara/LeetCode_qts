#include <iostream>
#include <vector>
using namespace std;

struct Node{
	int val;
	Node* next;

	Node(int val): val(val), next(nullptr){};
};

class LinkedList{
public:
	Node* head=nullptr;

	LinkedList* insert(LinkedList* list, int val){

		Node* newNode = new Node(val);
		newNode->next=nullptr;

		if(list->head==nullptr){
			list->head=newNode;
		} else {
			Node* last=list->head;
			while(last->next!=nullptr){
				last=last->next;
			}

			last->next=newNode;
		}
		return list;
	}

	void printListHead(Node* head){
		Node* currNode=head;
		while(currNode!=nullptr){
			cout << currNode->val << " ";
			currNode=currNode->next;
		}
	}

	LinkedList* constructLinkedList(vector<int> keys){
		LinkedList* list=new LinkedList();
		for(int i=0; i<keys.size(); i++){
			list=insert(list, keys[i]);
		}
		return list;
	}
};

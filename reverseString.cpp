#include <iostream>
#include <string>

using namespace std;

void reverse(char word[], int size){
	int left=0, right=size-1;
	while (left<right){
		char temp=word[left];
		word[left++]=word[right];
		word[right--]=temp;
	}
}

int main(){
	char word[]={'h', 'e', 'l', 'l', 'o'};
	int size=(sizeof(word)/sizeof(word[0]));
	reverse(word, size);
	for(int i=0; i<size; i++){
		cout << word[i] << " ";
	}

	return 0;
}
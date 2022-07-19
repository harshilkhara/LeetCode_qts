//Approach 1- Two Pointers 
import java.util.*;
class Solution{

	public void swap(Character [] s,int a,int b){
		Character temp= s[a]; 
		s[a]=s[b];
		s[b]=temp;
	}
	public Character[] reverseString(Character [] s){
		int l= 0, r=s.length-1;
		while (l<=r){
			swap(s,l++,r--);
			//l++;
			//r--;
		}
		return s;
	}
}

// Approach 2- Making a new array
class Solution1{
	public Character[] reverseString(Character []s){
		Character[] reversedString= new Character[s.length];
		int l=0;
		for (int i=s.length-1;i>=0;i--){
			reversedString[l++]=s[i];
		}  

		return reversedString;
	}
}

class reverseString{
	public static void main(String[] args) {
		Character [] s= {'h','e','l','l','o'};
		Character [] s1={'h','a','r','s','h','i','l'};
		Solution x= new Solution();
		Solution1 y= new Solution1();
		System.out.println(Arrays.toString(x.reverseString(s)));
		//System.out.println(x.reverseString(s).toString());
		System.out.println(Arrays.toString(y.reverseString(s1)));


	}
}
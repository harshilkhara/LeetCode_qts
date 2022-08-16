import java.util.*;

// Approach 1- With HashMap
class Solution{
	public int firstUniqueChar(String s){
		HashMap<Character,Integer> map =new HashMap<>();
		for (int i =0; i< s.length();i++){
		map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	/* for(char i : s.toCharArray()){
		map.put(i,map.getOrDefault(i,0)+1);
	*/

	for (int i =0; i< s.length();i++){
		if (map.get(s.charAt(i))==1) return i;
	}
	return -1;
	}
}

// Approach 2- With Array
class Solution1{
	public int firstUniqueChar(String s){
		int [] count= new int [26];
		for (int i =0; i< s.length();i++){
		count[s.charAt(i)-'a']++;
	}
	for (int i =0; i< s.length();i++){
		if (count[s.charAt(i)-'a']==1) return i;
	}
	return -1;
	}
}

class firstUniq{
	public static void main(String[] args) {
		String s= "loveleetcode";
		Solution x = new Solution();
		Solution1 x1= new Solution1();
		System.out.println(x.firstUniqueChar(s));
		System.out.println(x1.firstUniqueChar(s));
	}
}
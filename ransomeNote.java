
// Approach 1- Simulation 
class ransomeNote{
	public static void main(String [] args){
		String ransomNote="a"; 
		String magazine= "aba"; 
		for (char c : ransomNote.toCharArray()){
			int index = magazine.indexOf(c); 

			if (index==-1){
				System.out.println("False");
			} 

			magazine= magazine.substring(0,index) + magazine.substring(index+1); 
		} 
		System.out.println("True");
	}
}

// Approach 2- Tow HashMaps
import java.util.*;
class ransomeNote{
	public static HashMap<Character,Integer>map(String s){
		HashMap<Character,Integer> map = new HashMap<>();
		for (char c: s.toCharArray()){
			int freq=map.getOrDefault(c,0); 
			map.put(c,freq+1);
		}
		return map;

	}
	public static void main(String [] args){
		
		String ransomeNote="abc"; 
		String magazine= "abac";  

		if (ransomeNote.length()> magazine.length()){
			System.out.println("False");
		}
		HashMap<Character, Integer>ransomeMap= map(ransomeNote); 
		HashMap<Character, Integer>magazineMap= map(magazine);

		for (char c: ransomeNote.toCharArray()){
			if (ransomeMap.get(c)> magazineMap.getOrDefault(c,0)){
				System.out.println("False");
			}
		}
		System.out.println("True");

	}
}


// Approach 3- One HashMap 

import java.util.*; 

class ransomeNote{

	public static HashMap<Character,Integer>map(String s){
		HashMap<Character,Integer> map = new HashMap<>();
		for (char c: s.toCharArray()){
			int freq=map.getOrDefault(c,0); 
			map.put(c,freq+1);
		}
		return map;
	}

	public static void main (String[] args){
		String ransomeNote="abcc"; 
		String magazine= "abac";  

		if (ransomeNote.length()> magazine.length()){
			System.out.println("False");
		}

		HashMap<Character,Integer> magazineMap= map(magazine);

		for (char c: ransomeNote.toCharArray()){
			if (magazineMap.get(c)<=0){
				System.out.println(false);
			}
			int freq= magazineMap.getOrDefault(c,0);
			magazineMap.put(c,freq-1);
		}

		System.out.println(true);

	}
}

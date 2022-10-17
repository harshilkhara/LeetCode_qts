import java.util.*;
// Approach 1- Array as counter (using boolean)
class Solution{ // TC O(n) SC O(1)
	public boolean checkIfPangram(String sentence){
		boolean[] seen= new boolean[26];
		for(char c: sentence.toCharArray()){
			seen[c-'a']=true;
		}

		for(boolean status:seen){
			if(!status)
				return false;
		}
		return true;
	}
}

// Approach 2- Finding each letter
class Solution1{ // TC O(n) SC O(1)
    public boolean checkIfPangram(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char)('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if (sentence.indexOf(currChar) == -1)
                return false;
        }
        
        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }
}

// Approach 3- Using set 
class Solution2{ // TC O(n) SC O(1)
    public boolean checkIfPangram(String sentence) {
        // Empty set 'seen'.
        Set<Character> seen = new HashSet<>();
        
        // Iterate over 'sentence' add every letter to 'seen'.
        for (char currChar : sentence.toCharArray())
            seen.add(currChar);
        
        // If the size of 'seen' is 26, then 'sentence' is a pangram.
        return seen.size() == 26;
    }
}

// Coded by me 
// Apporach 4- Array as counter (using count)
class Solution3{ // TC O(n) SC O(1)
    public boolean checkIfPangram(String sentence) {
        int[] freq= new int[26];
        for (char c : sentence.toCharArray()){
            freq[c-'a']++;
            //System.out.println(c-'a');
        }
        
        for (int count: freq){
            if(count<1)
                return false;
        }
        
        return true;
    }
}

// Approach 5- Bit Manipulation
class Solution4{ // TC O(n) SC O(1)
    public boolean checkIfPangram(String sentence) {
        // Initialize seen = 0 since we start with no letter.
        int seen = 0;
        
        // Iterate over 'sentence'.
        for (char currChar : sentence.toCharArray()) {
            // Map each 'currChar' to its index using its ASCII code.
            int mappedIndex = currChar - 'a';

            // 'currBit' represents the bit for 'currChar'.
            int currBit = 1 << mappedIndex;

            // Use 'OR' operation since we only add its bit for once.
            seen |= currBit;
        }
        
        // Once we finish iterating, check if 'seen' contains 26 bits of 1.
        return seen == (1 << 26) - 1;
    }
}


class checkIfPangram{
  public static void main(String[] args){
    String sentence="thequickbrownfoxjumpsoverthelazydog";
    Solution s = new Solution();
    System.out.println(s.checkIfPangram(sentence));
    Solution1 s1 = new Solution1();
    System.out.println(s1.checkIfPangram(sentence));
    Solution2 s2 = new Solution2();
    System.out.println(s2.checkIfPangram(sentence));
    Solution3 s3= new Solution3();
    System.out.println(s3.checkIfPangram(sentence));
    Solution4 s4 = new Solution4();
    System.out.println(s4.checkIfPangram(sentence));
    
  }
}
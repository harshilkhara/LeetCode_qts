class Solution{
	public String breakPalindrome(String palindrome){
		
		// Strings are immutable in Java, convert it into a char array
		char[] palindromeArray= palindrome.toCharArray();
		for (int i=0; i<palindrome.length()/2; i++){
			if(palindromeArray[i]!='a'){
				palindromeArray[i]='a';
				return String.valueOf(palindromeArray);
			}
		}
		palindromeArray[palindrome.length()-1]='b';
		return String.valueOf(palindromeArray);
	}
}

class breakPalindrome{
	public static void main(String[] args) {
		String palindrome="abba";
		Solution s= new Solution();
		System.out.println(s.breakPalindrome(palindrome));

	}
}
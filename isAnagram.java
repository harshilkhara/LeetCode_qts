class Solution{
	public boolean isAnagram(String s, String t){
		if (s.length()!=t.length()){
			return false;
		}
		int[] counter= new int[26];
		for (int i=0;i<s.length();i++){
			counter[s.charAt(i)-'a']++;
			counter[t.charAt(i)-'a']--;
		}
		for (int count:counter){
			if (count!=0){
				return false;
			}
		}
		return true;
	}
}

class Solution1{
	public boolean isAnagram(String s, String t){
		if (s.length()!=t.length()){
			return false;
		}
		int[] table= new int[26];
		for (int i = 0; i < s.length(); i++){
        	table[s.charAt(i) - 'a']++;
    	}
    	for (int i = 0; i < t.length(); i++){
        		table[t.charAt(i) - 'a']--;
        		if (table[t.charAt(i) - 'a'] < 0){
            		return false;
        		}
    		}
    	return true;
	}
}

class isAnagram{
	public static void main(String[] args){
		String s= "car";
		String t= "rc";
		Solution x= new Solution();
		Solution1 y= new Solution1();
		System.out.println(x.isAnagram(s,t));
		System.out.println(y.isAnagram(s,t));
	}
}
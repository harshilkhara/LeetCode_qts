// Approach 1- Two HashMaps 
import java.util.*;
class Solution{                  // TC O(N*K) SC O(N*K)
	public List<String> findAndReplacePattern(String [] words, String pattern){
		List<String> ans = new ArrayList<>();
		for(String word:words){
			if (match(word,pattern)){
				ans.add(word);
			}
		}
		return ans;
	}

	public boolean match(String word,String pattern){
		HashMap<Character,Character> m1= new HashMap<>();
		HashMap<Character,Character> m2= new HashMap<>();

		for (int i=0; i < word.length();i++){
			char w=word.charAt(i);
			char p=pattern.charAt(i);

			if(!m1.containsKey(w)) m1.put(w,p);
			if(!m2.containsKey(p)) m2.put(p,w);

			if(m1.get(w)!=p || m2.get(p)!=w)
				return false;
		}
		return true;
	}

}

/* Approach 2- One HashMap

Algorithm- As in Approach 1, we can have some forward map m1:L→L, where L is the set of letters.

However, instead of keeping track of the reverse map m2, we could simply make sure 
that every value m1(x) in the codomain is reached at most once. This would guarantee 
the desired permutation exists.

So our algorithm is this: after defining m1(x) in the same way as Approach 1 
(the forward map of the permutation), afterwards we make sure it reaches distinct values.

*/

class Solution1{ // TC O(N*K) SC O(N*K)
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m.containsKey(w)) m.put(w, p);
            if (m.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p: m.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
}

class findAndReplacePattern{
	public static void main(String[] args) {
		String [] words={"abc","deq","mee","aqq","dkd","ccc"};
		String pattern= "abb";
		Solution s= new Solution();
		System.out.println(s.findAndReplacePattern(words,pattern));
		Solution1 s1= new Solution1();
		System.out.println(s1.findAndReplacePattern(words,pattern));

	}
}
import java.util.*;
// Approach 1- Sliding window with HashMaps 
class Solution { // TC O(Ns+Np) SC O(1)
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList<>();

    Map<Character, Integer> pCount = new HashMap<>();
    Map<Character, Integer> sCount = new HashMap<>();
    // build reference hashmap using string p
    for(char c: p.toCharArray()){
            pCount.put(c,pCount.getOrDefault(c,0)+1);
        }

    List<Integer> output = new ArrayList<>();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter 
      // on the right side of the window
      char ch = s.charAt(i);
      sCount.put(ch,sCount.getOrDefault(ch,0)+1);
      // remove one letter 
      // from the left side of the window
      if (i >= np) {
        ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        }
        else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }
      // compare hashmap in the sliding window
      // with the reference hashmap
      if (pCount.equals(sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}

// Approach 2- Sliding window with arrays 
class Solution { // TC O(Ns+Np) SC O(1)
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();

    int [] pCount = new int[26];
    int [] sCount = new int[26];
    // build reference array using string p
    for (char ch : p.toCharArray()) {
      pCount[ch - 'a']++;
    }

    List<Integer> output = new ArrayList();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter 
      // on the right side of the window
      sCount[s.charAt(i) - 'a']++;
      // remove one letter 
      // from the left side of the window
      if (i >= np) {
        sCount[s.charAt(i - np) - 'a']--;
      }
      // compare array in the sliding window
      // with the reference array
      if (Arrays.equals(pCount, sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}
class findAnagrams{
  public static void main(String[] args) {
    String s="cbaebabacd";
    String p="abc";
    Solution x= new Solution();
    System.out.println(x.findAnagrams(s,p));
  }
}
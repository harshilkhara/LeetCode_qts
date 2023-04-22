import java.util.*;
// Approach 1- Brute Force
class Solution { // TC O(n^2) SC O(1)
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        // List to store the anagram mappings.
        int[] mappings = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // Store the corresponding index of number in the second list.
                if (nums1[i] == nums2[j]) {
                    mappings[i] = j;
                    break;
                }
            }
        }
        return mappings;
    }
}

// Approach 2- Hashmap
class Solution1{ // TC O(n) SC O(n)
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] answer=new int[nums1.length];
        Map<Integer, Integer> map=new HashMap<>();
        int i=0;
        for(int num: nums2){
            map.put(num, i++);
        }
        i=0;
        for(int num1: nums1){
            answer[i++]=map.get(num1);
        }
        return answer;
    }
}

class anagramMappings{
    public static void main(String[] args) {
        int[] nums1={12,28,46,32,50};
        int[] nums2={50,12,32,46,28};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.anagramMappings(nums1,nums2)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.toString(s1.anagramMappings(nums1,nums2)));

    }
}
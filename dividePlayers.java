import java.util.*;
// Approach 1- Sort and divide 
// Very similar to twoSum when input is sorted 
class Solution { // TC O(n log n) SC O(1)
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long res=0;
        int l=0, r=skill.length-1;
        int skills=skill[0]+skill[skill.length-1];
        while (l<r){
            int totalSkill=skill[l]+skill[r];
            if (totalSkill!=skills){
                return -1;
            }
            res+=skill[l]*skill[r];
            l++;
            r--;
        }
        return res;
    }
}

// Approach 2- Counting sort 
class Solution1{ // TC O(n) SC O(1)
    public long dividePlayers(int[] skill) {
        int[] count = new int[1005];
        int sum = 0;
        int n = skill.length;
        for (int i : skill) {
            sum += i;
            count[i]++;
        }
        long res = 0;
        int s = sum / (n / 2);
        if (s * (n / 2) != sum) {
            return -1;
        }
        for (int i = 1; i <= s / 2; i++) {
            while (count[i] > 0) {
                int next = s - i;
                if (count[next] == 0) {
                    return -1;
                }
                res += i * next;
                count[i]--;
                count[next]--;
            }
        }
        return res;
    }
}

class dividePlayers{
    public static void main(String[] args) {
        int[] skill={3,2,5,1,3,4};
        Solution s= new Solution();
        System.out.println(s.dividePlayers(skill));
        Solution1 s1= new Solution1();
        System.out.println(s1.dividePlayers(skill));
    }

}
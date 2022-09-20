import java.util.*;
import java.math.BigInteger;

// Approach 1- DP (Bottom-up)
class Solution { // TC O(m*n) SC O(m*n)
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        int[][] memo=new int[nums1.length+1][nums2.length+1];
        for(int i= nums1.length-1; i>=0; i--){
            for (int j=nums2.length-1;j>=0; j--){
                if (nums1[i]==nums2[j]){
                    memo[i][j]=memo[i+1][j+1]+1;
                    if(ans<memo[i][j])
                        ans=memo[i][j];
                }
            }
        }
        return ans;
    }
}

// Approach 2- Binary Search with naive check (NOTE- it times out)
class Solution1{ // TC O((m+n)* min(m,n)*log(min(m,n)) SC O(m^2)
    public boolean check(int length, int[] A, int[] B) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i + length <= A.length; ++i) {
            seen.add(Arrays.toString(Arrays.copyOfRange(A, i, i+length)));
        }
        for (int j = 0; j + length <= B.length; ++j) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(B, j, j+length)))) {
                return true;
            }
        }
        return false;
    }

    public int findLength(int[] A, int[] B) {
        int lo = 0, hi = Math.min(A.length, B.length) + 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) lo = mi + 1;
            else hi = mi;
        }
        return lo - 1;
    }
}

// Approach 3- Binary Search with Rolling Hash (Rabin-Karp)
class Solution2{ // TC O((m+n) * log(min(m,n))) SC O(m)
    int P = 113;
    int MOD = 1_000_000_007;
    int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

    private int[] rolling(int[] source, int length) {
        int[] ans = new int[source.length - length + 1];
        long h = 0, power = 1;
        if (length == 0) return ans;
        for (int i = 0; i < source.length; ++i) {
            h = (h + source[i] * power) % MOD;
            if (i < length - 1) {
                power = (power * P) % MOD;
            } else {
                ans[i - (length - 1)] = (int) h;
                h = (h - source[i - (length - 1)]) * Pinv % MOD;
                if (h < 0) h += MOD;
            }
        }
        return ans;
    }

    private boolean check(int guess, int[] A, int[] B) {
        Map<Integer, List<Integer>> hashes = new HashMap<>();
        int k = 0;
        for (int x: rolling(A, guess)) {
            hashes.computeIfAbsent(x, z -> new ArrayList<>()).add(k++);
        }
        int j = 0;
        for (int x: rolling(B, guess)) {
            for (int i: hashes.getOrDefault(x, new ArrayList<Integer>()))
                if (Arrays.equals(Arrays.copyOfRange(A, i, i+guess),
                                  Arrays.copyOfRange(B, j, j+guess))) {
                    return true;
                }
            j++;
        }
        return false;
    }

    public int findLength(int[] A, int[] B) {
        int lo = 0, hi = Math.min(A.length, B.length) + 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) lo = mi + 1;
            else hi = mi;
        }
        return lo - 1;
    }
}
class findLength{
    public static void main(String[] args) {
        int[] nums1={1,2,3,2,1};
        int[] nums2={3,2,1,4,7};
        Solution s= new Solution();
        System.out.println(s.findLength(nums1,nums2));
        Solution1 s1= new Solution1();
        System.out.println(s1.findLength(nums1,nums2));
        Solution2 s2= new Solution2();
        System.out.println(s2.findLength(nums1,nums2));
    }
}
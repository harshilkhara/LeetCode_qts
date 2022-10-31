// Very similar to twoSum.java and .py if you think about it
// Approach 1- Brute Force
class Solution { // TC O(n^2) SC O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0, n = time.length;
        for (int i = 0; i < n; i++) {
            // j starts with i+1 so that i is always to the left of j
            // to avoid repetitive counting
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Approach 2- HashMap or Array to keep count of frequencies
class Solution1{ // TC O(n) SC O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}

class numPairsDivisibleBy60{
    public static void main(String[] args) {
        int[] time={30,20,150,100,40};
        Solution s= new Solution();
        System.out.println(s.numPairsDivisibleBy60(time));
        Solution1 s1= new Solution1();
        System.out.println(s1.numPairsDivisibleBy60(time));
    }
}
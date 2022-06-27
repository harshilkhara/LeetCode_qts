// Approach 1- DP  TC O(k) // SC O(k)
class Solution{
	public int maxScoreOfCards(int[] cardPoints,int k){
		int n = cardPoints.length;

        int[] frontSetOfCards = new int[k + 1];
        int[] rearSetOfCards = new int[k + 1];

        for (int i = 0; i < k; i++) {
            frontSetOfCards[i + 1] = cardPoints[i] + frontSetOfCards[i];
            rearSetOfCards[i + 1] = cardPoints[n - i - 1] + rearSetOfCards[i];
        }

        int maxScore = 0;
        // Each i represents the number of cards we take from the front.
        for (int i = 0; i <= k; i++) {
            int currentScore = frontSetOfCards[i] + rearSetOfCards[k - i];
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
	}
	
}

// Approach 2- DP but space optimized  TC O(k) // SC O(1)
class Solution1{
	public int maxScoreOfCards(int [] cardPoints, int k){
		int frontScore = 0;
        int rearScore = 0;
        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            frontScore += cardPoints[i];
        }

        // take all k cards from the beginning
        int maxScore = frontScore;

        // take i from the beginning and k - i from the end
        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int currentScore = rearScore + frontScore;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
	}
}

// Approach 3- Sliding Window (Two pointers) TC O(n) // SC O(1)

class Solution2{
	public int maxScoreOfCards(int [] cardPoints, int k){
		int startingIndex = 0; // left pointer 
        int presentSubarrayScore = 0;
        int n = cardPoints.length;
        int requiredSubarrayLength = n - k;
        int minSubarrayScore;
        int totalScore = 0;

        // Total score obtained on selecting all the cards.
        for (int i : cardPoints) {
            totalScore += i;
        }

        minSubarrayScore = totalScore;

        if (k == n) {
             return totalScore;
        }

        for (int i = 0; i < n; i++) { // i is right pointer
            presentSubarrayScore += cardPoints[i];
            int presentSubarrayLength = i - startingIndex + 1;
            // If a valid subarray (having size cardsPoints.length - k) is possible.
            if (presentSubarrayLength == requiredSubarrayLength) {
                minSubarrayScore = Math.min(minSubarrayScore, presentSubarrayScore);
                presentSubarrayScore -= cardPoints[startingIndex++];
            }
        }
        return totalScore - minSubarrayScore;
	}
}

class maxScoreOfCards{
	public static void main(String[] args){
		int[] cardPoints={1,2,3,4,5,6,1};
		int k=3;
		Solution s= new Solution();
		System.out.println(s.maxScoreOfCards(cardPoints,k));
	}
}
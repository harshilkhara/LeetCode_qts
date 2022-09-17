import java.util.*;
// Approach 1- Sorting + HashMap
class Solution{ // TC O(n log n) SC O(n)
	public int[] findOriginalArray(int [] changed){
		if (changed.length % 2 == 1) return new int[0];
		Arrays.sort(changed);
		HashMap<Integer,Integer> freq=new HashMap<>();
		for (int num: changed){
			freq.put(num,freq.getOrDefault(num,0)+1);
		}

		int [] original = new int[changed.length/2];
		int index=0;
		for (int num: changed){
			if (freq.get(num)>0){
				freq.put(num,freq.get(num)-1);
				int twiceNum=num*2;
				if(freq.containsKey(twiceNum) && freq.get(twiceNum)>0){
					freq.put(twiceNum,freq.get(twiceNum)-1);
					original[index++]=num;
				}
				else{
					return new int[0];
				}
			}
		}
		return original;
	}
}

// Approach 2- Counting Sort 
class Solution1{ // TC O(n+k) SC O(k)
    public int[] findOriginalArray(int[] changed) {
        // It can't be doubled array, if the size is odd
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        
        int maxNum = 0;
        // Find the max element in the array
        for (int num : changed) {
            maxNum = Math.max(maxNum, num);
        }
        
        int[] freq = new int[2 * maxNum + 1];
        // Store the frequency in the map
        for (int num : changed) {
            freq[num]++;
        }
        
        int[] original = new int[changed.length / 2];
        int index = 0;
        for (int num = 0; num <= maxNum; num++) {
            // If element exists
            if (freq[num] > 0) {
                freq[num]--;
                
                int twiceNum = num * 2;
                if (freq[twiceNum] > 0) {
                    // Pair up the elements, decrement the count
                    freq[twiceNum]--;
                    // Add the original number to answer
                    original[index++] = num;
                    num--;
                } else {
                    return new int[0];
                }
            }
        }
        
        return original;
    }
}

class findOriginalArray{
	public static void main(String[] args) {
		int [] changed={1,3,4,2,6,8};
		Solution s= new Solution();
		int [] answer=s.findOriginalArray(changed);
		System.out.println(Arrays.toString(answer));
		Solution1 s1= new Solution1();
		int [] answer1=s1.findOriginalArray(changed);
		System.out.println(Arrays.toString(answer1));
	}
}
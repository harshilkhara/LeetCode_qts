import java.util.*;
// Asked in Goldman Sachs interview
// Solution taken from leetcode 
class Solution {
    public int[] sortByBits(int[] arr) {
    for(int i=0; i<arr.length; i++) {
	    arr[i] = arr[i] + Integer.bitCount(arr[i])*100000000;
	    }
	Arrays.sort(arr);
	for(int i=0; i<arr.length; i++) {
		arr[i] = arr[i]%100000000;
	}
    return arr;
    }
}

class sortByBits{
	public static void main(String[] args) {
		int[] arr={31,15,7,4,2};
		Solution s= new Solution();
		System.out.println(Arrays.toString(s.sortByBits(arr)));
	}
}
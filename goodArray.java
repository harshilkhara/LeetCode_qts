// Asked in Goldman Sachs interview
// https://www.desiqna.in/6085/goldman-coding-question-solution-engineering-campus-program

// https://leetcode.com/problems/range-product-queries-of-powers/discuss/2740795
// /simple-java-solution
import java.util.*;
class Solution{ // TC O(n*m) SC O(n)
	public List<Integer> goodArray(int n, List<List<Integer>> queries){
		List<Integer> equivalentBinary= new ArrayList<>();
		List<Integer> goodArray= new ArrayList<>();
		while(n>0){
			equivalentBinary.add(n%2);
			n=n/2;
		}

		for(int i=0; i<equivalentBinary.size();i++){
			if(equivalentBinary.get(i)==1){
				goodArray.add(1<<i); 
				//goodArray.add((int)Math.pow(2,i));
			}
		}

		System.out.println(goodArray);
		
		List<Integer> answer= new ArrayList<>();
		for(List<Integer> list: queries){
			int l=list.get(0);
			int r=list.get(1);
			int m=list.get(2);
			int through=1;
			while (l<=r){
				through*=goodArray.get(l-1);
				l++;
			}
			answer.add(through%m);
		}

		return answer;
	}

}


class goodArray{
    public static void main(String[] args){
      List<List<Integer>> queries= new ArrayList<>(Arrays.asList(Arrays.asList(1,2,4),
      	Arrays.asList(2,2,8),Arrays.asList(1,1,4)));
      int n=6;
      Solution s= new Solution();
      System.out.println(s.goodArray(n,queries));
    }
    
}

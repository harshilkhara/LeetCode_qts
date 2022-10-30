import java.util.*;
// Asked in goldman sachs interview 
// https://leetcode.com/discuss/interview-question/1930478/football-scores-hackerrank-question
class Solution{
	public List<Integer> footballScores(List<Integer> teamA, List<Integer> teamB){
		Collections.sort(teamA);
		List<Integer> answer= new ArrayList<>();
		for (int i=0; i<teamB.size(); i++){
			int l=0;
			int r=teamA.size()-1;
			while(l<=r){
				int mid=(l+r)/2;
				if(teamA.get(mid)>teamB.get(i)){
					r=mid-1;
				} else {
					l=mid+1;
				}
			}
			answer.add(l);
		}
		return answer;
	}
}

class footballScores{
	public static void main(String[] args) {
		List<Integer> teamA= new ArrayList<>(Arrays.asList(2,10,5,4,8));
		List<Integer> teamB= new ArrayList<>(Arrays.asList(3,1,7,8));
		Solution s= new Solution();
		System.out.println(s.footballScores(teamA,teamB));
	}
}
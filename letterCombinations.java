import java.util.*;
class Solution{
	Map<Character,String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",
		'7',"pqr",'8',"stuv",'9',"wxyz");

	public void backtrack(List<String> ans, StringBuilder comb, String digits, int index){
		if(comb.length()==digits.length()){
			ans.add(comb.toString());
			return;
		}
		String lettersPossible=map.get(digits.charAt(index));
		for(char c: lettersPossible.toCharArray()){
			comb.append(c);
			backtrack(ans,comb,digits,index+1);
			comb.deleteCharAt(comb.length()-1);
		}

	}

	public List<String> letterCombinations(String digits){
		if(digits.length()==0) return new ArrayList<>();
		List<String> ans= new ArrayList<>();
		StringBuilder comb= new StringBuilder();
		backtrack(ans,comb,digits,0);
		return ans;
	}
}

class letterCombinations{
	public static void main(String[] args) {
		String digits="23";
		Solution s= new Solution();
		System.out.println(s.letterCombinations(digits));
	}
}
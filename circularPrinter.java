class Solution{
	public int circularPrinter(String s){
		int steps=0;
		String s1='A'+s;
		int delta=0;
		for (int i=0; i< s.length();i++){
			delta=Math.abs(s.charAt(i)-s1.charAt(i));
			steps+=Math.min(delta,26-delta);
		}
		return steps;

	}
}
class circularPrinter{
	public static void main(String[] args) {
		String x= "AZGB";
		Solution s = new Solution();
		System.out.println(s.circularPrinter(x));
	}
}
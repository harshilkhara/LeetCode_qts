public class majorityElement {

	public static void main(String[] args) {
		int count=0; 
		Integer candidate=null; 
		int [] nums= {1,3,1,1,1,3,3,3,3,1,1}; 
		for (int num: nums) {
			if (count==0) {
				candidate=num; 
			}
			count+= (candidate==num) ? 1 : -1 ;
			
		}
		 System.out.println(candidate);
	}

}

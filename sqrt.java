class Solution{
	public int sqrt(int n){
		int left=0;
		int right=n/2;
		while (left<=right){
			int mid= (left+right)/2;
			long num=(long)mid*mid;
			if (num<n){
				left=mid+1;
			}else if (num>n){
				right=mid-1;
			}
			else{
				return mid;
			}
		}
		return right;
	}
}

class Solution1{
	public int sqrt(int n){
		if (n < 2) return n;

		int left=sqrt(n>>2)<<1;
		int right=left+1;
		return (long)right*right>n? left:right;

	}
}

class Solution2{
	public int sqrt(int n){
		if (n<2) return n;
		
		double x0=n;
		double x1=(x0+n/x0)/2.0;
		while (Math.abs(x0-x1)>=1){
			x0=x1;
			x1=(x0+n/x0)/2.0;
		}
		return (int)x1;
	}
}

class sqrt{
	public static void main(String[] args){
		int n=529; 
		Solution s= new Solution();
		System.out.println(s.sqrt(n));
		Solution1 s1= new Solution1();
		System.out.println(s1.sqrt(n));
		Solution2 s2= new Solution2();
		System.out.println(s2.sqrt(n));
	}
}
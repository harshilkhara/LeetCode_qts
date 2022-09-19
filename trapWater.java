import java.util.*;
// Approach 1- DP (Bottom-up)
class Solution{ // TC O(n) SC O(n)
	public int trapWater(int[] height){
		if(height.length==0) return 0;
		int ans=0, size=height.length;
		int[] left_max= new int[size];
		int[] right_max=new int[size];

		left_max[0]=height[0];
		for (int i=1; i<size; i++){
			left_max[i]=Math.max(height[i],left_max[i-1]);
		}

		right_max[size-1]=height[size-1];
		for(int i=size-2; i>=0; i--){
			right_max[i]=Math.max(height[i],right_max[i+1]);
		}

		for (int i = 1; i < size - 1; i++) {
        ans += Math.min(left_max[i], right_max[i]) - height[i];
    	}

    	return ans;
	}
}

// Approach 2- Using Stacks 
class Solution1{ // TC O(n) SC O(n)
    public int trapWater(int[] height) {
        if (height.length==0) return 0;
        int ans=0,current=0;
        Stack<Integer> stack = new Stack<>();
        while(current<height.length){
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top=stack.peek();
                stack.pop();
                if(stack.isEmpty())
                    break;
                int distance=current-stack.peek()-1;
                int bounded_height=Math.min(height[current],height[stack.peek()])-height[top];
                ans+=distance*bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}

// Approach 3- Two Pointers

class Solution2{ // TC O(n) SC O(1)
    public int trapWater(int[] height) {
        if (height.length==0) return 0; 
        int left = 0, right = height.length-1; 
        int leftMax=0, rightMax=0; 
        int ans = 0; 
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]; 
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]); 
                left++; 
            } else {
                ans += Math.max(0, rightMax-height[right]); 
                right--; 
            }
        }
        return ans; 
    }
}

class trapWater{
	public static void main(String[] args) {
		int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
		Solution s= new Solution();
		System.out.println(s.trapWater(height));
		Solution1 s1= new Solution1();
		System.out.println(s1.trapWater(height));
		Solution2 s2= new Solution2();
		System.out.println(s2.trapWater(height));
	}
}
import java.util.*;
// Approach 1-Binary search
// Very similar to minEatingSpeed.java & .py
class Solution { // TC O(n log k) SC O(1)
    public double timeRequired(int[] dist, int speed){
        double time=0.0;
        for(int i=0; i<dist.length; i++){
            double t= (double) dist[i]/ (double) speed;
            time+=(i==dist.length-1) ? t: Math.ceil(t);
        }
        return time;
    }
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1, right=10_000_000+1;
        int minSpeed=-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(timeRequired(dist, mid)<=hour){
                minSpeed=mid;
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return minSpeed;
    }
}

class minSpeedOnTime{
    public static void main(String[] args) {
        int[] dist={1,3,2};
        double hour=6;
        Solution s=new Solution();
        System.out.println(s.minSpeedOnTime(dist, hour));
    }
}
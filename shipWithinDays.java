class Solution { // TC O(n log n) SC O(1)
    boolean feasible(int[] weights, int c, int days){
        int daysNeeded=1, currentLoad=0;
        for(int weight: weights){
            currentLoad+=weight;
            if(currentLoad>c){
                daysNeeded++;
                currentLoad=weight;
            }
        }
        return daysNeeded<=days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int maxLoad=0, totalLoad=0;
        for(int weight: weights){
            maxLoad=Math.max(maxLoad,weight);
            totalLoad+=weight;
        }
        
        int left=maxLoad, right=totalLoad;
        while (left<right){
            int mid=left+(right-left)/2;
            if (feasible(weights,mid,days)){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}

class shipWithinDays{
    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        Solution s= new Solution();
        System.out.println(s.shipWithinDays(weights,days));
    }
}
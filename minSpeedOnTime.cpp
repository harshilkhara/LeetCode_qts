#include <iostream>
#include <vector>

using namespace std;

// Approach 1- Binary Search
// Very similar to minEatingSpeed.java & .py
class Solution { // TC O(n log k) SC O(1)
public:
    
    double timeRequired(vector<int>& dist, int speed){
        double time=0.0;
        for(int i=0; i<dist.size(); i++){
            double t= (double) dist[i]/ (double) speed;
            time+=(i==dist.size()-1) ? t: ceil(t);
        }
        return time;
    }
    
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int left=1, right=1e7+1;
        int minSpeed=-1;
        while(left < right){
            int mid=left+(right-left)/2;
            if (timeRequired(dist, mid)<=hour){
                minSpeed=mid;
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return minSpeed;
    }
};

int main(){

    Solution s;
    vector<int> dist={1,3,2};
    double hour=6;
    cout << s.minSpeedOnTime(dist, hour) << endl;

    return 0;
}
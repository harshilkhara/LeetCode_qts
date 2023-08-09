#include <iostream>
using namespace std;
// Approach 1- Greedy + Binary Search
class Solution { // TC O(n log n) SC O(1)
public:
    int validCountPairs(vector<int>& nums, int threshold){
        int count=0, index=0;
        while(index<nums.size()-1){
            if(nums[index+1]-nums[index]<=threshold){
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

    int minimizeMax(vector<int>& nums, int p) {
        sort(nums.begin(), nums.end());
        int left=0, right=nums[nums.size()-1]-nums[0];
        while (left<right){
            int mid=left+(right-left)/2;
            if(validCountPairs(nums, mid)>=p){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
};

int main(){
    Solution s;
    vector<int> nums={10,1,2,7,1,3};
    int p=2;
    cout << s.minimizeMax(nums, p) << endl;
    return 0;
}
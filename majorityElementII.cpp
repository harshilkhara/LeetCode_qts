#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
public:
    vector<int> majorityElementII(vector<int>& nums) {
        int n=nums.size();
        int minFreq=n/3;
        unordered_map<int, int> map;
        for(int num: nums) map[num]++;

        vector<int> ans;
        for(auto it=map.begin(); it!=map.end(); it++){
            int key=it->first, value=it->second;
            if(value>minFreq){
                ans.push_back(key);
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums={1,2,3,3};
    vector<int> ans=s.majorityElementII(nums);
    for(int a: ans){
        cout << a << " " << endl;
    }
    return 0;
}
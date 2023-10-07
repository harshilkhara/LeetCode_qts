#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// Approach 1- HashMap
class Solution { // TC O(n) SC O(n)
public:
    int numIdenticalPairs(vector<int>& nums) {
        unordered_map<int, int> map;
        int ans=0;
        for(int num: nums){
            ans+=map[num];
            map[num]++;
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums={1,2,3,1,1,3};
    cout << s.numIdenticalPairs(nums) << endl;
    return 0;
}
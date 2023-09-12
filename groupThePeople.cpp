#include <iostream>
#include <vector>
using namespace std;

// Approach 1- Greedy 
class Solution { // TC O(n) SC O(n)
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ans;
        vector<int> sizeToGroup[groupSizes.size()+1];

        for(int i=0; i<groupSizes.size(); i++){
            sizeToGroup[groupSizes[i]].push_back(i);

            if((sizeToGroup[groupSizes[i]]).size()==groupSizes[i]){
                ans.push_back(sizeToGroup[groupSizes[i]]);
                sizeToGroup[groupSizes[i]].clear();
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> groupSizes={3,3,3,3,3,1,3};
    vector<vector<int>> ans=s.groupThePeople(groupSizes);
    for(int i=0; i<ans.size(); i++){
        for(int j=0; j<ans[i].size(); j++){
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

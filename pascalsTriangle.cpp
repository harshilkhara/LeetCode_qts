#include <iostream>
#include <vector>
using namespace std;

class Solution { // TC O(n^2)  SC O(1)
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        ans.push_back(vector<int>());
        ans[0].push_back(1);
        for(int i=1; i<numRows; i++){
            vector<int> rows;
            vector<int> prevRows=ans[i-1];

            rows.push_back(1);
            for(int j=1; j<i; j++){
                rows.push_back(prevRows[j-1]+prevRows[j]);
            }
            rows.push_back(1);

            ans.push_back(rows);
        }
        return ans; 
    }
};

int main(){
    Solution s;
    int numRows=5;
    vector<vector<int>> ans=s.generate(numRows);
    for(int i=0; i<ans.size(); i++){
        for(int j=0; j<ans[i].size(); j++){
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
    return 0;
}
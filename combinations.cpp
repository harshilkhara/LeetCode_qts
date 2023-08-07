#include <iostream>
using namespace std;
// Approach 1- Backtrack
class Solution {
public:
    int n, k;
    vector<vector<int>> ans;
    vector<vector<int>> combine(int n, int k) {
        this->n=n;
        this->k=k;
        vector<int> path;
        backtrack(1, path);
        return ans;
    }

    void backtrack(int start, vector<int>& path){
        if(path.size()==k){
            ans.push_back(path);
            return;
        }

        for(int i=start; i<=n; i++){
            path.push_back(i);
            backtrack(i+1, path);
            path.pop_back();
        }

    }
};

int main(){
    Solution s;
    vector<vector<int>> ans=s.combine(3, 2);
    for(int row=0; row<ans.size(); row++){
        for(int col=0; col<ans[0].size(); col++){
            cout << ans[row][col] << " ";
        }
    }
    return 0;
}
#include <iostream>
using namespace std;
// Approach 1- Balance
class Solution { // TC O(n) SC O(1)
public:
    int minAddToMakeValid(string s) {
        int ans=0, bal=0;
        for(char& c: s){
            bal+= c=='(' ? 1 : -1;
            if(bal==-1){
                ans++;
                bal++;
            }
        }
        return ans+bal;
    }
};

int main(){
    Solution s;
    cout << s.minAddToMakeValid("()(()") << endl;
    return 0;
}
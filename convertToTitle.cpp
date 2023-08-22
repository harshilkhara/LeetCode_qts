#include <iostream>
#include <string>
using namespace std;

// Approach 1- Math
class Solution { // TC O(log n) SC O(1)
public:
    string convertToTitle(int columnNumber) {
        string ans;
        while(columnNumber>0){
            columnNumber--;
            ans += (char) (columnNumber%26 + 'A');
            columnNumber/=26;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

int main(){
    Solution s;
    cout << s.convertToTitle(902) << endl;
    return 0;
}
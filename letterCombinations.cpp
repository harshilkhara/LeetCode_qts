#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    unordered_map<char, string> map={{'2',"abc"},{'3',"def"},{'4',"ghi"},
    {'5',"jkl"},{'6',"mno",}, {'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};
    
    vector<string> ans;

    vector<string> letterCombinations(string digits) {
        if (digits.size()==0) return ans;
        string path="";
        backtrack(0, path, digits);
        return ans;
        
    }

    void backtrack(int index, string path, string digits){
        if(path.size()==digits.size()){
            ans.push_back(path);
            return;
        }

        for(auto& c: map[digits[index]]){
            path+=c; 
            backtrack(index+1, path, digits);
            path.erase(path.size()-1);
        }
    }
};

int main(){
    Solution s;
    for(auto& s: s.letterCombinations("23")){
        cout << s << ", ";
    }
    cout << endl;
    return 0;

}
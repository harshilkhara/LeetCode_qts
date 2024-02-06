#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if(strs.empty()) return vector<vector<string>>();
        unordered_map<string, vector<string>> map;
        vector<vector<string>> ans;
        for(string& s: strs){
            string key=s;
            sort(key.begin(), key.end());
            if(map.find(key)==map.end()){
                map[key]=vector<string>();
            }
            map[key].push_back(s);
        }
        for(auto& pair: map){
            ans.push_back(pair.second);
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> res=s.groupAnagrams(strs);
    for(vector<string>& groups: res){
        cout << "[" ;
        for(string& word: groups){
            cout << word << ", ";
        }
        cout << "]" << endl;
    }
    return 0;
}
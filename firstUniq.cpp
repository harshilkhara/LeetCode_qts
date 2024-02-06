#include <iostream>
#include <unordered_map>

using namespace std;

class Solution{
public:
	int firstUniqueChar(string s){
		unordered_map<char, int> map;
		for(auto& c:s) map[c]++;

		for(int i=0; i<s.size(); i++){
			if(map[s[i]]==1) return i;
		}
		return -1;
	}
};

int main(){
	Solution s;
	cout << s.firstUniqueChar("leetcode") << endl;
	return 0;
}
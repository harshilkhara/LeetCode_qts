#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution{
public:
	vector<int> findErrorNums(vector<int>& nums){
		int n=nums.size();
		int dup=-1, miss=-1;
		unordered_map<int, int> map;
		for(int n: nums){
			map[n]++;
		}
		for(int i=1; i<=n; i++){
			if(map.find(nums[i])!=map.end()){
				if(map[i]==2){
					dup=i;
				}
			} else {
				miss=i;
			}
		}
		return {dup, miss};
	}
};

int main(){
	Solution s;
	vector<int> nums={1,2,2,4};
	vector<int> ans=s.findErrorNums(nums);
	for(int n: ans){
		cout << n << " ";
	}
	cout << endl;
	return 0;
}
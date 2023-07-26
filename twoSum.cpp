#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution{
public:
	vector<int> twoSum(vector<int>& nums, int target){
		unordered_map<int, int> map;
		for(int i=0; i<nums.size(); i++){
			int complement=target-nums[i];
			if(map.count(complement)){
				return {i, map[complement]};
			}
			map[nums[i]]=i;
		}
		return {-1,-1};
	}
};

int main(){
	Solution s;
	vector<int> nums={1,2,3,4,5};
	int target=9;
	vector<int> result= s.twoSum(nums, target);
	for(const auto& num: result){
		cout << num << " ";
	}
	return 0;
}
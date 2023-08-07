#include <iostream>
#include <vector>
using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode():val(0), left(nullptr), right(nullptr){}

    TreeNode(int val): val(val), left(nullptr), right(nullptr){}

    TreeNode(int val, TreeNode* left, TreeNode* right): val(val), left(left), right(right){}

};

// Approach 1- Top Down DP with Memoization
class Solution {
public:
    unordered_map<int, vector<TreeNode*>> memo;
    
    vector<TreeNode*> allPossibleFBT(int n) {
        if(n%2==0) return {};
        
        if(n==1) return {new TreeNode()};
        
        if(memo.find(n)!=memo.end()){
            return memo[n];
        }
        
        vector<TreeNode*> res;
        for(int i=1; i<n; i+=2){
            vector<TreeNode*> left=allPossibleFBT(i);
            vector<TreeNode*> right=allPossibleFBT(n-i-1);
            
            for(auto& l: left){
                for(auto& r: right){
                    TreeNode* root=new TreeNode(0, l, r);
                    res.push_back(root);
                }
            }
        }
        memo[n]=res;
        return res;
        
    }

    void preorder(TreeNode *root){
        if(root==nullptr) return;

        cout << root->val << " ";
        preorder(root->left);
        preorder(root->right);
    }
};

int main(){
    Solution s;
    int n=7;
    vector<TreeNode*> result=s.allPossibleFBT(7);
    for(auto& root: result){
        s.preorder(root);
    }
    return 0;
}
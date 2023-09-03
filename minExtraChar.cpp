#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

// Approach 1- Top Down DP with substring method
class Solution{ // TC O(n^3) SC O(n^2)
public:
    int minExtraChar(string s, vector<string> dictionary) {
        int n = s.length();
        unordered_set<string> dictionarySet(dictionary.begin(), dictionary.end());
        unordered_map<int, int> memo;

        function<int(int)> dp = [&](int start) {
            if (start == n) {
                return 0;
            }
            if (memo.count(start)) {
                return memo[start];
            }
            // To count this character as a left over character 
            // move to index 'start + 1'
            int ans = dp(start + 1) + 1;
            for (int end = start; end < n; end++) {
                auto curr = s.substr(start, end - start + 1);
                if (dictionarySet.count(curr)) {
                    ans = min(ans, dp(end + 1));
                }
            }

            return memo[start] = ans;
        };

        return dp(0);
    }
};

// Approach 2- Bottom Up DP with substring method
class Solution1{ // TC O(n^3) SC O(n^2)
public:
    int minExtraChar(string s, vector<string> dictionary) {
        int n = s.length();
        unordered_set<string> dictionarySet(dictionary.begin(), dictionary.end());
        vector<int> dp(n + 1, 0);

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                auto curr = s.substr(start, end - start + 1);
                if (dictionarySet.count(curr)) {
                    dp[start] = min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
};

// Approach 3- Top Down DP with Trie
class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool isWord;
};

class Solution2{ // TC O(n^2) SC O(n^2)
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        int n = s.length();
        auto root = buildTrie(dictionary);
        unordered_map<int, int> memo;

        function<int(int)> dp = [&](int start) {
            if (start == n) {
                return 0;
            }
            if (memo.count(start)) {
                return memo[start];
            }
            // To count this character as a left over character 
            // move to index 'start + 1'
            int ans = dp(start + 1) + 1;
            TrieNode* node = root;
            for (int end = start; end < n; end++) {
                char c = s[end];
                if (node->children.find(c) == node->children.end()) {
                    break;
                }
                node = node->children[c];
                if (node->isWord) {
                    ans = min(ans, dp(end + 1));
                }
            }

            return memo[start] = ans;
        };

        return dp(0);
    }

    TrieNode* buildTrie(vector<string>& dictionary) {
        auto root = new TrieNode();
        for (auto& word : dictionary) {
            auto node = root;
            for (auto& c : word) {
                if (node->children.find(c) == node->children.end()) {
                    node->children[c] = new TrieNode();
                }
                node = node->children[c];
            }
            node->isWord = true;
        }
        return root;
    }
};

// Approach 4- Bottom Up DP with Trie
class Solution3{ // TC O(n^2) SC O(n^2)
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        int n=s.size();
        vector<int> dp(n+1, 0);
        TrieNode* root= buildTrie(dictionary);
        for(int start=n-1; start>=0; start--){
            dp[start]=dp[start+1]+1;
            TrieNode* node=root;
            for(int end=start; end<n; end++){
                if(node->children.find(s[end])==node->children.end()) break;
                node=node->children[s[end]];
                if(node->isWord){
                    dp[start]=min(dp[start], dp[end+1]);
                }
            }
        }
        return dp[0];
    }

    TrieNode* buildTrie(vector<string>& dictionary){
        TrieNode* root=new TrieNode();
        for(string& word: dictionary){
            TrieNode* node= root;
            for(auto& c: word){
                if(node->children.find(c)==node->children.end()){
                    node->children[c]=new TrieNode();
                }
                node=node->children[c];
            }
            node->isWord=true;
        }
        return root;
    }
};

int main(){
    Solution s;
    Solution s1;
    Solution s2;
    Solution s3;
    string x="sayhelloworld";
    vector<string> dictionary = {"hello","world"};
    cout << s.minExtraChar(x, dictionary) << endl;
    cout << s1.minExtraChar(x, dictionary) << endl;
    cout << s2.minExtraChar(x, dictionary) << endl;
    cout << s3.minExtraChar(x, dictionary) << endl;
    return 0;
}
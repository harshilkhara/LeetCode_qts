#include <iostream>
#include <queue>
using namespace std;

// Approach 1- 1 Queue
class Solution { // TC Push- O(n), Pop- O(1)
public:

    queue<int> q1;
    Solution() {
        
    }
    
    void push(int x) {
        q1.push(x);
        int size = q1.size();
        while(size>1){
            q1.push(q1.front());
            q1.pop();
            size--;
        }f
    }
    
    int pop() {
        int ans = q1.front();
        q1.pop();
        return ans;
    }
    
    int top() {
        return q1.front();
    }
    
    bool empty() {
        return q1.empty();
    }
};

int main(){

    Solution* s = new Solution();
    s->push(2);
    s->push(3);
    cout << s->pop();
    s->push(4);
    cout << s->top();
    cout << s->pop();
    cout << s->pop();
    cout << s->empty();

    return 0;
}
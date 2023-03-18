import java.util.*;
// Approach 1- Two Stacks
class Solution { // TC O(1), O(min(m,n)) SC O(l*n)
    private Stack<String> history, future;
    private String current;
    
    public Solution(String homepage) {
        history = new Stack<String>();
        future = new Stack<String>();
        // 'homepage' is the first visited URL.
        current = homepage;
    }
    
    public void visit(String url) {
        // Push 'current' in 'history' stack and mark 'url' as 'current'.
        history.push(current);
        current = url;
        // We need to delete all entries from 'future' stack.
        future = new Stack<String>();
    }
    
    public String back(int steps) {
        // Pop elements from 'history' stack, and push elements in 'future' stack.
        while(steps > 0 && !history.empty()) {
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        // Pop elements from 'future' stack, and push elements in 'history' stack.
        while(steps > 0 && !future.empty()) {
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}

// Approach 2- Doubly linkedList
class DLLNode {
    public String data;
    public DLLNode prev, next;

    DLLNode(String url) {
        data = url;
        prev = null;
        next = null;
    }
}

class Solution1{ // TC O(1), O(min(m,n)) SC O(l*n)
    private DLLNode linkedListHead;
    private DLLNode current;

    public Solution1(String homepage) {
        // 'homepage' is the first visited URL.
        linkedListHead = new DLLNode(homepage);
        current = linkedListHead;
    }
    
    public void visit(String url) {
        // Insert new node 'url' in the right of current node.
        DLLNode newNode = new DLLNode(url);
        current.next = newNode;
        newNode.prev = current;
        // Make this new node as current node now.
        current = newNode;
    }
    
    public String back(int steps) {
        // Move 'current' pointer in left direction.
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.data;
    }
    
    public String forward(int steps) {
        // Move 'current' pointer in right direction.
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.data;
    }
}

// Approach 3- Dynamic List or array
class Solution2{ // TC O(1), O(1)  SC O(l*n)
    ArrayList<String> visitedURLs;
    int currURL, lastURL;

    public Solution2(String homepage) {
        // 'homepage' is the first visited URL.
        visitedURLs = new ArrayList<String>(Arrays.asList(homepage));
        currURL = 0; 
        lastURL = 0;
    }
    
    public void visit(String url) {
        currURL += 1;
        if (visitedURLs.size() > currURL) {
            // We have enough space in our array to overwrite an old 'url' entry with new one.
            visitedURLs.set(currURL, url);
        } else {
            // We have to insert a new 'url' entry at the end.
            visitedURLs.add(url);
        }
        // This 'url' will be last URL if we try to go forward.
        lastURL = currURL;
    }
    
    public String back(int steps) {
        // Move 'currURL' pointer in left direction.
        currURL = Math.max(0, currURL - steps);
        return visitedURLs.get(currURL);
    }
    
    public String forward(int steps) {
        // Move 'currURL' pointer in right direction.
        currURL = Math.min(lastURL, currURL + steps);
        return visitedURLs.get(currURL);
    }
}

class browserHistory{
    public static void main(String[] args) {
        Solution bh=new Solution("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linkedin.com");
        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }
}


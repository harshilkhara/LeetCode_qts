// Approach 1- Two Stacks
var BrowserHistory = function(homepage) {
    this.history = [], this.future = [];
    // 'homepage' is the first visited URL.
    this.current = homepage;
};

BrowserHistory.prototype.visit = function(url) {
    // Push 'current' in 'history' stack and mark 'url' as 'current'.
    this.history.push(this.current);
    this.current = url;
    // We need to delete all entries from 'future' stack.
    this.future = [];
};

BrowserHistory.prototype.back = function(steps) {
    // Pop elements from 'history' stack, and push elements in 'future' stack.
    while(steps > 0 && this.history.length != 0) {
        this.future.push(this.current);
        this.current = this.history.pop();
        steps--;
    }
    return this.current;
};

BrowserHistory.prototype.forward = function(steps) {
    // Pop elements from 'future' stack, and push elements in 'history' stack.
    while(steps > 0 && this.future.length != 0) {
        this.history.push(this.current);
        this.current = this.future.pop();
        steps--;
    }
    return this.current;
};

// Aprpoach 2- Doubly linkedList
class DLLNode {
    constructor(url) {
        this.data = url;
        this.prev = null;
        this.next = null;
    }
};

var BrowserHistory = function(homepage) {
    // 'homepage' is the first visited URL.
    this.linkedListHead = new DLLNode(homepage);
    this.current = this.linkedListHead;
};

BrowserHistory.prototype.visit = function(url) {
    // Insert new node 'url' in the right of current node.
    let newNode = new DLLNode(url);
    this.current.next = newNode;
    newNode.prev = this.current;
    // Make this new node as current node now.
    this.current = newNode;
};

BrowserHistory.prototype.back = function(steps) {
    // Move 'current' pointer in left direction.
    while (steps > 0 && this.current.prev != null) {
        this.current = this.current.prev;
        steps--;
    }
    return this.current.data;
};

BrowserHistory.prototype.forward = function(steps) {
    // Move 'current' pointer in right direction.
    while (steps > 0 && this.current.next != null) {
        this.current = this.current.next;
        steps--;
    }
    return this.current.data;
};

var BrowserHistory = function(homepage) {
    // 'homepage' is the first visited URL.
    this.visitedURLs = [homepage]
    this.currURL = 0; 
    this.lastURL = 0;
};

BrowserHistory.prototype.visit = function(url) {
    this.currURL += 1;
    if (this.visitedURLs.length > this.currURL) {
        // We have enough space in our array to overwrite an old 'url' entry with new one.
        this.visitedURLs[this.currURL] = url;
    } else {
        // We have to insert a new 'url' entry at the end.
        this.visitedURLs.push(url);
    }
    // This 'url' will be last URL if we try to go forward.
    this.lastURL = this.currURL;
};

BrowserHistory.prototype.back = function(steps) {
    // Move 'currURL' pointer in left direction.
    this.currURL = Math.max(0, this.currURL - steps);
    return this.visitedURLs[this.currURL];
};

BrowserHistory.prototype.forward = function(steps) {
    // Move 'currURL' pointer in right direction.
    this.currURL = Math.min(this.lastURL, this.currURL + steps);
    return this.visitedURLs[this.currURL];
};
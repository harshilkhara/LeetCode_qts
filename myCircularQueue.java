class Solution{ // TC O(1) SC O(N)
  private int[] queue;
  private int headIndex;
  private int count;
  private int capacity;

  /** Initialize your data structure here. Set the size of the queue to be k. */
  public Solution(int k) {
    this.capacity = k;
    this.queue = new int[k];
    this.headIndex = 0;
    this.count = 0;
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (this.count == this.capacity)
      return false;
    this.queue[(this.headIndex + this.count) % this.capacity] = value;
    this.count += 1;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (this.count == 0)
      return false;
    this.headIndex = (this.headIndex + 1) % this.capacity;
    this.count -= 1;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    if (this.count == 0)
      return -1;
    return this.queue[this.headIndex];
  }

  /** Get the last item from the queue. */
  public int rear() {
    if (this.count == 0)
      return -1;
    int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
    return this.queue[tailIndex];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return (this.count == 0);
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return (this.count == this.capacity);
  }
}

class myCircularQueue{
  public static void main(String[] args) {
     Solution queue= new Solution(3);
    System.out.println(queue.enQueue(1)); // return True
    System.out.println(queue.enQueue(2)); // return True
    System.out.println(queue.enQueue(3)); // return True
    System.out.println(queue.enQueue(4)); // return False
    System.out.println(queue.rear());     // return 3
    System.out.println(queue.isFull());   // return True
    System.out.println(queue.deQueue());  // return True
    System.out.println(queue.enQueue(4)); // return True
    System.out.println(queue.rear());     // return 4

  }
}
/**
 * Design a stack with a push, pop, and max function which returns the max value in the stack, all
 * of which are run in O(1) time.
 */

class MaxStackTest {

  int items[];
  int capacity;
  int size;
  int maxItemSoFar[];


  public MaxStackTest(int capcacity) {
    this.capacity = capcacity;
    size = 0;
    items = new int[this.capacity];
  }


  //push item to stack
  public void push(int item) {
    if (size == capacity) {
      throw new StackFullException("Stack is full");
    }

    items[size] = item;

    //initial condition
    if (size == 0) {
      maxItemSoFar[size] = item;
    }

    //does this item greater than previous item ?
    if (item > maxItemSoFar[size - 1]) {
      maxItemSoFar[size] = item;  //new max so far
    } else {
      maxItemSoFar[size] = maxItemSoFar[size - 1]; //update max with previous max
    }

    size++;
  }


  //remove and return last element from stack
  public int pop() {
    if (size < 0) {
      throw new StackEmptyException("Stack Empty Exception");
    }

    int lastItem = items[size];
    size--;
    return lastItem;
  }


  //return max value from stack
  public int max() {
    if (size <= 0) {
      throw new StackEmptyException("Stack Empty");
    }

    return items[size];
  }

}


//MaxStack:  Linked List implementation from bytebybyte
class MasStack {


  class Node {

    int value;
    Node next;
    Node oldMax;

    public Node(int value) {
      this.value = value;
    }


    Node stack;
    Node max;


    public void push(int value) {
      Node n = new Node(value);

      if (stack == null) {
        stack = n;
      } else {
        n.next = stack;
        stack = n;
      }

      if (max == null || n.value > max.value) {
        n.oldMax = max;
        max = n;
      }
    }


    public int pop() {
      if (stack == null) {
        throw new NullPointerException("Stack is empty");
      }

      Node last = stack;
      stack = stack.next;

      if (last.oldMax != null) {
        max = last.oldMax;
      }
      return last.value;
    }


    public int max() {
      if (stack == null) {
        throw new NullPointerException("Stack is Empty");
      }
      return max.value;
    }


  }


}



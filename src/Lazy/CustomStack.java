package Lazy;

import java.util.Stack;

/*
Design a stack which supports the following operations.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 */
public class CustomStack {

    private int [] inc;
    private Stack<Integer> stack;

    public CustomStack(int maxSize) {
        inc = new int[maxSize];
        stack = new Stack<>();

    }

    public void push(int x) {
        if(stack.size() < inc.length){
            stack.add(x);
        }
        return;
    }

    /*
    each time we pop, we add value + value need to increment,
    then copy value to increment to last index, so second
    last element will increment both
     */
    public int pop() {
        int index = stack.size() -1;
        if (index < 0){
            return -1;
        }
        if(index > 0){
            inc[index - 1] += inc[index];
        }
        int n = stack.pop() + inc[index];
        inc[index] = 0;
        return n;

    }

    /*
    only store value need to increment at last index
     */
    public void increment(int k, int val) {
        int index = Math.min(k, stack.size()) - 1;
        if(index >= 0){
            inc[index] += val;
        }
    }
}

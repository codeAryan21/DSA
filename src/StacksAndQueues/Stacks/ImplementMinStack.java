package StacksAndQueues.Stacks;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class ImplementMinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(12);
        stack.push(15);
        stack.push(10);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.push(10);
        System.out.println(stack.top());
    }
}

class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
            stack.push(val);
        }else {
            if(val > min){
                // in this case we doesn't do anything because it is already greater than min value
                stack.push(val);
            }else {
                stack.push(2*val - min);
                min = val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int x = stack.peek();
        stack.pop();
        // if x < min   i.e.  it is the modified value
        if(x < min){
            min = 2 * min - x;
        }
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        int x = stack.peek();
        // if the element stored is greater i.e. value was not modified so we return the stored value else return the min;
        if(min < x) return x;
        return min;
    }

    public int getMin() {
        return min;
    }
}
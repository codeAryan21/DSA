package StacksAndQueues.Stacks;

public class ImplementStackByArr {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println(stack.top());

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        stack.pop();
        stack.pop();

        System.out.println(stack.top());
        stack.push(70);
        System.out.println(stack.top());
//        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.size());
    }
}

class Stack{
    int size = 10;
    int top = -1;
    int []stack = new int[size];

    protected void push(int value){
        if(top == stack.length-1) {
            System.out.println("Stack is full");
        }
        top = top + 1; // here top moves to 0th index
        stack[top] = value; // and we put the value in the arr[0]
    }

    protected int top(){
        if (top == -1){
            System.out.println("Stack is empty");
        }
        return stack[top];
    }

    protected void pop(){
        if (top == -1){
            System.out.println("Stack is empty");
        }
//        int x = stack[top];
        top = top - 1;
//        return x;
    }

    protected int size(){
        return top + 1;
    }
}
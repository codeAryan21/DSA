package StacksAndQueues.Stacks;

public class ImplementStackByLL {
    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.displayStack();

        System.out.println("Element popped from the stack is: " + stack.pop());
        System.out.println("Element popped from the stack is: " + stack.pop());

        System.out.println("Size of the stack is: " + stack.size());

        stack.push(70);
        System.out.println("Size of the stack is: " + stack.size());
        System.out.println("Element popped from the stack is: " + stack.pop());
        System.out.println("The element is at top of the stack is: " + stack.top());

        stack.displayStack();
    }
}

class StackLL{
    private class Node{
        int val;
        Node next;
        Node(int data){
            this.val = data;
        }
    }

    Node top = null;
    int size = 0;

    public void push(int value){
        Node temp = new Node(value);
        temp.next = top;
        top = temp;
        System.out.println("Element pushed into the stack is: " + temp.val);
        size++;
    }

    public int pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        int poppedElement = top.val;
        top = top.next;
        size--;
        return poppedElement;
    }

    public int size(){
        return size;
    }

    public int top(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.val;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void displayStack(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

package StacksAndQueues.Queues;

public class ImplementQueueByArr {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}

class Queue{
    int size = 10;
    int []arr = new int[size];
    int currSize = 0;
    int start = -1;
    int end = -1;

    public void push(int value){
        if(currSize == size) {
            System.out.println("Queue is full");
        }
        // If a queue is of size 0.
        if(currSize == 0){
            start = 0;
            end = 0;
        }else {
            end = (end + 1) % size;
        }
        arr[end] = value;
        System.out.println("The element pushed is " + value);
        currSize += 1;
    }

    public int pop(){
        if (currSize == 0){
            System.out.println("Queue is empty");
        }
        int poppedElement = arr[start];
        if(currSize == 1){
            start = end = -1;
        }else {
            start = (start + 1) % size;
        }
        currSize--;
        return poppedElement;
    }

    public int top(){
        if(currSize == 0){
            System.out.println("Queue is empty");
        }
        return arr[start];
    }

    public int size(){
        return currSize;
    }
}

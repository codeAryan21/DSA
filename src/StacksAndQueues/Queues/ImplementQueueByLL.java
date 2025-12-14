package StacksAndQueues.Queues;

public class ImplementQueueByLL {
    public static void main(String[] args) {
        QueueLL queue = new QueueLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.displayQueue();
        System.out.println("Size of the queue is: " + queue.size());

        queue.dequeue();
        queue.dequeue();

        queue.displayQueue();
        System.out.println("Size of the queue is: " + queue.size());
        System.out.println("Top element of the queue is: " + queue.top());

        queue.enqueue(70);
        System.out.println("Size of the queue is: " + queue.size());
        queue.displayQueue();
    }
}

class QueueLL{
    private class Node{
        int val;
        Node next;
        Node(int data){
            this.val = data;
        }
    }

    Node front = null; // start
    Node rear = null; // end
    int size = 0;

    public void enqueue(int value){
        Node temp = new Node(value);
        if(front == null){
            front = rear = temp;
        }else {
            rear.next = temp;
            rear = temp;
        }
        System.out.println(value + " inserted into Queue");
        size++;
    }

    public void dequeue(){
        if(front == null){
            System.out.println("Queue is empty");
        }else {
            System.out.println(front.val + " removed from Queue");
            front = front.next;
            size--;
        }
    }

    public int top(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.val;
    }

    public int size(){
        return size;
    }

    public void displayQueue(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

package StacksAndQueues.Queues;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
public class ImplementQueueByStack {
    public static void main(String[] args) {
        Q queue = new Q();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();
        System.out.println("Size of the queue is: " + queue.size());
        System.out.println("Top element of the queue is: " + queue.top());

        queue.dequeue();
        queue.dequeue();

        queue.display();
        System.out.println("Size of the queue is: " + queue.size());
        System.out.println("Top element of the queue is: " + queue.top());

        queue.enqueue(70);
        System.out.println("Size of the queue is: " + queue.size());
        queue.display();
    }
}

class Q{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value){
        // 1: get everything out from s1 to s2
        while(s1.size() != 0){
            s2.push(s1.peek());
            s1.pop();
        }

        // 2: put the value x into s1
        s1.push(value);

        // 3: put everything back to s2
        while(s2.size() != 0){
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public void dequeue(){
        s1.pop();
    }

    public int top(){
        return s1.peek();
    }

    /*
    public void enqueue(int value){
        s1.push(value);
    }

    public void dequeue(){
        if(!s2.isEmpty()){
            s2.pop();
        }else {
            while(s1.size() != 0){
                s2.push(s1.peek());
                s1.pop();
            }
            s2.pop();
        }
    }

    public int top(){
        if(!s2.isEmpty()){
            return s2.peek();
        }else {
            while(s1.size() != 0){
                s2.push(s1.peek());
                s1.pop();
            }
            return s2.peek();
        }
    }
     */

    public int size(){
        return s1.size();
    }

    public void display(){
        for (int i=s1.size()-1;i>=0;i--){
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }

    /*
    public void display(){
        for (int i=0;i<s1.size();i++){
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }
     */
}

/*
i-)  s1 --> s2
ii-)  x --> s1
iii-)  s2 --> s1
*/

/*
push(x){
   x --> s1
}

pop(){
   if(s2 != empty)
      s2.pop()
   else
       s1 --> s2
       s2.pop()
}

top(){
   if(s2 != empty)
      s2.top()
   else
       s1 --> s2
       s2.top()
}
*/
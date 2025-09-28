package LinkedList.LL;

public class LL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // head of the list
    private static Node head;

    // insert at the beginning
    static void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    // insert at the end
     static void insertLast(int value){
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    // insert at kth position
    static void insertAtKth(int k,int value){
        Node node = new Node(value);
        if (head == null) {
            if (k == 1){
                head = node;
            }else {
                System.out.println("Invalid position");
            }
            return;
        }

        if (k == 1){
            node.next = head;
            head = node;
            return;
        }
        Node temp = head;
        int cntr = 0;
        while (temp != null){
            cntr++;
            if (cntr == k-1){
               node.next = temp.next;
               temp.next = node;
               return;
            }
            temp = temp.next;
        }
    }

    // insert element before the value x
    static void insertBeforeValue(int x,int value){
          Node node = new Node(value);
          if (head == null){
              return;
          }
          if (head.data == x){
              node.next = head;
              head = node;
              return;
          }
          Node temp = head;
          while (temp.next != null){
              if (temp.next.data == x){
                  node.next = temp.next;
                  temp.next = node;
                  return;
              }
              temp = temp.next;
          }
    }


    // Delete first node
    static void deleteFirst(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete last node
    static void deleteLast(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete Kth node
    static void deleteKth(int k){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (k == 1){
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;
        int cntr = 0;
        while (temp != null){
            cntr++;
            if (cntr == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Delete element by value
    static void deleteByValue(int value){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (head.data == value){
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null){
            if (temp.data == value){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }


    // display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        LL list = new LL();
        insertFirst(10);
        insertFirst(20);
        insertFirst(30);
        insertFirst(40);
        insertFirst(50);

        insertLast(9);
        insertLast(8);
        
        list.display();
    }
}

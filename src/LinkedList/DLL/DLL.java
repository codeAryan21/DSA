package LinkedList.DLL;

public class DLL {
    private static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    // head of the list
    private static Node head;

    // insert at beginning
    static void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
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
        node.prev = temp;
        node.next = null;
    }

    // insert at kth position
    static void insertAtKth(int k,int value){
        Node node = new Node(value);
        if (head == null){
            if (k == 1){
                head = node;
            }else {
                System.out.println("Invalid position");
            }
            return;
        }
        if (k == 1){
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            if (count == k-1){
                node.prev = temp;
                node.next = temp.next;
                temp.next = node;
                if (node.next != null) {
                    node.next.prev = node;
                }
                break;
            }
            temp = temp.next;
        }
    }

    // insert before the given node
    static void insertBeforeNode(Node node,int value){
        Node temp = new Node(value);
        Node a = node.prev;
        temp.next = node;
        temp.prev = a;
        a.next = temp;
        node.prev = temp;
    }

    // Delete first node
    static void deleteFirst(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // only one node
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // Delete last node
    static void deleteLast(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // only one node
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
    }

    // Delete Kth node
    static void deleteKth(int k){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // only one node
            head = null;
            return;
        }
        if (k == 1){
            head = head.next;
            head.prev = null;
            return;
        }
        Node temp = head;
        int cntr = 0;
        while (temp != null){
            cntr++;
            if (cntr == k){
                Node a = temp.prev;
                Node b = temp.next;
                a.next = b;
                if (b != null) {
                    b.prev = a;
                }
                break;
            }
            temp = temp.next;
        }
    }

    // Delete the given node
    static void deleteNode(Node node){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (node == head){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
            return;
        }
       Node a = node.prev;
       Node b = node.next;
       a.next = b;
       if (b != null){
           b.prev = a;
       }
    }

    // reverse DLL
    static void reverse(){
        if (head == null || head.next == null){
            return;
        }
        Node temp = head;
        Node last  = null;
        while (temp != null){
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            temp = temp.prev;
        }
        head = last.prev;
    }

    // display the list
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        DLL list = new DLL();
        insertFirst(50);
        insertFirst(40);
        insertFirst(30);
        insertFirst(20);
        insertFirst(10);

        list.display();

        reverse();
        list.display();

    }
}

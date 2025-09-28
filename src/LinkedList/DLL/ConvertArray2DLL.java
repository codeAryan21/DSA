package LinkedList.DLL;

public class ConvertArray2DLL {
    private static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        Node(int data,Node prev,Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    static Node convertArr2DLL(int []arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i],prev,null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void display(Node head){
        while (head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        int []arr = {12,23,34,45,56,67,78,89};
        Node head = convertArr2DLL(arr);
        display(head);
    }
}

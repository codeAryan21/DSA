package LinkedList.LL;

public class ConvertArray2LL {
    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int []arr = {1,34,2,65,21,0,87,32,6,11};
        Node head = convertArr2LL(arr);
        System.out.println(head.data);

        traverse(head);

        int length = lengthOfLL(head);
        System.out.println("Length of LL is: " + length);

        System.out.println(checkIfPresent(head,5));
    }

    static Node convertArr2LL(int []arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    // traverse a LL
    static void traverse(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Length of LL
    static int lengthOfLL(Node head){
        Node temp = head;
        int length = 0;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    // check if element is present or not
    static boolean checkIfPresent(Node head,int val){
        Node temp = head;
        while (temp != null){
            if (temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }
}
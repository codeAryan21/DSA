package BitManipulation.LearnBit;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 12;
        int b = 11;
        System.out.println("Before swapping a = " + a + " ,b = " + b);
        swap(a,b);
    }

    /*
    static void swap(int a,int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping a = " + a + " ,b = " + b);
    }
     */

    // By XOR operator
    static void swap(int a,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping a = " + a + " ,b = " + b);
    }
}

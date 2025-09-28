package Recursion.Basic;

public class Basic {
    public static void main(String[] args) {
        print1ToN(1,10);
        System.out.println();

        printNTo1(10,1);
        System.out.println();

        print1(5);
        System.out.println();

        print2(5);
        System.out.println();

        int n = 5;
        System.out.println("The sum of first " + n + " number is: " + sum(n));
        System.out.println("The factorial of " + n + " is: " + factorial(n));
    }

    static void print1ToN(int i,int n){
        if(i > n) return;
        System.out.print(i + " ");
        print1ToN(i+1,n);
    }

    static void printNTo1(int n,int i){
        if (n < i) return;
        System.out.print(n + " ");
        printNTo1(n-1,i);
    }

    static void print1(int n){
        if(n < 1) return;
        print1(n - 1);
        System.out.print(n + " ");
    }

    static void print2(int n){
        if(n < 1) return;
        System.out.print(n + " ");
        print2(n-1);
    }

    static int sum(int n){
        if(n == 0) return 0;
        return n + sum(n-1);
    }

    static int factorial(int n){
        if(n < 2) return 1;
        return n * factorial(n-1);
    }
}

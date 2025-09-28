package Math.Advance;

import java.util.*;

public class PrintPrimeFactors {
    public static void main(String[] args) {
        int n = 780;
        /*
        ArrayList<Integer> ans = findPrimeFactors(n);
        System.out.print("Prime factors of " + n + " is: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
         */


        ArrayList<Integer> ans1 = primeFactor(n);
        System.out.print("Prime factors of " + n + " is: ");
        for (int i = 0; i < ans1.size(); i++) {
            System.out.print(ans1.get(i) + " ");
        }
    }

    static ArrayList<Integer> primeFactor(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0){
                list.add(i);
                while (n % i == 0){
                    n = n / i;
                }
            }
        }
        if(n != 1) list.add(n);
        return list;
    }
/*
    static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for (int i = 3; i*i <= n; i=i+2) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> findPrimeFactors(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            if(n % i == 0){
                if(isPrime(i)) list.add(i);
                if(n/i != i){
                    if(isPrime(n/i))  list.add(n/i);
                }
            }
        }
        return list;
    }

 */
}

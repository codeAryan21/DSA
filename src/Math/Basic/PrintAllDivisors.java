package Math.Basic;

import java.util.*;

public class PrintAllDivisors {
    public static void main(String[] args) {
        int n = 36;
        printDivisor(n);

        ArrayList<Integer> ans = divisor(n);
        Collections.sort(ans);
        System.out.print("\nDivisors of " + n + " are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static void printDivisor(int n){
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }

    static ArrayList<Integer> divisor(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                list.add(i);
                if(n/i != i){
                    list.add(n/i);
                }
            }
        }
        return list;
    }
}

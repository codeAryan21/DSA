package Hashing;

import java.util.*;

public class Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        // precompute
        int []hash = new int[13];
        for(int i=0;i<n;i++){
            hash[arr[i]] += 1;
        }

        System.out.print("Enter the value of q: ");
        int q = sc.nextInt();
        while(q-- != 0){
            int num = sc.nextInt();
            // fetch
            System.out.println(hash[num]);
        }
    }
}

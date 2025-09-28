package Hashing;

import java.util.*;

public class HashChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // precompute
        int []hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i) - 'a'] += 1;
        }
        
        int q = sc.nextInt();
        while(q-- != 0){
            char c = sc.next().charAt(0);
            // fetch
            System.out.println(hash[c - 'a']);
        }
    }
}

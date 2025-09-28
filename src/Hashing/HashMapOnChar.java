package Hashing;

import java.util.*;

public class HashMapOnChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // precompute
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int freq = 0;
            if(map.containsKey(key)){
                freq = map.get(key);
            }
            freq++;
            map.put(key,freq);
        }

        // Iterate over the map
        /*
        for (Map.Entry<Character, Integer> it : map.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
         */

        int q = sc.nextInt();
        while(q-- != 0){
            char c = sc.next().charAt(0);
            if (map.containsKey(c)){
                System.out.println(map.get(c));
            }else {
                System.out.println(0);
            }
        }
    }
}

package Hashing;

import java.util.*;

public class HashMapOnNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // precompute
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if(map.containsKey(key)){
                freq = map.get(key);  // fetching from the map
            }
            freq++;
            map.put(key,freq); // inserting into the map
        }

        // Iterate over the map
        /*
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
         */

        int q = sc.nextInt();
        while (q-- != 0){
            int num = sc.nextInt();
            // fetch
            if(map.containsKey(num)) {
                System.out.println(map.get(num));
            } else {
                System.out.println(0);
            }
        }
    }
}

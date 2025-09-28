package Array.Hard;

import java.util.*;

public class SubArraysWithXORk {
    public static void main(String[] args) {
        int []arr = {4,2,2,6,4};
        System.out.print("The number of subArrays with XOR k is: " + subArraysWithXORk(arr,6));
    }

    static int subArraysWithXORk(int []arr,int k){
        int count = 0;
        int xor = 0; // maintains the prefix XOR from index 0 to i
        Map<Integer,Integer> map = new HashMap<>();
        map.put(xor,1); // setting the value of 0.

        for (int i = 0; i < arr.length; i++) {
            // prefix XOR till index i
            xor = xor ^ arr[i];
            //By formula: x = xr^k
            int x = xor ^ k;
            // add the occurrence of xr^k to the count
            if (map.containsKey(x)){
                count += map.get(x); // this is for counting the no. of subArrays
            }

            // Insert the prefix xor till index i into the map
            if (map.containsKey(xor)){
                map.put(xor, map.get(xor)+1); // this is for increasing the number of count of a element in the map if it already occurs.f
            }else {
                map.put(xor,1);
            }
        }
        return count;
    }
}

/*
x ^ k = XR
take XOR K on the both side
(x ^ k) ^ k = XR ^ k
[x = XR ^ k] --> formula
 */
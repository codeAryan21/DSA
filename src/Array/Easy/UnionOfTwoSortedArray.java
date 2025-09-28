package Array.Easy;

import java.util.*;

// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int []arr1 = {1,2,3,3,5,8,9,9,12};
        int []arr2 = {3,4,5,5,6,7,7,8,10,11};
        ArrayList<Integer> result = findUnion(arr1, arr2);
        System.out.print("Union of arr1 and arr2 is : ");
        for (int value: result) {
            System.out.print(value + " ");
        }
    }

    static ArrayList<Integer> findUnion(int []arr1,int []arr2){
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0; // It's a pointer pointing to the first element of arr1
        int j = 0; // It's a pointer pointing to the first element of arr2

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                // the union is empty or the element at which i is currently at not equal to its previous element
                // consider adding it to the union only if it's not already the last added element.
                if(union.size() == 0 || union.get(union.size()-1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }else {
                if(union.size() == 0 || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // If any element left in arr1
        while(i < arr1.length){
            if(union.size() == 0 || union.get(union.size()-1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }

        // If any element left in arr2
        while (j < arr2.length){
            if(union.size() == 0 || union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }


    /* static ArrayList<Integer> findUnion(int []arr1,int []arr2){
        HashSet <Integer> set = new HashSet<>();
        ArrayList < Integer > union = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        for(int total : set){
            union.add(total);
        }

          // this is the alternate method using foreach loop
//        for (int value : arr1) {
//            set.add(value);
//        }
//        for (int value : arr2) {
//            set.add(value);
//        }
//        // Add all unique elements to the ArrayList
//        union.addAll(set);

        return union;
    } */
}

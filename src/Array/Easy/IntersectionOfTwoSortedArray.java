package Array.Easy;

import java.util.*;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int []arr1 = {1,2,2,3,3,3,4,5,6,6,7};
        int []arr2 = {2,3,3,4,4,5,6,7,8};
        ArrayList<Integer> result = findIntersection(arr1,arr2);
        System.out.print("Intersection of arr1 and arr2 is : ");
        for (int value: result) {
            System.out.print(value + " ");
        }
    }

    // T.C:- O(n1 + n2) , S.C:- O(1)
    static ArrayList<Integer> findIntersection(int []arr1, int []arr2){
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0,j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            }
            else {
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }
}
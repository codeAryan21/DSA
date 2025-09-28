package Array.Easy;

import java.util.*;

public class LargestElement {
    public static void main(String[] args) {
        int []arr1 = {4,2,9,6,8};
        System.out.println("Largest element is: " + sort(arr1));
        System.out.println("Largest element is: " + largestElement(arr1));
    }

    // T.C:- O(N*log(N)) , S.C:-O(n)
    static int sort(int []arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    // T.C:- O(N) , S.C:-O(1)
    static int largestElement(int []arr){
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest){
                largest =  arr[i];
            }
        }
        return largest;
    }
}

package Array.Easy;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int []arr = {1,0,4,5,0,0,8,9,0,0,2,3};
        moveZeros(arr);
        System.out.println("Array after all zeros to end : " + Arrays.toString(arr));
    }

    // T.C:- O(N) , S.C:-O(1)
    static void moveZeros(int []arr){
        // This is for finding the first zero in the array
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        // after finding the first 0, we start iterating from the next element to j, i.e.(j+1)
        for (int i = j+1; i < arr.length; i++) {
            if(arr[i] != 0){
                // swap a[i] & a[j]:
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}

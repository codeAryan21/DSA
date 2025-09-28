package Array.Hard;

import java.util.*;

public class CountInversion {
    public static void main(String[] args) {
        int []arr = {5, 3, 2, 4, 1};
        System.out.println("The number of inversions are: " + numberOfInversions(arr));
    }

    static int merge(int []arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid+1; // starting index of right half of arr

        // Modification 1: count variable to count the pairs
        int count = 0;

        // storing elements in the temporary array in a sorted manner
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            // right is smaller
            else {
                temp.add(arr[right]);
                count += (mid - left + 1); // Modification 2
                right++;
            }
        }

        // if elements on the left half are still left
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return count; // Modification 3
    }

     static int mergeSort(int []arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2 ;
        count += mergeSort(arr, low, mid);  // left half
        count += mergeSort(arr, mid + 1, high); // right half
        count += merge(arr, low, mid, high);  // merging sorted halves
        return count;
    }

    // we have to find the number of pairs where arr[left] > arr[right]
    static int numberOfInversions(int []arr){
        // Count the number of pairs
        return mergeSort(arr,0, arr.length - 1);
    }
}

/*
Problem is the right element is less than the left element in the array
*/

package Array.Medium;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=array
public class NextPermutation {
    public static void main(String[] args) {
        int []arr = {1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    // T.C.- O(3N)
    static void nextPermutation(int []arr){
        // Step 1: Find the break point:
        int idx = -1; // break point
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]){
                // index i is the break point
                idx = i;
                break;
            }
        }

        // edge case:- if there is no break point then reverse the whole array that is your ans
        if(idx == -1){
            reverse(arr,0,arr.length-1);
            return;
        }

        // Step 2: Find the next greater element and swap it with arr[idx]
        for (int i = arr.length-1; i >= idx; i--) {
            if (arr[i] > arr[idx]){
                // swap (arr[i] and arr[idx])
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        // Step 3: reverse the right half
        reverse(arr,idx+1, arr.length-1);
    }

    static void reverse(int []arr,int start,int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

/*
1- find the longest prefix or the break point i.e.(arr[i] < arr[i+1])
2- find the next greater element but the smaller one so that u stay close
3- try to the remaining element in the sorted order
 */

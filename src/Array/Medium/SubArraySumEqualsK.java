package Array.Medium;

import java.util.*;

// https://leetcode.com/problems/subarray-sum-equals-k/?envType=problem-list-v2&envId=array
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int []arr = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println("The number of subArrays is: " + subArraySum(arr,3));
    }

    static int subArraySum(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>(); // <Integer,Integer> is the prefixSum and count as key value pair.
        int prefixSum = 0, count = 0;

        map.put(0,1); // Initially the prefixSum is 0 so we enter this in map as {key value pair} prefixSum 0 and count is 1.
        for (int i = 0; i < arr.length; i++) {
            // add current element to prefix Sum
            prefixSum = prefixSum + arr[i];
            // Calculate x-k
            int remove = prefixSum - k;
            // Add the number of subArrays to be removed
            count += map.getOrDefault(remove, 0); // 0 is the default value returned if the key remove is not found in the map.

            // Update the count of prefix sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    /*
    public static int subArraySum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int count = 0; // Number of subArrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subArray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
     */
}

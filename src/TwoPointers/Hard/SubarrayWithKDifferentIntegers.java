package TwoPointers.Hard;

import java.util.*;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarrayWithKDifferentIntegers{
    public static void main(String[] args) {
        int []arr = {1,2,1,2,3};
        int k = 2;
        System.out.println("The number of sunArray with K different integers is: " + subarraysWithKDistinct(arr,k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArraysWithKDistinct(nums, k) - countSubArraysWithKDistinct(nums, k - 1);
    }

    public static int countSubArraysWithKDistinct(int []arr,int k){
        int l = 0, r = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r < arr.length){
            // Add or update frequency in the map
            map.put(arr[r], map.getOrDefault(arr[r] , 0) + 1);
            // If there are more than K integers then shrink window from left
            while(map.size() > k){
                // reduce the frequency of a digit from a map
                map.put(arr[l], map.get(arr[l]) - 1);
                // if the count/frequency of the digits is 0 in the map then remove the digit
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}

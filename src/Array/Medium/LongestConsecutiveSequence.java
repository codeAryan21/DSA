package Array.Medium;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=array
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int []arr = {1,5,51,3,53,4,54};
        System.out.println("The longest consecutive sequence is: " + longestConsecutive(arr));

        int[] a = {100, 200, 1, 2, 3, 4};
        System.out.println("The longest consecutive sequence is: " + longestSuccessiveElement(a));
    }

    static int longestSuccessiveElement(int []arr){
        if (arr.length == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        // first we put all the array elements into set
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // Find the longest sequence
        for (int it : set){
            // if 'it' is a starting number
            if(!set.contains(it - 1)){
                // find consecutive numbers
                int counter = 1;
                int x = it;
                while (set.contains(x + 1)){
                    x = x+1;
                    counter++;
                }
                longest = Math.max(longest,counter);
            }
        }
        return longest;
    }

    static int longestConsecutive(int []arr){
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        int countCurrent = 0;

        if (arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        //find longest sequence:
        for (int i = 0; i < arr.length; i++) {
            // if arr[i] has to be the part of sequence then arr[i-1] is == to the lastSmaller
            if(arr[i]-1 == lastSmaller){
                // a[i] is the next element of the current sequence.
                countCurrent++;
                lastSmaller = arr[i];
            }else if(arr[i] != lastSmaller){
                countCurrent = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest,countCurrent);
        }
        return longest;
    }
}

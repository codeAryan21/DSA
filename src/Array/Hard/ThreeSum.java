package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=array
public class ThreeSum {
    public static void main(String[] args) {
        int []arr = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum(arr);
        System.out.print("The triplets are: ");
        for (List<Integer> it : ans){
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
    }

    static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        // sort the given array
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            // remove duplicates
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int j = i+1; // j is pointing next to i
            int k = arr.length-1; // k is pointing at the last element
            while (j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0){
                    k--;
                } else if (sum < 0) {
                    j++;
                }else {
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    // skip the duplicates
                    while (j < k && arr[j] == arr[j-1]) j++;
                    while (j < k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
}


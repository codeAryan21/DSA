package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/4sum/description/?envType=problem-list-v2&envId=array
public class FourSum {
    public static void main(String[] args) {
        int []arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans = fourSum(arr,0);
        System.out.print("The quadruplets are: ");
        for (List<Integer> it : ans){
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
    }

    static List<List<Integer>> fourSum(int []arr,int target){
        List<List<Integer>> ans = new ArrayList<>();
        // sort the given array
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            // avoid the duplicates while moving i
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            for (int j = i+1; j < arr.length; j++) {
                // // avoid the duplicates while moving j
                if(j > i+1 && arr[j] == arr[j-1]){
                    continue;
                }

                int k = j+1; // k is pointing to next to j
                int l = arr.length - 1; // l is pointing to the last element
                while (k < l){
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if (sum > target){
                        l--;
                    } else if (sum < target) {
                        k++;
                    }else {
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        // skip the duplicates
                        while (k < l && arr[k] == arr[k-1]) k++;
                        while (k < l && arr[l] == arr[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}

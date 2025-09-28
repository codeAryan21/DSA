package Array.Medium;

import java.util.*;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int []arr = {2,5,4,7,9,6};
//        int[] index = twoSum(arr,12);
//        System.out.print(Arrays.toString(index));
//        System.out.println(twoSum(arr,16));

        int[] index = toSum(arr,12);
        System.out.print(Arrays.toString(index));
    }

    static int[] toSum(int []arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int more = target - num;
            if(map.containsKey(more)){
                return new int[]{map.get(more), i};
            }
            map.put(num,i);
        }
        return new int[] {};
    }


    static boolean twoSum(int []arr,int target){
       /*
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    return true;
                }
            }
        }
        */

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return true;
            } else if (sum < target) {
                left++;
            }else {
                right--;
            }
        }
        return false;
    }

    /*
    static int[] twoSum(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    return new int []{i,j};
                }
            }
        }
        return new int[] {};
    }
    */
}

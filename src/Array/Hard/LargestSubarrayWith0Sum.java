package Array.Hard;

import java.util.*;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int []arr = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(arr));
        System.out.println("The maximum subArray length is: " + maxLen(arr));
    }

    static int maxLen(int []arr){
        int length = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0){
                length = i+1;
            }else {
                if(map.get(sum) != null){
                    length = Math.max(length,i-map.get(sum));
                }else {
                    map.put(sum,i);
                }
            }
        }
        return length;
    }

    static int solve(int []arr){
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum == 0){
                    length = Math.max(length,j-i+1);
                }
            }
        }
        return length;
    }
}

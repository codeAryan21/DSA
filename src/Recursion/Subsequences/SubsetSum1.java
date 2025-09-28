package Recursion.Subsequences;

import java.util.*;

public class SubsetSum1 {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        List<Integer> ans = new ArrayList<>();
        subSet(0,arr,0,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    static void subSet(int index, int []arr, int sum, List<Integer> list){
        if(index >= arr.length){
            list.add(sum);
            return;
        }
        // include current element
        subSet(index+1,arr,sum+arr[index],list);
        // exclude current element
        subSet(index+1,arr,sum,list);
    }
}

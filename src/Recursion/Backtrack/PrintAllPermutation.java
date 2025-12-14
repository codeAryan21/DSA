package Recursion.Backtrack;

import java.util.*;

// https://leetcode.com/problems/permutations/?envType=problem-list-v2&envId=array
public class PrintAllPermutation {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        List<List<Integer>> ans = allPermutation(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> allPermutation(int []arr){
        List<List<Integer>> ans = new ArrayList<>();
        permutation(0,arr,ans);
        return ans;
    }

    static void permutation(int index,int []arr,List<List<Integer>> ans){
        if(index >= arr.length){
            // make a copy of current permutation
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr,i,index); // select the element
            permutation(index+1,arr,ans); // explore all the element
            swap(arr,i,index); // un-select the element (backtrack)
        }
    }

    static void swap(int []arr,int start,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

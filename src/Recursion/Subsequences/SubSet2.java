package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/subsets-ii/description/
public class SubSet2 {
    public static void main(String[] args) {
        int []arr = {1,2,2};
        List<List<Integer>> ans = subsetsWithDup(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subsetsWithDup(int []arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        printSubset(0,arr,new ArrayList<>(),ans);
        return ans;
    }

    static void printSubset(int index,int []arr,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            printSubset(i+1,arr,list,ans);
            list.remove(list.size()-1);
        }
    }
}

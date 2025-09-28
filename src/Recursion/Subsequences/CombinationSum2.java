package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2 {
    public static void main(String[] args) {
        int []arr = {2,5,2,1,2};
        List<List<Integer>> ans = combinationSum2(arr,5);
        System.out.println(ans);
    }

    static  List<List<Integer>> combinationSum2(int []arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombination(0, arr, target, new ArrayList<>(), ans);
        return ans;
    }

    static void findCombination(int index,int []arr,int target,List<Integer> list,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            list.add(arr[i]);
            findCombination(i+1,arr,target-arr[i],list,ans);
            list.remove(list.size()-1);
        }
    }
}

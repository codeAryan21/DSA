package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum1 {
    public static void main(String[] args) {
        int []arr = {2,3,5};
        List<List<Integer>> ans = combinationSum(arr,8);
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSum(int []arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,arr,target,new ArrayList<>(),ans);
        return ans;
    }

    static void findCombination(int index,int []arr,int target,List<Integer> list,List<List<Integer>> ans){
        if (index >= arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[index] <= target){
            list.add(arr[index]);
            findCombination(index,arr,target-arr[index],list,ans);
            list.remove(list.size()-1);
        }
        findCombination(index+1,arr,target,list,ans);
    }
}

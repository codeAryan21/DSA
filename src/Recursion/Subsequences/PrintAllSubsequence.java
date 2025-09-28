package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/subsets/description/
public class PrintAllSubsequence {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        List<Integer> ans = new ArrayList<>();
        printSubsequence(0,arr,ans);
        System.out.println();

        subSequenceWithSumK(0,arr,0,3,ans);
        System.out.println();
        subSequenceWithSumK1(0,arr,0,3,ans);

        int count = countSubSequenceWithSumK(0,arr,0,3,ans);
        System.out.println(count);

    }

    static void printSubsequence(int index, int []arr, List<Integer> list){
        if(index >= arr.length){
            System.out.print(list + " ");
            return;
        }
        // include current element
        list.add(arr[index]);
        printSubsequence(index+1,arr,list);
        list.remove(list.size()-1);  // backtrack: remove last added element
        // exclude current element
        printSubsequence(index+1,arr,list);
    }

    static void subSequenceWithSumK(int index,int []arr,int sum,int k,List<Integer> list){
        if(index >= arr.length){
            if (sum == k) {
                System.out.print(list + " ");
            }
            return;
        }
        list.add(arr[index]);
        sum += arr[index];
        subSequenceWithSumK(index+1,arr,sum,k,list);
        sum -= arr[index];
        list.remove(list.size()-1);
        subSequenceWithSumK(index+1,arr,sum,k,list);
    }

    static boolean subSequenceWithSumK1(int index,int []arr,int sum,int k,List<Integer> list){
        if (index >= arr.length){
            if (sum == k){
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        sum += arr[index];
        if (subSequenceWithSumK1(index+1,arr,sum,k,list) == true){
            return true;
        }
        sum -= arr[index];
        list.remove(list.size()-1);
        if(subSequenceWithSumK1(index+1,arr,sum,k,list) == true){
            return true;
        }
        return false;
    }

    static int countSubSequenceWithSumK(int index,int []arr,int sum,int k,List<Integer> list){
        if (index >= arr.length){
            if (sum == k){
                return 1;
            }
            return 0;
        }
        list.add(arr[index]);
        sum += arr[index];
        int left = countSubSequenceWithSumK(index+1,arr,sum,k,list);

        sum -= arr[index];
        list.remove(list.size()-1);
        int right = countSubSequenceWithSumK(index+1,arr,sum,k,list);

        return (left + right);
    }

    /*
    static int countSubSequenceWithSumK(int index,int []arr,int sum,int k){
        if (index >= arr.length){
            if (sum == k){
                return 1;
            }
            return 0;
        }
        sum += arr[index];
        int left = countSubSequenceWithSumK(index+1,arr,sum,k);

        sum -= arr[index];
        int right = countSubSequenceWithSumK(index+1,arr,sum,k);

        return (left + right);
    }
     */

}

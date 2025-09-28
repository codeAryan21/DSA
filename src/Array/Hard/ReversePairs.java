package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/reverse-pairs/description/?envType=problem-list-v2&envId=array
public class ReversePairs {
    public static void main(String[] args) {
        int []arr = {40,25,19,12,9,6,2};
//        System.out.println(reversePairsBrute(arr));
        System.out.println("The number of reverse pair is: " + reversePair(arr));
    }

    static void merge(int []arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;    // starting index of left half of arr
        int right = mid + 1;  // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    static int countPairs(int []arr,int low,int mid,int high){
        int count = 0;
        int right = mid+1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]){
                right++;
            }
            count += (right-(mid + 1));
        }
        return count;
    }

    static int mergeSort(int []arr,int low,int high){
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr,low,mid); // left half
        count += mergeSort(arr,mid+1,high);  // right half
        count += countPairs(arr,low,mid,high); // Modification
        merge(arr,low,mid,high);  // merging sorted halves
        return count;
    }

    static int reversePair(int []arr){
        return mergeSort(arr,0,arr.length-1);
    }

    /*
    static int reversePairsBrute(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > 2L*nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    */
}


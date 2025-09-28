package Array.Medium;

// https://leetcode.com/problems/sort-colors/description/?envType=problem-list-v2&envId=array
public class Sort0s1s2s {
    public static void main(String[] args) {
        int []arr = {0,1,2,0,1,2,0,0,1,2,2,1,0,1};
        sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void sortArray(int []arr){
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high){
            if(arr[mid] == 0){
                // swap arr[low] and arr[mid]
                swap(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            }else{
                // swap arr[mid] and arr[high]
                swap(arr,mid,high);
                high--;
            }
        }
    }

    static void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Dutch national flag algorithm:-
we have to take three pointers low, mid and high. And the code will run till while (mid <= high)
[0 .... low-1] -> 0 (extreme left)
[low .... mid-1] -> 1
from [mid to high] -> it remains unsorted i.e. (mixture of 0,1 & 2);
[high+1 .... n-1] -> 2 (extreme right)

here we make 3 cases, these 3 are use to solve { from [mid to high] } this section.
1. arr[mid == 0] :- swap(arr[low],arr[mid]) and low++, mid++
2. arr[mid == 1] :- mid++
3. arr[mid == 2] :- swap(arr[mid],arr[high]) and high--
*/

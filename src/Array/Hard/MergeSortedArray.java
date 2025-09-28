package Array.Hard;

// https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=array
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};
        merge(arr1,arr2,arr1.length,arr2.length);
        System.out.println("The merged arrays are:");
        System.out.print("arr1 = [ ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("] \narr2 = [ ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.print("]");
    }

    static void merge(int []arr1,int []arr2,int n,int m){
        int length = (n + m);
        int gap = (length / 2) + (length % 2);
        while (gap > 0){
            int left = 0;
            int right = (left + gap);
            while (right < length){
                // case 1: left in arr1[] and right in arr2[]
                if(left < n && right >= n){
                    swap(arr1,arr2,left,right-n);
                }
                // case 2: both pointers in arr2[]
                else if (left >= n) {
                    swap(arr2,arr2,left-n,right-n);
                }
                // case 3: both pointers in arr1[]
                else {
                    swap(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed
            if(gap == 1) break;
            // Otherwise, calculate new gap
            gap = (gap / 2) + (gap % 2);
        }
    }

    static void swap(int []arr1,int []arr2,int a,int b){
        // if the value of arr1[a] is greater than the value of arr2[b] then we swap each other.
        if (arr1[a] > arr2[b]){
            int temp = arr1[a];
            arr1[a] = arr2[b];
            arr2[b] = temp;
        }
    }

/*
    static void merge(int []arr1,int []arr2,int n,int m){
        int left = n-1;
        int right = 0;
        // Swap the elements until arr1[left] is smaller than arr2[right]:
        while (left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else {
                break;
            }
        }
        // Sort arr1[] and arr2[] individually
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
 */

}

package BinarySearch.BS1D;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class
FirstAndLastOccurrences {
    public static void main(String[] args) {
        int []arr = {2,4,6,8,8,8,11,13};
        int []ans = firstAndLast(arr,8);
        System.out.println("The first and last occurrences are: [" + ans[0] + ", " + ans[1] + "]");

        int []ans1 = findFirstAndLast(arr,8);
        System.out.println("The first and last occurrences are: [" + ans[0] + ", " + ans[1] + "]");
    }

    static int[] findFirstAndLast(int []arr,int target){
        int first = firstOccurrence(arr,target);
        if (first == -1) return new int[] {-1,-1};
        int last = lastOccurrence(arr,target);
        return new int[] {first,last};
    }

    static int firstOccurrence(int []arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return first;
    }

    static int lastOccurrence(int []arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int last = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return last;
    }


    static int[] firstAndLast(int[] arr, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first,last};
    }
}


/*
if we want to solve using lowerBound and upperBound
if( lb(x) == arr.length || arr[lb] != x){
return new int[] {-1,-1}
}else{
return {lb,up-1}
*/

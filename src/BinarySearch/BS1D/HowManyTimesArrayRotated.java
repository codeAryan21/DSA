package BinarySearch.BS1D;

public class HowManyTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println("Array is rotated " + findRotation(arr) + " times.");
        System.out.println("The array is rotated " + findKRotation(arr) + " times.");
    }

    static int findRotation(int []arr){
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int rotation = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            // if the entire array is already sorted then the number of rotation is 0.
            if(arr[low] <= arr[high]){
                if(arr[low] < min){
                    rotation = low;
                    min = arr[low];
                }
                break;
            }

            // for the duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            if(arr[low] <= arr[mid]){
                if(arr[low] < min){
                    rotation = low;
                    min = arr[low];
                }
                low = mid + 1;
            }else {
                if(arr[mid] < min){
                    rotation = mid;
                    min = arr[mid];
                }
                high = mid - 1;
            }
        }
        return rotation;
    }

    static int findKRotation(int []arr){
        int min = Integer.MAX_VALUE;
        int rotation = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
                rotation = i;
            }
        }
        return rotation;
    }
}


/*
    // int[] arr = {4,4,5,6,7,4,4,4,4};
    static int findPivot(int []arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid+1;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid-1+2;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

 */

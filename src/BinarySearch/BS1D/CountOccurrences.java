package BinarySearch.BS1D;

public class CountOccurrences {
    public static void main(String[] args) {
        int []arr = {2,4,6,8,8,8,11,13};
        System.out.println("The number of occurrences is: " + count(arr,11));

        System.out.println("The number of occurrences is: " + countOccurrence(arr,8));
    }

    static int countOccurrence(int []arr,int target){
        int start = firstOccurrence(arr,target);
        if (start == -1) return 0; // target not found
        int end = lastOccurrence(arr,target);
        int count = (end - start) + 1;
        return count;
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

    static int count(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                count++;
            }
        }
        return count;
    }
}


package BinarySearch.BS1D;

// https://leetcode.com/problems/binary-search/description/?envType=problem-list-v2&envId=binary-search
public class BinarySearch {
    public static void main(String[] args) {
        int []arr = {2,4,5,7,9,11,12,14,16,18,19};
        System.out.println("The target element is at index: " + binarySearch(arr,7));
        System.out.println("The target element is at index: " + recursionBinary(arr,0,arr.length-1,18));
    }

    static int binarySearch(int []arr,int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    static int recursionBinary(int []arr,int low,int high,int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return recursionBinary(arr,low,mid-1,target);
        }else{
            return recursionBinary(arr,mid+1,high,target);
        }
    }
}

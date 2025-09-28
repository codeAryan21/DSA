package BinarySearch.Answers;

// https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int []arr = {7,2,5,10,8};
        System.out.println("The answer is: " + splitArray(arr,2));
    }

    static int countPartitions(int []arr,int maxSum){
        int partitions = 1;
        int subarraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(subarraySum + arr[i] <= maxSum){
                // insert element to current subArray
                subarraySum += arr[i];
            }else{
                // insert element to next subArray
                partitions++;
                subarraySum = arr[i];
            }
        }
        return partitions;
    }

    static int splitArray(int []arr, int k) {
        if(k > arr.length){
            return -1;
        }
        int low = arr[0];
        int high = 0;
        // find low and high or maximum and summation
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low,arr[i]);
            high += arr[i];
        }

        while (low <= high){
            int mid = low + (high - low) / 2;
            int partition = countPartitions(arr,mid);
            if(partition <= k){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}

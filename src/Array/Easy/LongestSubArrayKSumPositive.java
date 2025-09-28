package Array.Easy;

public class LongestSubArrayKSumPositive {
    public static void main(String[] args) {
        int []arr = {1,1,2,1,1,1,2,3,5,4,6};
        System.out.print("The length of longest subArray is : " + findSum(arr,3));
    }

    static int findSum(int []arr,int k){
        int left = 0,right = 0;
        int sum = arr[0];
        int length = 0;
        while (right < arr.length){
            // if sum > k, reduce the subarray from left until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            // if sum = k, update the length i.e. answer:
            if (sum == k) {
                length = Math.max(length, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < arr.length){
                sum += arr[right];
            }
        }
        return length;
    }


    /*
    // T.C:- O(N^2) , S.C:-O(1)
    static int findSum(int []arr,int k){
        int length = 0;
        for (int i = 0; i < arr.length; i++) { // starting index
            int sum = 0;
            for (int j = i; j < arr.length; j++) { // ending index
                // add the current element to the subarray a[i...j-1]:
                sum += arr[j];
                if(sum == k){
                    length = BinarySearch.BS2D.Math.max(length,j-i+1);
                }
            }
        }
        return length;
    } */
}

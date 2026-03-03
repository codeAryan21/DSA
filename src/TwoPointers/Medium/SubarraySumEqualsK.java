package TwoPointers.Medium;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int []arr = {1,3,1,3,1,3};
        int k = 4;
        System.out.println("The number of subarray whose sum equals to K is: " + subarraySum(arr,k));
    }

    // for the positive numbers
    public static int subarraySum(int[] arr, int k) {
        if(k == 0 || arr.length == 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;
        while(r < arr.length){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }
            if(sum == k){
                count++;
            }
            r++;
        }
        return count;
    }
}

package BinarySearch.Answers;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class SmallestDivisorWithThreshold {
    public static void main(String[] args) {
        int []arr = {1, 2, 5, 9};
        int ans = smallestDivisor(arr, 6);
        System.out.println("The minimum divisor is: " + ans);
    }

    static int SumAndDivideByD(int []arr,int div){
        int sum = 0;
        // Find the summation of division values
        for(int i=0;i<arr.length;i++){
            sum += (int) Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }

    static int smallestDivisor(int []arr,int threshold){
        if(arr.length > threshold) return -1;
        int low = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int high = max;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int ansPossible = SumAndDivideByD(arr,mid);
            if(ansPossible <= threshold){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}

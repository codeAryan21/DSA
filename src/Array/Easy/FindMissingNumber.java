package Array.Easy;

public class FindMissingNumber {
    public static void main(String[] args) {
        int []arr = {1,2,4,5};
        System.out.print("The missing number is : " + missingNumber(arr));
    }

     static int missingNumber(int []arr){
        int n = arr.length;
        // Summation of first N numbers
        int sum = (n*(n+1))/2;
        // Summation of all the array elements
        int s2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            s2 += arr[i];
        }
        return (sum - s2); // after subtracting we get the missing number;
    }

    /*
    // XOR method
    static int missingNumber(int []arr){
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            xor2 = xor2 ^ arr[i]; // XOR of array elements
            xor1 = xor1 ^ (i+1); //XOR up to [1...arr.length-1]
        }
        xor1 = xor1 ^ arr.length; // XOR up to [1...arr.length]
        return (xor2 ^ xor1);
     }
     */
}

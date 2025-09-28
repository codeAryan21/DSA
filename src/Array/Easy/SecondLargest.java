package Array.Easy;

//  https://www.geeksforgeeks.org/problems/second-largest3735/1
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 9, 1, 7};
        System.out.println("Second largest element is: " + secondLargest(arr));
        System.out.println("Second smallest element is: " + secondSmallest(arr));
    }
    // T.C:- O(N) , S.C:-O(1)
    // Second Largest
    static int secondLargest(int []arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest){
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] != largest && arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        if(secLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secLargest;
    }

    // Second smallest
    static int secondSmallest(int []arr) {
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest){
                secSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < secSmallest) {
                secSmallest = arr[i];
            }
        }
        if (secSmallest == Integer.MAX_VALUE) {
            return -1;
        }
        return secSmallest;
    }
}

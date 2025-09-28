package Array.Easy;

public class LeftRotateByDPlace {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7};
        leftRotate(arr,3);
        System.out.print("Array after Rotating the d elements to left : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        rightRotate(arr,6);
        System.out.print("\nArray after Rotating the d elements to right : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Function to Rotate k elements to left
    // T.C:- O(N) , S.C:-O(1)
    static void leftRotate(int []arr,int d){
        int n = arr.length;
        d = d % n;
        // first reverse d elements
        reverse(arr,0,d-1);
        // reverse the remaining element (n-d)
        reverse(arr,d,n-1);
        // reverse the whole array
        reverse(arr,0,n-1);
    }

    static void rightRotate(int []arr,int d){
        int n = arr.length;
        d = d % n;
        // first reverse the last d elements
        reverse(arr,n-d,n-1);
        // reverse the first remaining (n-d) elements
        reverse(arr,0,n-d-1);
        // reverse the whole array
        reverse(arr,0,n-1);
    }

    // Function to Reverse the array
    static void reverse(int []arr,int start,int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

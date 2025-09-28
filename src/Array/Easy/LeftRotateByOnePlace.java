package Array.Easy;

public class LeftRotateByOnePlace {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        leftRotate(arr);
    }

    // T.C:- O(N) , S.C:-O(1)
    static void leftRotate(int []arr){
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.print("The array after rotating left by one place is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package Array.Easy;

public class LinearSearch {
    public static void main(String[] args) {
        int []arr = {3,1,4,2,6,5,4};
        System.out.println("The target element is present at index " + search(arr,5));
    }

    // T.C:- O(N) , S.C:-O(1)
    static int search(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}

package Array.Easy;

//  https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
public class CheckArraySorted {
    public static void main(String[] args) {
        int []arr = {1,2,3,3,4,5,5};
        System.out.println(isArraySorted(arr));
    }

    // T.C:- O(N) , S.C:-O(1)
    static boolean isArraySorted(int []arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= arr[i-1]){

            } else {
                return false;
            }
        }
        return true;
    }
}

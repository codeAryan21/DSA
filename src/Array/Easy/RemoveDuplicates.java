package Array.Easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=array
// https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1
public class RemoveDuplicates {
    public static void main(String[] args) {
        int []arr = {1,2,2,3,3,3,4,4,4,4};
        int k = removeDuplicates(arr);
        System.out.print("The array after removing the duplicates is : ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // T.C:- O(N) , S.C:-O(1)
    static int removeDuplicates(int []arr){
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]){
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return (i+1);
    }
}

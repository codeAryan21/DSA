package Array.Medium;

import java.util.*;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/?envType=problem-list-v2&envId=array
public class RearrangeElement {
    public static void main(String[] args) {
        int []arr = {-1,2,4,-5,-4,5};
        int []ans = rearrangeArray(arr);
        System.out.println("The array after rearranging element in alternate way: " + Arrays.toString(ans));


        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));
        ArrayList<Integer> ans1 = rearrangeBySign(A);
        for (int i = 0; i < ans1.size(); i++) {
            System.out.print(ans1.get(i) + " ");
        }
    }

    // This is for the array of even size and all the positive and negative element is of same size (n/2);
    static int[] rearrangeArray(int []arr){
        int []arr1 = new int[arr.length];
        int posSign = 0; // posSign means storing the element with +ve sign at the even index (i.e.- 0,2,4,...)
        int negSign = 1;  // negSign means storing the element with -ve sign at the odd index (i.e.- 1,3,5,...)
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                arr1[posSign] = arr[i];
                posSign += 2;
            }else {
                arr1[negSign] = arr[i];
                negSign += 2;
            }
        }
        return arr1;
    }

    public static ArrayList<Integer> rearrangeBySign(ArrayList<Integer> A) {
        // Define 2 ArrayLists, one for storing positive and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i) > 0){
                pos.add(A.get(i));
            }else{
                neg.add(A.get(i));
            }
        }

        // there might be only 2 cases either positive is greater than negative or negative is greater that positive
        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }
}

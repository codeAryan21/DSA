package BinarySearch.Answers;

public class KthElementOf2SortedArray {
    public static void main(String[] args) {
        int []arr1 = {1, 3, 4, 7, 10, 12};
        int []arr2 = {2, 3, 6, 15};
        int k = 8;
        System.out.println("The " + k + "th element of two sorted arrays is " + kthElement(arr1,arr2,k));
    }

    static int kthElement(int []arr1,int []arr2,int k){
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1 > n2){
            return kthElement(arr2,arr1,k);
        }

        int left = k; // length of left half
        int low = Math.max(0,k-n2);
        int high = Math.min(n1,k);
        while (low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            // calculate l1, l2, r1 and r2
            int l1 = mid1 > 0 ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? arr2[mid2] : Integer.MAX_VALUE;
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            } else if (l1 > r2) { // eliminate the halves
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}

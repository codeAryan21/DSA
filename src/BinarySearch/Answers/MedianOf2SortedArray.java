package BinarySearch.Answers;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class MedianOf2SortedArray {
    public static void main(String[] args) {
        int []arr1 = {1, 3, 4, 7, 10, 12};
        int []arr2 = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(arr1,arr2));
    }

    static double findMedianSortedArrays(int []arr1, int []arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        // we always have to perform binary search on smaller arr, if my arr1 is greater than arr2 then we perform binary search on arr2
        // if n1 is bigger swap the arrays
        if(n1 > n2){
            return findMedianSortedArrays(arr2,arr1);
        }

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2; // length of left half
        while (low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            // calculate l1, l2, r1 and r2
            int l1 = (mid1 > 0) ? arr1[mid1-1]: Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2-1]: Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1){
                    return Math.max(l1,l2);
                }else {
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2))) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }

        }
        return 0;
    }
}

/*
if(l1 > r2) high = mid - 1;
if(l2 > r1) low = mid + 1;
*/

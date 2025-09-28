package BinarySearch.BS1D;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElement {
    public static void main(String[] args) {
        int []arr = {1,1,2,3,3,4,4,8,8};
        System.out.println("The single element in the array is: " + findNonDuplicate(arr));
    }

    static int findNonDuplicate(int []arr){
        int n = arr.length;

        // Edge cases
        if(n == 1){
            return arr[0];
        }
        if(arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }

        int low = 1;
        int high = n-2;
        while (low <= high){
            int mid =  low + (high - low) / 2;

            // If arr[mid] is the single element
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }

            // We are in the left i.e. (even,odd)
            if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 == 1 && arr[mid] == arr[mid-1])){
                low = mid + 1;
            }
            // We are in the right i.e. (odd,even)
            else {
                high = mid - 1;
            }
        }
        return -1;
    }


/*
    static int findSingle(int []arr){
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }
*/
}

/*
if (even,odd) --> element is on the right half {eliminate left half}
if (odd,even) --> element is on the left half {eliminate right half}
*/

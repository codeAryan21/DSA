package BinarySearch.BS1D;

public class FindPivot {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(findPivot(arr));
    }

    static int findPivot(int []arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}

/*
when u will find pivot?
There are 4 cases for finding pivot:-
1: If at any point my [mid] element is > [mid+1] i.e we find pivot  ans --> [mid]
2: If [mid] element is < [mid-1] i.e we find pivot  ans --> [mid-1]
3: if(arr[mid] <= arr[start]){
        end = mid - 1;
   }

4: else{
       start = mid + 1;
   }

*/

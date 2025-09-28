package BinarySearch.BS1D;

public class FloorAndCeil {
    public static void main(String[] args) {
        int []arr = {10,20,30,40,50};
        int []ans = findFloorCeil(arr,25);
        System.out.println("The floor and ceil are: [" + ans[0] + ", " + ans[1] + "]");
    }

    static int[] findFloorCeil(int []arr,int x){
        int f = findFloor(arr,x);
        int c = findCeil(arr,x);
        return new int[]{f,c};
    }

    static int findFloor(int []arr,int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x) {
                ans = arr[mid]; // possible floor
                low = mid + 1;  // look for a higher one
            }else{
                high = mid - 1;  // move left
            }
        }
        return ans;
    }

    static int findCeil(int []arr,int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid]; // possible ceil
                high = mid - 1; // Try to find smaller ceil on the left
            }else {
                low = mid + 1;  // Move right
            }
        }
        return ans;
    }
}

/*
Floor --> largest number in the array <= x;
Ceil --> smallest number in the array >= x;
*/
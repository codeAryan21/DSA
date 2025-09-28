package BinarySearch.Answers;

public class SqrtInteger {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(floorSqrt(n));
        System.out.println(Math.floor(Math.sqrt(n)));
        System.out.println(findSqrt(n));
    }

    static int floorSqrt(int n){
        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if((mid * mid) <= n){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans; // or we return high both are same
    }

    static int findSqrt(int n){
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if(i * i <= n){
                ans = i;
            }else {
                break;
            }
        }
        return ans;
    }
}

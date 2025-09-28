package BinarySearch.Answers;

public class NthRootOfM {
    public static void main(String[] args) {
        int n = 4, m = 16;
        System.out.println("The answer is: " + NthRoot(n, m));
        System.out.println("Answer is: " + NthROOT(n, m));
    }

    // Return 1 if mid == m
    // Return 0 if mid < m
    // Return 2 if mid > m
    static int func(int mid,int n,int m){
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if(ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    static int NthRoot(int n,int m){
        int low = 1;
        int high = m;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int ans = func(mid,n,m);
            if (ans == 1){
                return mid;
            }else if (ans == 0){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int NthROOT(int n,int m){
        for (int i = 1; i <= m; i++) {
            long val  = (long) Math.pow(i,n);
            if(val == (long)m){
                return i;
            }else if(val > (long) m){
                break;
            }
        }
        return -1;
    }
}

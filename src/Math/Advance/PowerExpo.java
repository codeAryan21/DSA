package Math.Advance;

// https://leetcode.com/problems/powx-n/
public class PowerExpo {
    public static void main(String[] args) {
        double x = 2.1;
        int n = 3;
        System.out.println(x + " power " + n + " is: " + findPowerExpo(x,n));

        // power(x,n);
    }

    static double findPowerExpo(double x,int n){
        long m = n;
        // if n is negative i.e. negative power like 2^-3 then it becomes 1 / 2^3 --> 1/8
        // in general x^-n becomes (1/x)^n
        if(m < 0){
            x = 1.0/x;
            m = -m;
        }
        double ans = 1.0;
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * x;
                m = m - 1;
            } else {
                m = m / 2;
                x = x * x;
            }
        }
        return ans;
    }

/*
    static void power(int x,int n){
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * x;
        }
        System.out.println(ans);
    }
 */
}

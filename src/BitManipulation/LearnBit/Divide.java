package BitManipulation.LearnBit;

public class Divide {
    public static void main(String[] args) {
        int dividend = 22;
        int divisor = 3;
        System.out.println("Ans: " + divide(dividend,divisor));
    }

    static int divide(int dividend, int divisor) {
        // Special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign using XOR
        boolean negative = (dividend > 0) ^ (divisor > 0);

        // Convert to positive longs
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;

        while (n >= d) {
            long temp = d, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            ans += multiple;
        }

        return negative ? -ans : ans;
    }

}

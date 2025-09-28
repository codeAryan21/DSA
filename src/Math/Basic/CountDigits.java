package Math.Basic;

public class CountDigits {
    public static void main(String[] args) {
        int n = 87123;
        System.out.println("The number of digits in n is: " + countDigits(n));

        int ans = (int)(Math.log10(n) + 1);
        System.out.println("Number of digits is: " + ans);
    }

    static int countDigits(int n){
        int count = 0;
        while (n > 0){
            count++;
            n = n / 10;
        }
        return count;
    }
}

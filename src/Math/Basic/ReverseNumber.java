package Math.Basic;

// https://leetcode.com/problems/reverse-integer/
public class ReverseNumber {
    public static void main(String[] args) {
        int n = 54323;
        System.out.println("Reverse of a number is: " + reverse(n));
    }

    static int reverse(int n){
        int reverseNum = 0;
        while (n != 0){
            int last = n % 10;
            if(reverseNum > Integer.MAX_VALUE / 10 || reverseNum < Integer.MIN_VALUE / 10){
                return 0;
            }
            reverseNum = (reverseNum * 10) + last;
            n = n / 10;
        }
        return reverseNum;
    }
}

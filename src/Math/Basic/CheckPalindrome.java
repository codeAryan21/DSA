package Math.Basic;

// https://leetcode.com/problems/palindrome-number/
public class CheckPalindrome {
    public static void main(String[] args) {
        int n = 1331;
        if (isPalindrome(n)) {
            System.out.println(n + " is a palindrome.");
        } else {
            System.out.println(n + " is not a palindrome.");
        }
    }

    static boolean isPalindrome(int n){
        int original = n;
        int reverseNum = 0;
        if(n < 0) return false;
        while(n > 0){
            int last = n % 10;
            reverseNum = (reverseNum * 10) + last;
            n = n / 10;
        }
        if(reverseNum == original){
            return true;
        }
        return false;
    }
}

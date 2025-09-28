package BitManipulation.LearnBit;

// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(checkNum(n));
    }

    static boolean checkNum(int n){
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}

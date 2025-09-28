package BitManipulation.LearnBit;

// https://leetcode.com/problems/number-of-1-bits/?envType=problem-list-v2&envId=bit-manipulation
public class CountSetBits {
    public static void main(String[] args) {
        int n = 15;
        System.out.println("Count is: " + countSetBits(n));
        System.out.println("Count: " + countSetBit(n));
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    static int countSetBit(int n){
        int count = 0;
        while (n != 0){
            /*
            if ((n & 1) == 1) {  // check last bit using AND
                count++;
            }
            n = n >> 1;   // right shift instead of divide
             */

            if(n % 2 == 1){
                count++;
            }
            n = n / 2;
        }
        return count;
    }
}
/*
n = 13
1101
1100
1000
0000
 */
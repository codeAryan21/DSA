package BitManipulation.Interview;

// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
public class MinimumBitToConvertNumber {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(minBitFlips(start,goal));
    }

    static int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int count = 0;
        while (ans > 0){
            ans = ans & (ans-1);
            count++;
        }
        return count;
    }
}
/*
1010
0111
-----
1101 --> count:- 3
 */
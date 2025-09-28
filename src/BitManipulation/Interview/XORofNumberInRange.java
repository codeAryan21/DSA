package BitManipulation.Interview;

public class XORofNumberInRange {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(findXORFrom1ToN(n));
        System.out.println(findXOR(n));

        int L = 5;
        int R = 15;
        System.out.println("XOR of numbers in range [" + L + ", " + R + "]: " + findXORinRange(L, R));
    }

    static int findXORFrom1ToN(int n){
         int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }
        return xor;
    }

    static int findXOR(int n){
        if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n+1;
        else if(n % 4 == 3) return 0;
        else return n;
    }

    // Function to find the XOR in the range [L, R]
    static int findXORinRange(int L,int R){
        return findXOR(L-1) ^ findXOR(R);
    }
}

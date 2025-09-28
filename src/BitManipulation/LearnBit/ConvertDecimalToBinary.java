package BitManipulation.LearnBit;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        int n = 13;
        System.out.println("Binary of " + n + " is: " + convertToBinary(n));

        String s = "1101";
        System.out.println("Decimal of " + s + " is: " + convertToDecimal(s));
    }

    static String convertToBinary(int n){
        if (n == 0) return "0";
        String result = "";
        while (n > 0) {
            int bit = n % 2;
            result = bit + result; // first we add bit then the result
            n = n / 2;
        }
        return result;
    }

    static int convertToDecimal(String s){
        if (s.equals("0")) return 0;

        int ans = 0;
        int power2 = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '1'){
                ans = ans + power2;
            }
            power2 = power2 * 2;
        }
        return ans;
    }
}

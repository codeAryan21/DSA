package Math.Basic;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 9474;
        if (isArmstrong(n)) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }

    static boolean isArmstrong(int n){
        int original = n;
        int digits = String.valueOf(n).length();
        int sum = 0;
        while(n > 0){
            int last = n % 10;
            sum = (int) (sum + Math.pow(last,digits));
            n = n / 10;
        }
        if(original == sum){
            return true;
        }
        return false;
    }
}

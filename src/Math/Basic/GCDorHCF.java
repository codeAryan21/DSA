package Math.Basic;

public class GCDorHCF {
    public static void main(String[] args) {
        int a = 9;
        int b = 12;
        System.out.println("HCF of " + a + " and " + b + " is: " + findHCF(a,b));
        System.out.println("GCD of " + a + " and " + b + " is: " + findGCD(a,b));
    }

    static int findHCF(int a,int b){
        int hcf = 1;
        for (int i = 1; i <= Math.min(a,b); i++) {
            if(a % i == 0 && b % i == 0){
                hcf = i;
            }
        }
        return hcf;
    }

    static int findGCD(int a,int b){
        while (a > 0 && b > 0){
            if (a > b){
                a = a % b;
            }else {
                b = b % a;
            }
        }
        if(a == 0) return b;
        return a;
    }
}

package Math.Basic;

public class CheckPrime {
    public static void main(String[] args) {
        int n = 11;
        if(isPrime(n)){
            System.out.println(n + " is prime number");
        }else {
            System.out.println(n + " is not prime number");
        }

        System.out.print("Prime number between 1 to 100 is: ");
        for (int i = 2;i<= 100;i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    static boolean isPrime(int n){
        if(n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
